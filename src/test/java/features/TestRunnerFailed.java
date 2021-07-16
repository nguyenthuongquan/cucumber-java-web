package features;

import com.util.FileUtil;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;

import java.io.IOException;

@CucumberOptions(
        features = "@target/failedRerun.txt",
        glue = "features",
        publish = true,
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:reports/thread/",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                "rerun:target/failedRerun.txt"}
)

public class TestRunnerFailed extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterClass(alwaysRun = true)
    public void teardown() throws IOException {
        FileUtil.copyEnvironmentFileToAllureResultsFolder();

    }
}
