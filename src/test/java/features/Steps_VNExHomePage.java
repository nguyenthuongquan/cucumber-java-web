package features;

import com.pages.VNExHomePage;
import com.util.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Steps_VNExHomePage {

    private VNExHomePage vnExHomePage = new VNExHomePage(DriverFactory.getDriver());

    @Given("user is on VnExpress home page")
    public void user_is_on_vn_express_home_page() {
        DriverFactory.getDriver().get("https://vnexpress.net/");
    }

    @Then("Dang Nhap link should be displayed")
    public void dang_nhap_link_should_be_displayed() {
        Assert.assertTrue(vnExHomePage.isDangNhapBtnExist());
    }

    @Given("user clicks on VnExpress Dang Nhap link")
    public void user_clicks_on_vn_express_dang_nhap_link() {
        vnExHomePage.clickOnDangNhap();
    }

    @Given("user clicks on International button")
    public void user_clicks_on_international_button() {
        vnExHomePage.clickOnInternational();
    }

    @When("user logins VnExpress with username {string} and password {string}")
    public void user_logins_vn_express_with_username_and_password(String username, String password) {
        vnExHomePage.loginVnExpress(username, password);
    }

    @When("user enters VnExpress username {string}")
    public void user_enters_vn_express_username(String username) {
        vnExHomePage.enterEmail(username);
    }

    @When("user enters VnExpress password {string}")
    public void user_enters_vn_express_password(String password) {
        vnExHomePage.enterPassword(password);
    }

    @When("user clicks on VnExpress login button")
    public void user_clicks_on_vn_express_login_button() {
        vnExHomePage.clickOnLogin();
    }

    @Then("{string} text should be displayed in user profile button")
    public void text_should_be_displayed_in_user_profile_button(String username) {
        vnExHomePage.waitUntilButtonUserNameAppears();
        Assert.assertEquals(vnExHomePage.getUserNameBtnText(), username);
    }
}
