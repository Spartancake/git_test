package json.generator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class JsonFilesHelper {

    private static Logger logger = LogManager.getLogger(JsonFilesHelper.class);
    List<ImportantActivityInfo> list;
    int num;

    /**
     * Initializing the JsonFiles with the list of important activities and the number of them
     *
     * @param list is the list of the important activities, where the wanted attributes are already
     *             filtered out from the other ones
     * @param num  is the number of important activity objects we want
     */
    public JsonFilesHelper(List<ImportantActivityInfo> list, int num) {
        this.list = list;
        this.num = num;
    }

    /**
     * This method writes for each importantActivity object a file. First of all, it deletes all files in the
     * result directory, then in a loop it first creates the desired file with its id in the file name,
     * then writes teh object with its attributes in the file.
     * Important: We use the Characters in UTF-8 to address a converting problem which otherwise would
     *
     * @throws IOException if the writer
     */
    public void writeFiles() {
        clearFiles();
        for (int i = 0; i < num; i++) {
            String name = "Activity_" + list.get(i).id;
            File file = new File("result/" + name + ".json");
            file.getParentFile().mkdirs();
            ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            try (FileOutputStream writer = new FileOutputStream(file)) {
                String value = mapper.writeValueAsString(list.get(i)); // Gets the info to write as a string
                writer.write(value.getBytes(StandardCharsets.UTF_8)); // Gets the strings characters as UTF-8 bytes
                // NOTE: This is necessary to take in account special characters
                // 	    such as German characters
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }

    /**
     * This method is used to clear the files of the "result" directory, and is only used
     * for that purpose
     */

    public void clearFiles() {
        File folder = new File("result/");
        File[] files = folder.listFiles() != null ? folder.listFiles() : new File[0];

        for (File file : files) {
            if (!file.isDirectory())
                file.delete();
        }
    }
}
