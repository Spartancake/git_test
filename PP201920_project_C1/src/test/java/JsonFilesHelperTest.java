import json.generator.ImportantActivityInfo;
import json.generator.JsonFilesHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonFilesHelperTest {
    private static JsonFilesHelper j;
    private static ImportantActivityInfo importantActivityInfo;

    @BeforeAll
    static void start() throws UnsupportedEncodingException {
        List<ImportantActivityInfo> list = new ArrayList<>();
        String[] types = {"loipen", "klassisch und skating"};
        importantActivityInfo = new ImportantActivityInfo("01CFEFF8DA586E548327E539276C42F3", "01 Cross Country Stadio Track Dobbiaco/Toblach", "01 Cross Country Stadio Track Dobbiaco/Toblach', description='Demanding round-trip tours starting at the cross-country stadium in Dobbiaco, often used as training tracks by various national cross-country teams from all over the world.This trail will be floodlit on Monday and Thursday from 5:00 pm to 8:00 pm from. Use is subject to a fee.", Arrays.asList(types), true, "Dolomites Region Three Peaks");
        list.add(importantActivityInfo);
        j = new JsonFilesHelper(list, 1);
    }

    @Test
    void filesNameTest() {
        j.writeFiles();
        String filename = "Activity_" + importantActivityInfo.getId() + ".json";
        File file = new File("result/" + filename);
        assertTrue(file.exists());
    }
}
