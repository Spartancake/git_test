import json.generator.Activity;
import json.generator.ImportantActivityInfo;
import json.generator.ODHActivitiesFetcher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileExistenceTest {
    private static ODHActivitiesFetcher ODHActivitiesFetcher;

    @BeforeAll
    static void start() throws IOException {
        ODHActivitiesFetcher = new ODHActivitiesFetcher("input_test.txt");
        ODHActivitiesFetcher.start();
    }

    @Test
    void analysisExistTest() throws FileNotFoundException {
        assertDoesNotThrow(() -> {
            new FileReader("result/Analysis.json");
        });
    }

    @Test
    void numFilesTest() {
        File file = new File("result/");
        int num = ODHActivitiesFetcher.getPageSize();
        assertEquals(num, file.list().length - 1);
    }

    @Test
    void inputFileTest() throws IOException {
        ODHActivitiesFetcher ODHActivitiesFetcher = new ODHActivitiesFetcher("wrong_formatted_input_test.txt");
        assertEquals(ODHActivitiesFetcher.getPageSize(), 1);
    }
}

