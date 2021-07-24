package features;

import com.pages.FacebookLandingPage;
import com.pages.FacebookLoginPage;
import com.pages.Page;
import com.util.Constants;
import com.util.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Steps_FacebookLoginPage {

    private FacebookLoginPage facebookLoginPage = new FacebookLoginPage(DriverFactory.getDriver());
    private Page page = new Page(DriverFactory.getDriver());

    @Then("verify Facebook login page is navigated")
    public void verifyFacebookLoginPageIsNavigated() {
        //Check page URL
        Assert.assertTrue(page.pageURLContains(Constants.URL_FACEBOOK_LOGIN_PAGE_WITH_TOKEN));

        //Check page title
        Assert.assertTrue(page.pageTitleContains(Constants.TITLE_FACEBOOK_LOGIN_PAGE_WITH_TOKEN));
    }



}
