package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class VNExInternationalPage {

    private WebDriver driver;

    //1. Locators
    private final By headers_lbl = By.xpath("//div[contains(@class,'item_menu_left')]");


    //2. Constructor of the page class
    public VNExInternationalPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. Page Actions
    public String getPageTitle() {
        return driver.getTitle();
    }

    public int getHeadersCount() {
        return driver.findElements(headers_lbl).size();
    }

    public List<String> getHeaderNamesList() {
        List<String> headerNamesList = new ArrayList<>();
        List<WebElement> headersList = driver.findElements(headers_lbl);
        for (WebElement e : headersList) {
            String text = e.getText();
            if (text.equals(""))
                text = "[blank]";
            System.out.println(text);
            headerNamesList.add(text);
        }
        return headerNamesList;
    }
}
