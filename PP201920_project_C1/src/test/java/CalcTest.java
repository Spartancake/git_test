import json.analysis.RegCalc;
import json.analysis.SortReg;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {
    private static ArrayList<String> list = new ArrayList<>();

    @BeforeAll
    static void start() {
        list.add("region1");
        list.add("region2");
        list.add("region2");
        list.add("region2");
        list.add("region2");
        list.add("region3");
        list.add("region1");
        list.add("region1");
    }

    @Test
    void leastRegionTest() {
        Map<String, Object> map = new HashMap<>();
        ArrayList<String> regionList = new ArrayList<>();
        regionList.add("region3");
        map.put("numberofActivities", 1);
        map.put("regionIds", regionList);
        assertEquals(map.toString(), RegCalc.leastReg(SortReg.sorter(list)).toString());
    }

    @Test
    void mostRegionTest() {
        Map<String, Object> map = new HashMap<>();
        ArrayList<String> regionList = new ArrayList<>();
        regionList.add("region2");
        map.put("numberofActivities", 4);
        map.put("regionIds", regionList);
        assertEquals(map.toString(), RegCalc.mostReg(SortReg.sorter(list)).toString());
    }
}
