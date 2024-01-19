package json.generator;

import json.Validator;
import json.analysis.ListResult;
import json.analysis.SortReg;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ODHActivitiesFetcher {

    private final Logger logger = LogManager.getLogger(ODHActivitiesFetcher.class);
    private String fileName;

    /**
     * fileName will be the name of the file in resources, which contains the
     * number of the number of activities that should be retrieved
     *
     * @param fileName is the name of the file
     */
    public ODHActivitiesFetcher(String fileName) {
        this.fileName = fileName;
    }

    /**
     * With this method we get the response of the API we are working on
     *
     * @throws IOException with the InputStream if wrong
     */
    public InputStream fetchActivities(int pageSize) throws IOException {
        URL url = new URL("https://tourism.opendatahub.bz.it/api/Activity?pagenumber=1&pagesize=" + pageSize + "&activitytype=1023");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        int status = connection.getResponseCode();
        logger.info("Status: " + status);

        return status > 299? null: connection.getInputStream();
    }

    /**
     * This method create a file for each activity
     *
     * @param importantActivityInfos is the interested activity part
     * @param pageSize is the number of file we create
     */

    public void saveActivities(List<ImportantActivityInfo> importantActivityInfos, int pageSize){
        new JsonFilesHelper(importantActivityInfos, pageSize).writeFiles();
    }

    /**
     * this method deserializes the information got from the API and transforms it
     * into activity objects
     *
     * @param response is teh response of the API
     * @return the list of activities
     * @throws IOException for the InputStream if wrong
     */

    public List<Activity> deserializationActivities(InputStream response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response);
        JsonNode itemsNode = node.get("Items");

        return mapper.readValue(itemsNode.traverse(), new TypeReference<ArrayList<Activity>>(){});
    }

    /**
     * This method will read the file given from the constructor and returns the number in it
     * otherwise it will give  the default number 1.
     *
     * @return the page number or the default value
     */

    public int getPageSize() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(FilesUtils.getFileAsInputStream(fileName)))) {
            int num = Integer.parseInt(reader.readLine());
            if (num < 1) throw new Exception();
            logger.info(num);
            return num;
        } catch (Exception e) {
            logger.error("an error occurred while loading the page size: " + e);
            return 1;
        }
    }

    /**
     * This method saves in a list only the regionID of each activity
     *
     * @param activities the list of activities
     * @return the list of regionID of the list of activities
     */

    public List<String> mapActivityToRegion(List<Activity> activities) {
        List<String> regionsIds=new ArrayList<>();

        for(Activity activity : activities){
            regionsIds.add(activity.getRegionId());
        }

        return regionsIds;
    }

    /**
     * This method filters the list of activities and saves it in a new list
     *
     * @param activities is the list of activities
     * @return the list of activities with filtered information
     * @throws UnsupportedEncodingException if the encoding gives an error
     */

    public List<ImportantActivityInfo> mapActivities(List<Activity> activities) throws UnsupportedEncodingException {
        List<ImportantActivityInfo> importantActivityInfos = new ArrayList<>();

        for (Activity activity : activities) {
            importantActivityInfos.add(new ImportantActivityInfo(
                    activity.id,
                    activity.getName(),
                    activity.getDesc(),
                    activity.getTypes(),
                    activity.hasGpsTrack(),
                    activity.getLocalizedName())
            );
        }

        return importantActivityInfos;
    }

    /**
     * This method collects all the others methods and runs them
     */

    public void start(){
        try {
            int pageSize = getPageSize();
            InputStream response=fetchActivities(pageSize);
            List<Activity> activities = deserializationActivities(response);
            saveActivities(mapActivities(activities), pageSize);
            ListResult.resultCalc(SortReg.sorter(mapActivityToRegion(activities)));
            Validator.validate();
        } catch (Exception e) {
            logger.error(e);
        }
    }
}

