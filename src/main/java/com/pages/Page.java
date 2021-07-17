package com.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

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
    public boolean pageTitleContains(String text, int implicitlyWaitInSecond) {
        for (int i = 0; i < implicitlyWaitInSecond; i++) {
            if (!driver.getTitle().contains(text))
                Thread.sleep(1000);
            else
                break;
        }
        return driver.getTitle().contains(text);
    }
}
