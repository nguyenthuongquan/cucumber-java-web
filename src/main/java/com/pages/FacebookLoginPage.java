package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookLoginPage {

    //1. Locators
    private final By tbx_email = By.id("email");
    private final By tbx_password = By.id("pass");
    private final By btn_login = By.cssSelector("button[type=submit]");
    private final By lnk_forgotPassword = By.xpath("//a[text()='Quên mật khẩu?']");
    private final By btn_signup = By.cssSelector("a[data-testid=open-registration-form-button]");

    private WebDriver driver;

    //2. Constructor
    public FacebookLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. Actions
    public void clickOnBtnLogin() {
        driver.findElement(btn_login).click();
    }
    public void clickOnLnkForgotPassword() {
        driver.findElement(lnk_forgotPassword).click();
    }
    public void clickOnBtnSignUp() {
        driver.findElement(btn_signup).click();
    }
    public void enterEmail(String email) {
        driver.findElement(tbx_email).sendKeys(email);
    }
    public void enterPassword(String password) {
        driver.findElement(tbx_password).sendKeys(password);
    }

    public void loginFacebook(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickOnBtnLogin();
    }
}
