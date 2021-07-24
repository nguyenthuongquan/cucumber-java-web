package features;

import com.pages.FacebookHomePage;
import com.pages.Page;
import com.util.Constants;
import com.util.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Steps_FacebookHomePage {

    private FacebookHomePage facebookHomePage = new FacebookHomePage(DriverFactory.getDriver());
    private Page page = new Page(DriverFactory.getDriver());

    @Then("verify Facebook home page is navigated")
    public void verifyFacebookHomePageIsNavigated() {
        Assert.assertTrue(page.pageURLContains(Constants.URL_FACEBOOK_HOME_PAGE));
        Assert.assertTrue(page.pageTitleContains(Constants.TITLE_FACEBOOK_HOME_PAGE));
    }

    @And("verify left navigation bar appears for user {string} in Facebook home page")
    public void verifyLeftNavigationBarAppearsForUserInFacebookHomePage(String userName) {
        Assert.assertTrue(facebookHomePage.isLeftNavMenuDisplayedFor(userName));
    }
}
