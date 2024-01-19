import json.analysis.SortGps;
import json.analysis.SortReg;
import json.analysis.SortType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingTest {
    private static ArrayList<String> list = new ArrayList<>();
    private static LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

    @BeforeAll
    static void start() {
        list.add("one");
        list.add("one");
        list.add("two");
        list.add("three");
        map.put("one", 2);
        map.put("two", 1);
        map.put("three", 1);
    }

    @Test
    void sorterRegTest() {
        assertEquals(map.toString(), SortReg.sorter(list).toString());
    }

    @Test
    void sorterTypeTest() {
        assertEquals(map.toString(), SortType.sorter(list).toString());
    }

    @Test
    void gpsSorterTest() {
        Map<String, Boolean> gpsMap = new LinkedHashMap<>();
        ArrayList<String> namesList = new ArrayList<>();
        gpsMap.put("Mike", true);
        gpsMap.put("Ramon", false);
        gpsMap.put("Riccardo", true);
        gpsMap.put("Lucia", false);
        namesList.add("Mike");
        namesList.add("Riccardo");
        assertEquals(namesList.toString(), SortGps.sorter(gpsMap).toString());
    }
}
