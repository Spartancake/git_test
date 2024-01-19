package json.analysis;

import java.util.ArrayList;
import java.util.Map;

public class SortGps {

    public static ArrayList<String> sorter(Map<String, Boolean> map) {
        ArrayList<String> list = new ArrayList<String>();
        map.forEach((id, bool) -> {
            if (bool) list.add(id);
        }); //This part takes every key and value of the map and checks if the value is true, if so the key is inserted in the list
        return list;
    }

}
