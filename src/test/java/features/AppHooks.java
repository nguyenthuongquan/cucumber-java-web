package features;

import com.util.ConfigReader;
import com.util.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class AppHooks {

    Properties prop;
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;

    @Before(value = "@skip", order = 0)
    public void skipScenario(Scenario scenario) {
        System.out.println("Skipped scenario: " + scenario.getName());
        Assume.assumeTrue(false);
    }

    @Before(order = 1)
    public void launchBrowser() {
        //1. getProperty
        configReader = new ConfigReader();
        prop = configReader.init_prop();

        //2. launchBrowser
        String browserName = prop.getProperty("Browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
    }

    @AfterStep
    public void takeScreenShot(Scenario scenario) {
        String date = new SimpleDateFormat("yyMMdd-HHmmss-SS").format(new Date());
        byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sourcePath, "image/png", date);
    }


    @After(order = 1)
    public void tearDown(Scenario scenario) {
        //1. tearDown
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName()
                    .replace(" ", "_")
                    .replace("\'", "");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }

        //2. quitBrowser
        driver.quit();
    }
}
