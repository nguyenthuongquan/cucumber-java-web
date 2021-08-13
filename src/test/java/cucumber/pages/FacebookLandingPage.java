package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookLandingPage extends BasePage {

    public FacebookLandingPage(WebDriver driver) {
        super(driver);
    }

    private final By tbx_email = By.id("email");
    private final By tbx_password = By.id("pass");
    private final By btn_login = By.cssSelector("button[type=submit]");
    private final By lnk_forgotPassword = By.xpath("//a[text()='Quên mật khẩu?']");
    private final By btn_signup = By.cssSelector("a[data-testid=open-registration-form-button]");
    private final By lnk_createPage = By.xpath("//a[contains(@href, '/pages/create/?ref_type=registration_form')]");
    private final By lbl_dangKy = By.xpath("//*[text()='Đăng ký']");
    private final By lbl_nhanhChongDeDang = By.xpath("//*[text()='Nhanh chóng và dễ dàng.']");

    public void clickOnBtnLogin() {
        waitAndClick(btn_login);
    }
    public void clickOnLnkForgotPassword() {
        waitAndClick(lnk_forgotPassword);
    }
    public void clickOnBtnSignUp() {
        waitAndClick(btn_signup);

    }
    public void clickOnLnkCreatePage() {
        waitAndClick(lnk_createPage);
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

    public boolean isSignupFormEnabled() {
        if (!isElementDisplayed(lbl_dangKy)) return false;
        return isElementDisplayed(lbl_nhanhChongDeDang);
    }
}