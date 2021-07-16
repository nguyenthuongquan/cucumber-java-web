package features;

import com.util.ConfigReader;
import com.util.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class AppHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before(value = "@skip", order = 0)
    public void skipScenario(Scenario scenario) {
        System.out.println("Skipped scenario: " + scenario.getName());
        Assume.assumeTrue(false);
    }

    @Before(order = 1)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 2)
    public void launchBrowser() {
        String browserName = prop.getProperty("Browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replace(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

}
