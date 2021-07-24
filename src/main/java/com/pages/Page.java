package com.pages;

import com.util.Constants;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Page {

    private WebDriver driver;

    //1. Locators

    //2. Constructor
    public Page(WebDriver driver) {
        this.driver = driver;
    }

    //3. Actions
    public String getPageTitle() {
        return driver.getTitle();
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    @SneakyThrows
    public boolean pageTitleContains(String text) {
        for (int i = 0; i < Constants.SHORT_WAIT; i++) {
            if (!driver.getTitle().contains(text))
                Thread.sleep(1000);
            else
                break;
        }
        return driver.getTitle().contains(text);
    }

    @SneakyThrows
    public boolean pageTitleIsEqual(String text) {
        for (int i = 0; i < Constants.SHORT_WAIT; i++) {
            if (!driver.getTitle().contains(text))
                Thread.sleep(1000);
            else
                break;
        }
        return driver.getTitle().contains(text);
    }

    @SneakyThrows
    public boolean pageURLContains(String text) {
        for (int i = 0; i <  Constants.SHORT_WAIT; i++) {
            if (!driver.getCurrentUrl().contains(text))
                Thread.sleep(1000);
            else
                break;
        }
        return driver.getCurrentUrl().contains(text);
    }

    @SneakyThrows
    public boolean pageURLIsEqual(String text) {
        for (int i = 0; i < Constants.SHORT_WAIT; i++) {
            if (!driver.getCurrentUrl().contains(text))
                Thread.sleep(1000);
            else
                break;
        }
        return driver.getCurrentUrl().contains(text);
    }

    public void takeScreenShot() throws IOException {
        String date = new SimpleDateFormat("yyMMdd-HHmmss-SS").format(new Date());
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshots/"+ date +".png"));
    }
}
