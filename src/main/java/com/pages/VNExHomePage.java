package com.pages;

import com.util.ElementUtil;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VNExHomePage {

    private WebDriver driver;

    //1. Locators
    private final By international_btn = By.cssSelector(".evne");
    private final By dangNhap_btn = By.id("myvne");
    private final By userName_btn = By.cssSelector("span.name_user_av");

    private final By login_iframe = By.cssSelector("iframe.mfp-iframe.iframe_guest");
    private final By email_tbx = By.id("myvne_email_input");
    private final By password_tbx = By.id("myvne_password_input");
    private final By login_btn = By.id("myvne_button_login");

    //2. Constructor
    public VNExHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //3. Actions
    public void clickOnDangNhap() {
        driver.findElement(dangNhap_btn).click();
    }

    public void clickOnInternational() {
        driver.findElement(international_btn).click();
    }

    public void enterEmail(String email) {
        driver.findElement(email_tbx).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(password_tbx).sendKeys(password);
    }

    public void clickOnLogin() {
        driver.findElement(login_btn).click();
    }

    public void waitUntilButtonUserNameAppears() {
        ElementUtil.waitUntilElementAppears(userName_btn);
    }

    @SneakyThrows
    public void loginVnExpress(String email, String password) {
        driver.switchTo().frame(driver.findElement(login_iframe));
        Thread.sleep(1000);
        driver.findElement(email_tbx).sendKeys(email);
        driver.findElement(password_tbx).sendKeys(password);
        driver.findElement(login_btn).click();
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
    }

    public boolean isDangNhapBtnExist() {
        return driver.findElement(dangNhap_btn).isDisplayed();
    }

    public String getUserNameBtnText() {
        return driver.findElement(userName_btn).getText();
    }

}
