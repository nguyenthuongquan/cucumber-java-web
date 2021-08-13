package cucumber.steps;

import cucumber.pages.FacebookCreatePagePage;
import cucumber.pages.GeneralPage;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import utilities.Constants;
import utilities.ThreadLocalDriver;

public class FacebookCreatePagePageSteps {

    private final FacebookCreatePagePage facebookCreatePagePage = new FacebookCreatePagePage(ThreadLocalDriver.getDriver());
    private final GeneralPage generalPage = new GeneralPage(ThreadLocalDriver.getDriver());

    @Then("verify Facebook create page page is navigated")
    public void verifyFacebookCreatePagePageIsNavigated() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(generalPage.doesTitleContain(Constants.TITLE_FACEBOOK_CREATE_PAGE_PAGE));
        softAssert.assertTrue(generalPage.doesURLContain(Constants.URL_FACEBOOK_CREATE_PAGE_PAGE));
        softAssert.assertAll();
    }
}
