package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    //1. Locators
    private final By email_tbx = By.id("email");
    private final By password_tbx = By.id("passwd");
    private final By login_btn = By.id("SubmitLogin");
    private final By forgotPw_lnk = By.linkText("Forgot your password?");

    //2. Constructor of the page class
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. Page Actions
    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean isForgotPwLinkExist() {
        return driver.findElement(forgotPw_lnk).isDisplayed();
    }

    public void enterUserName(String userName) {
        driver.findElement(email_tbx).sendKeys(userName);
    }

    public void enterPassword(String password) {
        driver.findElement(password_tbx).sendKeys(password);
    }

    public void clickOnLogin() {
        driver.findElement(login_btn).click();
    }

    public AccountsPage doLogin(String username, String password) {
        System.out.println("Login with: " + username + " and " + password);
        driver.findElement(email_tbx).sendKeys(username);
        driver.findElement(password_tbx).sendKeys(password);
        driver.findElement(login_btn).click();
        return new AccountsPage(driver);
    }
}
