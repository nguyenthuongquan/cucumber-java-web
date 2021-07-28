package features_backup;

import com.pages.LoginPage;
import com.pages.Page;
import com.util.Constants;
import com.util.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Steps_LoginPage {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private Page page = new Page(DriverFactory.getDriver());

    @Given("user navigates to Login page")
    public void user_is_on_login_page() {
        page.navigateTo(Constants.URL_LOGIN_PAGE);
    }

    @Then("verify forgot password link should be displayed")
    public void forgot_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.isForgotPwLinkExist());
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        loginPage.enterUserName(username);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLogin();
    }
}
