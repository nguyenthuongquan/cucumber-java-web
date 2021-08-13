package cucumber.steps;

import cucumber.pages.GeneralPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.ThreadLocalDriver;

import java.io.IOException;

public class GeneralPageSteps {

    private final GeneralPage generalPage = new GeneralPage(ThreadLocalDriver.getDriver());

    @Given("user navigates to {string} page")
    public void user_navigates_to_page(String pageUrl) {
        generalPage.navigateTo(pageUrl);
    }

    @Then("verify the current page title is {string}")
    public void verifyTheCurrentPageTitleIs(String expectedTitleName) {
        Assert.assertTrue(generalPage.isTitleEqual(expectedTitleName));
    }

    @Then("verify the current page title contains {string}")
    public void verifyTheCurrentPageTitleContains(String expectedTitleName) {
        Assert.assertTrue(generalPage.doesTitleContain(expectedTitleName));
    }

    @Then("verify the current page url is {string}")
    public void verifyTheCurrentPageUrlIs(String expectedUrl) {
        Assert.assertTrue(generalPage.isURLEqual(expectedUrl));
    }

    @Then("verify the current page url contains {string}")
    public void verifyTheCurrentPageUrlContains(String expectedUrl) {
        Assert.assertTrue(generalPage.doesURLContain(expectedUrl));
    }

    @And("take a screenshot")
    public void takeAScreenshot() throws IOException {
        generalPage.takeAScreenShot();
    }

    @Then("verify all Urls in the current page are not broken")
    public void verifyAllUrlsInTheCurrentPageAreNotBroken() {
        Assert.assertTrue(generalPage.doAllLinksInPageWork());
    }
}
