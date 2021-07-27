package com.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    public WebDriver init_driver(String browser) {
        ConfigReader configReader = new ConfigReader();
        Properties prop = configReader.init_prop(Constants.PATH_CONFIG_PROPERTIES);
        boolean isBrowserHeadless = Boolean.parseBoolean(prop.getProperty("headless"));
        System.out.println("Browser Info: " + browser + ", headless = " + isBrowserHeadless);

        if (browser.equalsIgnoreCase("Chrome")) {
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
//                        "--incognito",
                        "--disable-dev-shm-usage");

                tlDriver.set(new ChromeDriver(options));
            } else
                tlDriver.set(new ChromeDriver());

        } else if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        } else if (browser.equalsIgnoreCase("Safari")) {
            tlDriver.set(new SafariDriver());
        } else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            tlDriver.set(new EdgeDriver());
        } else
            System.out.println("Please pass the correct browser value: " + browser);

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        getDriver().manage().timeouts().setScriptTimeout(Constants.SCRIPT_TIMEOUT, TimeUnit.SECONDS);
        return getDriver();
    }
}
