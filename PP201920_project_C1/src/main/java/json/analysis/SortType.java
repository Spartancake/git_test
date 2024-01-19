package json.analysis;

import java.util.*;

public class SortType {

    public static Map<String, Integer> sorter(ArrayList<String> list) {

        String s;
        String p;
        int count = 0;
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        Set<String> types = new LinkedHashSet<>();            //
        types.addAll(list);                                    //
        int length = types.size();                            //This part is used to create a copy of the list of all the activities
        ArrayList<String> typel = new ArrayList<String>();    //       without any duplicate to simplify some of the work.
        typel.addAll(types);                                //
        int lengtho = list.size();

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
        return map;
    }
}
