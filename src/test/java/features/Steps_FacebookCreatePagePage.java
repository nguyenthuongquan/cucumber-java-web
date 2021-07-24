package features;

import com.pages.FacebookCreatePagePage;
import com.pages.Page;
import com.util.Constants;
import com.util.DriverFactory;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Steps_FacebookCreatePagePage {

    private FacebookCreatePagePage facebookCreatePagePage = new FacebookCreatePagePage(DriverFactory.getDriver());
    private Page page = new Page(DriverFactory.getDriver());

    @Then("verify Facebook create page page is navigated")
    public void verifyFacebookCreatePagePageIsNavigated() {
        Assert.assertTrue(page.pageURLContains(Constants.URL_FACEBOOK_CREATE_PAGE_PAGE));
        Assert.assertTrue(page.pageTitleContains(Constants.TITLE_FACEBOOK_CREATE_PAGE_PAGE));
    }
}
