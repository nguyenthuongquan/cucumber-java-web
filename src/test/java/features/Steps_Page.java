package features;

import com.pages.Page;
import com.util.Constants;
import com.util.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Steps_Page {

    private Page page = new Page(DriverFactory.getDriver());
    private static String title;

    @Given("user is on VnExpress home page")
    public void user_is_on_vn_express_home_page() {
        page.navigateTo(Constants.URL_VNEXPRESS_HOME_PAGE);
    }

    @Given("user is on Login page")
    public void user_is_on_login_page() {
        page.navigateTo(Constants.URL_LOGIN_PAGE);
    }

    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {
        String title = page.getPageTitle();
        System.out.println("Account page title is: " + title);
    }

    @Given("user is on VnExpress International page")
    public void user_is_on_vn_express_international_page() {
        page.navigateTo(Constants.URL_VNEXPRESS_INTERNATIONAL_PAGE);
        String title = page.getPageTitle();
        System.out.println("VnExpress International page title is: " + title);
    }

    @Given("user navigates to Contact Us page")
    public void user_navigates_to_contact_us_page() {
        page.navigateTo(Constants.URL_CONTACTUS_PAGE);
    }

    @Then("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = page.getPageTitle();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(page.pageTitleContains(expectedTitleName, Constants.IMPLICIT_WAIT));
    }


}
