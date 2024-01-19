package json.analysis;

import java.util.*;

public class RegCalc {
    public static Map<String, Object> mostReg(LinkedHashMap<String, Integer> map) {
        Map<String, Object> result = new HashMap<String, Object>();
        ArrayList<String> ids = new ArrayList<String>();
        List<String> k = new ArrayList<String>(map.keySet());
        List<Integer> v = new ArrayList<Integer>(map.values());
        result.put("numberofActivities", v.get(0));
        ids.add(k.get(0));
        int l = k.size();
        for (int s = 1; s < l; s++) {
            if (k.get(s).equals(k.get(0)))
                ids.add(k.get(s));
        }
        result.put("regionIds", ids);
        return result;
    }

    public static Map<String, Object> leastReg(LinkedHashMap<String, Integer> map) {
        Map<String, Object> result = new HashMap<String, Object>();
        ArrayList<String> ids = new ArrayList<String>();
        List<String> k = new ArrayList<String>(map.keySet());
        List<Integer> v = new ArrayList<Integer>(map.values());
        result.put("numberofActivities", v.get(v.size() - 1));
        ids.add(k.get(k.size() - 1));
        for (int s = k.size() - 2; s != 0; s--) {
            if (k.size() - 1 > 0) {
                if (k.get(s).equals(k.get(k.size() - 1)))
                    ids.add(k.get(s));
            }
        }
        result.put("regionIds", ids);
        return result;
    }

}
