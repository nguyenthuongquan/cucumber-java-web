package com.util;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
    public static void waitUntilElementAppears(By byLocator) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Constants.IMPLICIT_WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
    }
}