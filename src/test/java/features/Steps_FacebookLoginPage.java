package features;

import com.pages.FacebookLoginPage;
import com.pages.Page;
import com.util.Constants;
import com.util.DriverFactory;
import com.util.ElementUtil;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Steps_FacebookLoginPage {

    private FacebookLoginPage facebookLoginPage = new FacebookLoginPage(DriverFactory.getDriver());
    private Page page = new Page(DriverFactory.getDriver());

    @Then("verify Facebook login page is navigated")
    public void verifyFacebookLoginPageIsNavigated() {
        Assert.assertTrue(page.pageURLContains(Constants.URL_FACEBOOK_LOGIN_PAGE_WITH_TOKEN));
        Assert.assertTrue(page.pageTitleContains(Constants.TITLE_FACEBOOK_LOGIN_PAGE_WITH_TOKEN));
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
