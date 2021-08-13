package cucumber.steps;

import cucumber.pages.FacebookLandingPage;
import cucumber.pages.GeneralPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import utilities.Constants;
import utilities.ThreadLocalDriver;

public class FacebookLandingPageSteps {

    private final FacebookLandingPage facebookLandingPage = new FacebookLandingPage(ThreadLocalDriver.getDriver());
    private final GeneralPage generalPage = new GeneralPage(ThreadLocalDriver.getDriver());

    @Given("user navigates to Facebook landing page")
    public void userNavigatesToFacebookLandingPage() {
        ThreadLocalDriver.getDriver().get(Constants.URL_FACEBOOK_LANDING_PAGE);
    }

    @Then("verify Facebook landing page is navigated")
    public void verifyFacebookLandingPageIsNavigated() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(generalPage.doesTitleContain(Constants.TITLE_FACEBOOK_LANDING_PAGE));
        softAssert.assertTrue(generalPage.doesURLContain(Constants.URL_FACEBOOK_LANDING_PAGE));
        softAssert.assertAll();
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
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(generalPage.isTitleEqual(Constants.TITLE_FACEBOOK_LANDING_PAGE));
        softAssert.assertTrue(generalPage.isURLEqual(Constants.URL_FACEBOOK_LANDING_PAGE));
        softAssert.assertTrue(facebookLandingPage.isSignupFormEnabled());
        softAssert.assertAll();
    }

    @And("user logins Facebook with email {string} and password {string}")
    public void userLoginsFacebookWithEmailAndPassword(String email, String password) {
        facebookLandingPage.loginFacebook(email, password);
    }
}
