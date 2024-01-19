package json.analysis;

import java.util.*;
import java.util.Map.Entry;

public class SortReg {

    public static LinkedHashMap<String, Integer> sorter(List<String> list) {
        String s;
        String p;
        int count = 0;
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        Set<String> types = new LinkedHashSet<>();            //
        types.addAll(list);                                   //
        int length = types.size();                            //This part is used to create a copy of the list of all the activities
        ArrayList<String> typel = new ArrayList<String>();    //       without any duplicate to simplify some of the work.
        typel.addAll(types);                                  //
        int lengtho = list.size();                            //

        for (int c = 0; c < length; c++) {
            s = typel.get(c);
            count = 0;
            for (int b = 0; b < lengtho; b++) {
                p = list.get(b);
                if (p.equals(s)) {
                    count++;
                }
			}
			map.put(s, count);
        }
        Set<Map.Entry<String, Integer>> regidSet =
                map.entrySet();
        List<Map.Entry<String, Integer>> regidLEntry =
                new ArrayList<Map.Entry<String, Integer>>(
                        regidSet);
        Collections.sort(regidLEntry,
                new Comparator<Map.Entry<String, Integer>>() {

                    @Override
                    public int compare(Entry<String, Integer> es1,
                                       Entry<String, Integer> es2) {
                        return es2.getValue().compareTo(es1.getValue());
                    }
                });
        map.clear();
        for (Map.Entry<String, Integer> map2 : regidLEntry) {
            map.put(map2.getKey(), map2.getValue());
        }
        return map;
    }
}
