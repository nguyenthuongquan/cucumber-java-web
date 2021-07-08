package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {

    private WebDriver driver;

    //1. Locators
    private final By account_sections = By.cssSelector("div#center_column span");

    //2. Constructor of the page class
    public AccountsPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. Page Actions

    public String getAccountPageTitle() {
        return driver.getTitle();
    }

    public int getAccountSectionCount() {
        return driver.findElements(account_sections).size();
    }

    public List<String> getAccountSectionsList() {
        List<String> accountList = new ArrayList<>();
        List<WebElement> accountHeaderList = driver.findElements(account_sections);
        for (WebElement e : accountHeaderList) {
            String text = e.getText();
            System.out.println(text);
            accountList.add(text);
        }
        return accountList;
    }
}
