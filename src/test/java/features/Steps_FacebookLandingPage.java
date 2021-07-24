package features;

import com.pages.FacebookLandingPage;
import com.pages.Page;
import com.util.Constants;
import com.util.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Steps_FacebookLandingPage {

    private FacebookLandingPage facebookLandingPage = new FacebookLandingPage(DriverFactory.getDriver());
    private Page page = new Page(DriverFactory.getDriver());

    @Given("user navigates to Facebook landing page")
    public void userNavigatesToFacebookLandingPage() {
        page.navigateTo(Constants.URL_FACEBOOK_LANDING_PAGE);
    }

    @Then("verify Facebook landing page is navigated")
    public void verifyFacebookLandingPageIsNavigated() {
        Assert.assertTrue(page.pageURLIsEqual(Constants.URL_FACEBOOK_LANDING_PAGE));
        Assert.assertTrue(page.pageTitleIsEqual(Constants.TITLE_FACEBOOK_LANDING_PAGE));
    }

    @When("user clicks on login button in Facebook landing page")
    public void userClicksOnLoginButtonInFacebookLandingPage() {
        facebookLandingPage.clickOnBtnLogin();
    }

    @When("user clicks on forgot password link in Facebook landing page")
    public void userClicksOnForgotPasswordLinkInFacebookLandingPage() {
        facebookLandingPage.clickOnLnkForgotPassword();
    }

    @When("user clicks on create account button in Facebook landing page")
    public void userClicksOnCreateAccountButtonInFacebookLandingPage() {
        facebookLandingPage.clickOnBtnSignUp();
    }

    @When("user clicks on create page link in Facebook landing page")
    public void userClicksOnCreatePageLinkInFacebookLandingPage() {
        facebookLandingPage.clickOnLnkCreatePage();
    }

    @Then("verify Facebook create account form is opened in Facebook landing page")
    public void verifyFacebookCreateAccountFormIsOpenedInFacebookLandingPage() {
        Assert.assertTrue(page.pageURLIsEqual(Constants.URL_FACEBOOK_LANDING_PAGE));
        Assert.assertTrue(page.pageTitleIsEqual(Constants.TITLE_FACEBOOK_LANDING_PAGE));
        Assert.assertTrue(facebookLandingPage.isSignupFormEnabled());
    }

    @And("user logins Facebook with email {string} and password {string}")
    public void userLoginsFacebookWithEmailAndPassword(String email, String password) {
        facebookLandingPage.loginFacebook(email, password);
    }
}
