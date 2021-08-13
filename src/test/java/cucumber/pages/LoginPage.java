package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By email_tbx = By.id("email");
    private final By password_tbx = By.id("passwd");
    private final By login_btn = By.id("SubmitLogin");
    private final By forgotPw_lnk = By.linkText("Forgot your password?");

    public boolean isForgotPwLinkExist() {
        return isElementDisplayed(forgotPw_lnk);
    }

    public void enterUserName(String userName) {
        waitAndSendKey(email_tbx, userName);
    }

    public void enterPassword(String password) {
        waitAndSendKey(password_tbx, password);
    }

    public void clickOnLogin() {
        waitAndClick(login_btn);
    }

    public AccountsPage doLogin(String username, String password) {
        System.out.println("Login with: " + username + " and " + password);
        enterUserName(username);
        enterPassword(password);
        clickOnLogin();
        return new AccountsPage(driver);
    }
}
