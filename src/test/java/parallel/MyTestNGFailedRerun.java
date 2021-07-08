package parallel;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/",
                "rerun:target/failedRerun.txt"
        },
        monochrome = true,
        glue = {"parallel"},
        features = {"@target/failedRerun.txt"}
)

public class MyTestNGFailedRerun extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
