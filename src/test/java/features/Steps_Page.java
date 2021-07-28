package features;

import com.pages.Page;
import com.util.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.io.IOException;

public class Steps_Page {

    private Page page = new Page(DriverFactory.getDriver());

    @Given("user navigates to {string} page")
    public void user_navigates_to_page(String pageUrl) {
        page.navigateTo(pageUrl);
    }

    @Then("verify the current page title is {string}")
    public void verifyTheCurrentPageTitleIs(String expectedTitleName) {
        Assert.assertTrue(page.pageTitleIsEqual(expectedTitleName));
    }

    @Then("verify the current page title contains {string}")
    public void verifyTheCurrentPageTitleContains(String expectedTitleName) {
        Assert.assertTrue(page.pageTitleContains(expectedTitleName));
    }

    @Then("verify the current page url is {string}")
    public void verifyTheCurrentPageUrlIs(String expectedUrl) {
        Assert.assertTrue(page.pageURLIsEqual(expectedUrl));
    }

    @Then("verify the current page url contains {string}")
    public void verifyTheCurrentPageUrlContains(String expectedUrl) {
        Assert.assertTrue(page.pageURLContains(expectedUrl));
    }

    @And("take a screenshot")
    public void takeAScreenshot() throws IOException {
        page.takeScreenShot();
    }

    @Then("verify all Urls in the current page are not broken")
    public void verifyAllUrlsInTheCurrentPageAreNotBroken() {
        Assert.assertTrue(page.areAllLinksInPageWork());

    }
}
