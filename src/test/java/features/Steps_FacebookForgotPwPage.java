package features;

import com.pages.FacebookForgotPwPage;
import com.pages.FacebookLoginPage;
import com.pages.Page;
import com.util.Constants;
import com.util.DriverFactory;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Steps_FacebookForgotPwPage {

    private FacebookForgotPwPage facebookForgotPwPage = new FacebookForgotPwPage(DriverFactory.getDriver());
    private Page page = new Page(DriverFactory.getDriver());

    @Then("verify Facebook forgot password page is navigated")
    public void verifyFacebookForgotPasswordPageIsNavigated() {
        //Check page URL
        Assert.assertTrue(page.pageURLIsEqual(Constants.URL_FACEBOOK_FORGOT_PW_PAGE));

        //Check page title
        Assert.assertTrue(page.pageTitleIsEqual(Constants.TITLE_FACEBOOK_FORGOT_PW_PAGE));
    }
}
