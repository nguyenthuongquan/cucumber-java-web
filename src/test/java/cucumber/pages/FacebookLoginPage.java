package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Constants;

import java.time.Duration;

public class FacebookLoginPage extends BasePage {

    public FacebookLoginPage(WebDriver driver) {
        super(driver);
    }

    private final By tbx_email = By.id("email");
    private final By tbx_password = By.id("pass");
    private final By btn_login = By.cssSelector("button[type=submit]");
    private final By lnk_forgotPassword = By.xpath("//a[text()='Quên mật khẩu?']");
    private final By btn_signup = By.cssSelector("a[data-testid=open-registration-form-button]");
    private final By err_emailOrPhoneDoNotMatch = By.xpath("//*[text()='Email hoặc số di động bạn nhập không kết nối với tài khoản nào. ']");
    private final By lnk_findYourAccountAndLogin = By.xpath("//a[text()='Hãy tìm tài khoản của bạn và đăng nhập.']");

    public void clickOnBtnLogin() {
        waitAndClick(btn_login);
    }

    public void clickOnLnkForgotPassword() {
        waitAndClick(lnk_forgotPassword);
    }

    public void clickOnBtnSignUp() {
        waitAndClick(btn_signup);
    }

    public void enterEmail(String email) {
        waitAndSendKey(tbx_email, email);
    }

    public void enterPassword(String password) {
        waitAndSendKey(tbx_password, password);
    }

    public void loginFacebook(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickOnBtnLogin();
    }

    public boolean areLoginValidationErrorsReturned() {
        if (!isElementDisplayed(err_emailOrPhoneDoNotMatch)) return false;
        return isElementDisplayed(lnk_findYourAccountAndLogin);
    }

    public boolean isLoginValidationErrorsReturned(String errorText) {
        WebDriverWait newWait = new WebDriverWait(driver, Constants.SHORT_WAIT);
        By lbl_error = By.xpath("//*[contains(text(),'" + errorText + "')]");
        try {
            return newWait.until(ExpectedConditions.visibilityOfElementLocated(lbl_error)).isDisplayed();
        } catch (TimeoutException e) {
            errorText = "Sai thông tin đăng nhập";
            lbl_error = By.xpath("//*[contains(text(),'" + errorText + "')]");
            try {
                return isElementDisplayed(lbl_error);
            } catch (TimeoutException e1) {
                errorText = "Bạn hiện không thể sử dụng tính năng này";
                lbl_error = By.xpath("//*[contains(text(),'" + errorText + "')]");
            }
        }
        return isElementDisplayed(lbl_error);
    }
}
