package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ThreadLocalDriver {
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private final ReadConfigFile readConfigFile = ConfigFactory.create(ReadConfigFile.class);
    boolean isBrowserHeadless = readConfigFile.isBrowserHeadless();

    @SneakyThrows
    public WebDriver setDriver(String browser) {
        System.out.println("Browser Info: " + browser + ", headless = " + isBrowserHeadless);
        switch (browser) {
            case "Chrome":
                startChrome();
                break;
            case "Firefox":
                startFirefox();
                break;
            case "Edge":
                startMSEdge();
                break;
            case "Safari":
                startSafari();
                break;
            case "Opera":
                startOpera();
                break;
            default:
                Assert.fail("Please pass the correct browser value instead of " + browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        getDriver().manage().timeouts().setScriptTimeout(Constants.SCRIPT_TIMEOUT, TimeUnit.SECONDS);
        return getDriver();
    }

    private void startChrome() {
        WebDriverManager.chromedriver().setup();
        if (isBrowserHeadless) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments(
                    "--headless",
                    "--disable-gpu",
                    "--window-size=1920,1200",
                    "--ignore-certificate-errors",
                    "--disable-extensions",
                    "--no-sandbox",
                    //"--incognito",
                    "--disable-dev-shm-usage");

            tlDriver.set(new ChromeDriver(options));
        } else
            tlDriver.set(new ChromeDriver());
    }

    private void startFirefox() {
        WebDriverManager.firefoxdriver().setup();
        if (isBrowserHeadless) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            tlDriver.set(new FirefoxDriver(options));
        } else
            tlDriver.set(new FirefoxDriver());
    }

    private void startMSEdge() {
        WebDriverManager.edgedriver().setup();
        if (isBrowserHeadless)
            Assert.fail("Selenium 3.141.59 doesn't support MS Edge browser to run in headless mode. Please upgrade to version 4.");
        else
            tlDriver.set(new EdgeDriver());
    }

    private void startSafari() {
        DriverManagerType safari = DriverManagerType.SAFARI;
        WebDriverManager.getInstance(safari).setup();
        if (isBrowserHeadless) {
            Assert.fail("Safari browser is not supported to run in headless mode yet");
        } else
            tlDriver.set(new SafariDriver());
    }

    private void startOpera() {
        WebDriverManager.operadriver().setup();
        if (isBrowserHeadless) {
            Assert.fail("Opera browser is not supported to run in headless mode yet");
        } else
            tlDriver.set(new OperaDriver());
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
