package com.pages;

import com.util.Constants;
import com.util.LinkUtil;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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
        for (int i = 0; i < Constants.SHORT_WAIT; i++) {
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
        FileUtils.copyFile(screenshotFile, new File(".//screenshots/" + date + ".png"));
    }

    public boolean areAllLinksInPageWork() {
        //1. Get all link element in the page
        List<WebElement> links = driver.findElements(By.xpath("//*[@href]"));
        System.out.println("No of all link element is: " + links.size());

        //2. Get the urls from the elements
        List<String> urlList = new ArrayList<>();
        for (WebElement e : links) {
            if (e.isDisplayed()) {
                String url = e.getAttribute("href");
                urlList.add(url);
            }
        }
        System.out.println("No of links that displayed is: " + urlList.size());

        //3. Remove the duplicate urls
        List<String> urlListWithoutDuplicates = new ArrayList<>(new HashSet<>(urlList));
        System.out.println("No of links that displayed and not duplicated is: " + urlListWithoutDuplicates.size());

        //4. Remove the incorrect format urls
        urlListWithoutDuplicates.removeIf(s -> !s.startsWith("http"));
        System.out.println("No of valid links that displayed and not duplicated is: " + urlListWithoutDuplicates.size());

        //5. Print response Code and response Message of the links
        long startTime = System.currentTimeMillis();
        urlListWithoutDuplicates.parallelStream().forEach(LinkUtil::checkBrokenLink);
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (endTime - startTime));

        //Todo:
        return true;
    }

}
