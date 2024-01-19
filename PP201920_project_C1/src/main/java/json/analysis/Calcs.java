package json.analysis;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Calcs {

    public static void jsoncalc(List<File> list, LinkedHashMap<String, Integer> map3) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Integer> map;
        Map<String, Object> mapTM;
        Map<String, Object> mapTL;
        Map<String, Boolean> map2 = new HashMap<String, Boolean>();
        int a = list.size();
        ArrayList<String> types = new ArrayList<String>();
        ArrayList<String> gpsid;
        ArrayList<String> actid = new ArrayList<String>();
        for (int b = 0; b < a; b++) {
            try {
                @SuppressWarnings(value = "all")
                JsonNode parent = mapper.readTree(list.get(b)); //This reads all the content of the Json and finds all the JsonNodes contained in it.
                JsonNode typez = parent.path("types");    //This puts the content of all the JsonNodes that are titled "types" from the parent tree into a separated node.
                for (JsonNode node : typez)
                    types.add(node.asText());    //This adds the content of the array in the JsonNode into an ArrayList as a String.
                JsonNode idact = parent.findPath("id");
                JsonNode GpsTrack = parent.findPath("hasGPSTrack");
                map2.put(idact.asText(), GpsTrack.asBoolean()); //This inserts inside a map the id of the activity and the boolean hasGPSTrack as value and key respectably
                actid.add(idact.asText());
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        map = SortType.sorter(types);
        gpsid = SortGps.sorter(map2);
        mapTM = RegCalc.mostReg(map3);
        mapTL = RegCalc.leastReg(map3);
        OutputAnalysis output = new OutputAnalysis(map, gpsid, mapTM, mapTL);
        DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
        prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
        ObjectWriter writer = mapper.writer(prettyPrinter);
        try {
            File file = new File("result/Analysis.json");
            file.getParentFile().mkdirs();
            writer.writeValue(file, output);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
