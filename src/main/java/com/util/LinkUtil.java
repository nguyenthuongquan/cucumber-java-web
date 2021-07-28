package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;

public class LinkUtil {
    public static void waitUntilElementAppears(By byLocator) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Constants.IMPLICIT_WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
    }

    public static boolean isElementIsDisplayed(By byLocator) {
        return DriverFactory.getDriver().findElement(byLocator).isDisplayed();
    }

    public static void checkBrokenLink(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() >= 400)
                System.out.println(linkUrl + " --> " + httpURLConnection.getResponseCode() +" - " + httpURLConnection.getResponseMessage() + " --> is a broken link");
            else
                System.out.println(linkUrl + " --> " + httpURLConnection.getResponseCode() +" - " + httpURLConnection.getResponseMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}