package cucumber.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VNExHomePage extends BasePage {

    public VNExHomePage(WebDriver driver) {
        super(driver);
    }

    private final By international_btn = By.cssSelector(".evne");
    private final By dangNhap_btn = By.id("myvne");
    private final By userName_btn = By.cssSelector("span.name_user_av");
    private final By login_iframe = By.cssSelector("iframe.mfp-iframe.iframe_guest");
    private final By email_tbx = By.id("myvne_email_input");
    private final By password_tbx = By.id("myvne_password_input");
    private final By login_btn = By.id("myvne_button_login");

    public void clickOnDangNhap() {
        waitAndClick(dangNhap_btn);
    }

    public void clickOnInternational() {
        waitAndClick(international_btn);
    }

    public void enterEmail(String email) {
        waitAndSendKey(email_tbx, email);
    }

    public void enterPassword(String password) {
        waitAndSendKey(password_tbx, password);
    }

    public void clickOnLogin() {
        waitAndClick(login_btn);
    }

    @SneakyThrows
    public void loginVnExpress(String email, String password) {
        switchToFrame(login_iframe);
        enterEmail(email);
        enterPassword(password);
        clickOnLogin();
        switchToDefaultContent();
    }

    public boolean isDangNhapBtnExist() {
        return isElementDisplayed(dangNhap_btn);
    }

    public String getUserNameBtnText() {
        return waitAndGetText(userName_btn);
    }
}
