package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the threadLocal driver on the basis of given browser
     * @param browser
     * @return this will return tlDriver
     */

    public WebDriver init_driver(String browser) {
        System.out.println("Browser value is: " + browser);
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        } else if (browser.equals("safari")) {
            tlDriver.set(new SafariDriver());
        } else
            System.out.println("Please pass the correct browser value: " + browser);

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    /**
     * this is used to get the driver with ThreadLocal
     * @return tlDriver
     */
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

}
