package cucumber.steps;

import cucumber.pages.FacebookForgotPwPage;
import cucumber.pages.GeneralPage;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import utilities.Constants;
import utilities.ThreadLocalDriver;

public class FacebookForgotPwPageSteps {

    private final FacebookForgotPwPage facebookForgotPwPage = new FacebookForgotPwPage(ThreadLocalDriver.getDriver());
    private final GeneralPage generalPage = new GeneralPage(ThreadLocalDriver.getDriver());

    @Then("verify Facebook forgot password page is navigated")
    public void verifyFacebookForgotPasswordPageIsNavigated() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(generalPage.doesTitleContain(Constants.TITLE_FACEBOOK_FORGOT_PW_PAGE));
        softAssert.assertTrue(generalPage.doesURLContain(Constants.URL_FACEBOOK_FORGOT_PW_PAGE));
        softAssert.assertAll();
    }
}
