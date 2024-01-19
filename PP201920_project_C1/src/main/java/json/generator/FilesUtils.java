package json.generator;

import java.io.InputStream;

public class FilesUtils {

    public static InputStream getFileAsInputStream(String fileName) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        return classLoader.getResourceAsStream(fileName);
    }

    public static InputStream getInputFile() {
        return getFileAsInputStream("input.txt");
    }
}
