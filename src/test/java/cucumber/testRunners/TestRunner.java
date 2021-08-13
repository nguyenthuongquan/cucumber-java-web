package cucumber.testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import utilities.FileUtil;

import java.io.IOException;

@CucumberOptions(
        //tags = "not @skip",
        features = "src/test/java/cucumber/features",
        glue = "cucumber.steps",
        publish = true,
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:reports/thread/",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                "rerun:target/failedRerun.txt"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
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