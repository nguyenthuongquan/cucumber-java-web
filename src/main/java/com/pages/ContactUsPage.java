package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

    private WebDriver driver;

    //1. Locators
    private By subjectHeading = By.id("id_contact");
    private By email = By.id("email");
    private By orderRef = By.id("id_order");
    private By messageText = By.id("message");
    private By sendButton = By.id("submitMessage");
    private By successMessage = By.cssSelector("div#center_column p");

    //2. Constructor
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. Actions
    public void fillContactUsForm(String heading, String emailId, String orderReference, String message) {
        Select select = new Select(driver.findElement(subjectHeading));
        select.selectByVisibleText(heading);
        driver.findElement(email).sendKeys(emailId);
        driver.findElement(orderRef).sendKeys(orderReference);
        driver.findElement(messageText).sendKeys(message);
    }

    public void clickSend() {
        driver.findElement(sendButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
