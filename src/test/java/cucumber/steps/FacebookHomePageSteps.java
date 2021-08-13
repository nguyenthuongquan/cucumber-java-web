package cucumber.steps;

import cucumber.pages.FacebookHomePage;
import cucumber.pages.GeneralPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;
import utilities.Constants;
import utilities.ThreadLocalDriver;

public class FacebookHomePageSteps {

    private final FacebookHomePage facebookHomePage = new FacebookHomePage(ThreadLocalDriver.getDriver());
    private final GeneralPage generalPage = new GeneralPage(ThreadLocalDriver.getDriver());

    @Then("verify Facebook home page is navigated")
    public void verifyFacebookHomePageIsNavigated() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(generalPage.doesTitleContain(Constants.TITLE_FACEBOOK_HOME_PAGE));
        softAssert.assertTrue(generalPage.doesURLContain(Constants.URL_FACEBOOK_HOME_PAGE));
        softAssert.assertAll();
    }

    @And("verify left navigation bar appears for user {string} in Facebook home page")
    public void verifyLeftNavigationBarAppearsForUserInFacebookHomePage(String userName) {
        Assert.assertTrue(facebookHomePage.isLeftNavMenuDisplayedFor(userName));
    }
}
