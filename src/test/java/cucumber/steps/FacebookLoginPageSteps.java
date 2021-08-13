package cucumber.steps;

import cucumber.pages.FacebookLoginPage;
import cucumber.pages.GeneralPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;
import utilities.Constants;
import utilities.ThreadLocalDriver;

public class FacebookLoginPageSteps {

    private final FacebookLoginPage facebookLoginPage = new FacebookLoginPage(ThreadLocalDriver.getDriver());
    private final GeneralPage generalPage = new GeneralPage(ThreadLocalDriver.getDriver());

    @Then("verify Facebook login page is navigated")
    public void verifyFacebookLoginPageIsNavigated() {
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(generalPage.doesURLContain(Constants.URL_FACEBOOK_LOGIN_PAGE_WITH_TOKEN));
        Assert.assertTrue(generalPage.doesTitleContain(Constants.TITLE_FACEBOOK_LOGIN_PAGE_WITH_TOKEN));
        softAssert.assertAll();
    }

    @Then("verify validation errors return in Facebook login page")
    public void verifyValidationErrorsReturnInFacebookLoginPage() {
        Assert.assertTrue(facebookLoginPage.areLoginValidationErrorsReturned());
    }

    @Then("verify error {string} return in Facebook login page")
    public void verifyErrorReturnInFacebookLoginPage(String errorText) {
        Assert.assertTrue(facebookLoginPage.isLoginValidationErrorsReturned(errorText));
    }
}
