package com.pages;

import com.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookLoginPage {

    //1. Locators
    private final By tbx_email = By.id("email");
    private final By tbx_password = By.id("pass");
    private final By btn_login = By.cssSelector("button[type=submit]");
    private final By lnk_forgotPassword = By.xpath("//a[text()='Quên mật khẩu?']");
    private final By btn_signup = By.cssSelector("a[data-testid=open-registration-form-button]");
    private final By err_emailOrPhoneDoNotMatch = By.xpath("//*[text()='Email hoặc số di động bạn nhập không kết nối với tài khoản nào. ']");
    private final By lnk_findYourAccountAndLogin = By.xpath("//a[text()='Hãy tìm tài khoản của bạn và đăng nhập.']");


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

    public boolean areLoginValidationErrorsReturned() {
        boolean a = ElementUtil.isElementIsDisplayed(err_emailOrPhoneDoNotMatch);
        boolean b = ElementUtil.isElementIsDisplayed(lnk_findYourAccountAndLogin);
        return a && b;
    }

    public boolean isLoginValidationErrorsReturned(String errorText) {
        By lbl_error = By.xpath("//*[contains(text(),'" + errorText + "')]");
        try {
            return ElementUtil.isElementIsDisplayed(lbl_error);
        }
        catch (NoSuchElementException e) {
            errorText = "Sai thông tin đăng nhập";
            lbl_error = By.xpath("//*[contains(text(),'" + errorText + "')]");
            try {
                return ElementUtil.isElementIsDisplayed(lbl_error);
            }
            catch (NoSuchElementException e1) {
                errorText = "Bạn hiện không thể sử dụng tính năng này";
                lbl_error = By.xpath("//*[contains(text(),'" + errorText + "')]");
            }
        }
        return ElementUtil.isElementIsDisplayed(lbl_error);
    }
}
