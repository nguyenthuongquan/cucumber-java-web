package utilities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    public static void copyFile(File source, File dest) throws IOException {
        FileUtils.copyFile(source, dest);
    }

    public static void copyEnvironmentFileToAllureResultsFolder() throws IOException {
        File source = new File("src/test/resources/environment.properties");
        File dest = new File("target/allure-results/environment.properties");
        FileUtil.copyFile(source, dest);
    }
}
