package json.analysis;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class ListResult {

    public static void resultCalc(LinkedHashMap<String, Integer> map) {
        File folder = new File("result/");
        FilenameFilter filter = (f, name) -> name.startsWith("Activity");
        List<File> filelist = Arrays.asList(folder.listFiles(filter));
        Calcs.jsoncalc(filelist, map);
    }

}
