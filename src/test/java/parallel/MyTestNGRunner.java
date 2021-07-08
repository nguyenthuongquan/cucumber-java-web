package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/",
                "rerun:target/failedRerun.txt"
        },
        monochrome = true,   //Don't colour terminal output.
        glue = {"parallel"}, //Package to load glue code (step definitions, hooks and plugins) from.
        features = {"src/test/resources/parallel"} //Either a URI or path to a directory of features or a URI or path to a single feature optionally followed by a colon and line numbers.
//        features = {"src/test/resources/parallel/ContactUsPage.feature"}
        //tags = "not @Skip",

)

public class MyTestNGRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
