package features;

import com.util.ConfigReader;
import com.util.Constants;
import com.util.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.core.backend.TestCaseState;
import io.cucumber.plugin.event.TestCase;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class AppHooks {

    Properties prop;
    private ConfigReader configReader;
    private DriverFactory driverFactory;
    private WebDriver driver;
    private int currentStepDefIndex = 0;

    @Before(value = "@skip", order = 0)
    public void skipScenario(Scenario scenario) {
        System.out.println("Skipped scenario: " + scenario.getName());
        Assume.assumeTrue(false);
    }

    @Before(order = 1)
    public void launchBrowser() {
        configReader = new ConfigReader();
        prop = configReader.init_prop(Constants.PATH_ENVIRONMENT_PROPERTIES);
        String browserName = prop.getProperty("Browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
    }

    @AfterStep
    public void takeScreenShot(Scenario scenario) throws NoSuchFieldException, IllegalAccessException {
        configReader = new ConfigReader();
        prop = configReader.init_prop(Constants.PATH_CONFIG_PROPERTIES);

        if (prop.getProperty("takeScreenshotForEveryStep").equalsIgnoreCase("true"))
            takeAndEmbedScreenshotToScenario(scenario);

        if (prop.getProperty("takeScreenshotForVerificationStep").equalsIgnoreCase("true")
                && getCurrentStep(scenario).startsWith("verify"))
            takeAndEmbedScreenshotToScenario(scenario);

        currentStepDefIndex += 1;
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        //1. takeScreenShotIfAllowed
        configReader = new ConfigReader();
        prop = configReader.init_prop(Constants.PATH_CONFIG_PROPERTIES);
        if (scenario.isFailed() &&
                (prop.getProperty("takeScreenshotWhenScenarioFails").equalsIgnoreCase("true")) )
            takeAndEmbedScreenshotToScenario(scenario);

        //2. quitBrowser
        driver.quit();
    }

    private void takeAndEmbedScreenshotToScenario(Scenario scenario) {
        String date = new SimpleDateFormat("yyMMdd-HHmmss-SS").format(new Date());
        byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sourcePath, "image/png", date);
    }

    private String getCurrentStep(Scenario scenario) throws NoSuchFieldException, IllegalAccessException {
        Field f = scenario.getClass().getDeclaredField("delegate");
        f.setAccessible(true);
        TestCaseState sc = (TestCaseState) f.get(scenario);
        Field f1 = sc.getClass().getDeclaredField("testCase");
        f1.setAccessible(true);
        TestCase testCase = (TestCase) f1.get(sc);
        List<PickleStepTestStep> testSteps = testCase.getTestSteps().stream()
                .filter(x -> x instanceof PickleStepTestStep)
                .map(x -> (PickleStepTestStep) x)
                .collect(Collectors.toList());
        return testSteps.get(currentStepDefIndex).getStep().getText();
    }

}
