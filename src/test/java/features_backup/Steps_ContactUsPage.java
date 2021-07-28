package features_backup;

import com.pages.ContactUsPage;
import com.pages.Page;
import com.util.Constants;
import com.util.DriverFactory;
import com.util.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class Steps_ContactUsPage {

    private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());
    private Page page = new Page(DriverFactory.getDriver());

    @Given("user navigates to Contact Us page")
    public void user_navigates_to_contact_us_page() {
        page.navigateTo(Constants.URL_CONTACTUS_PAGE);
    }

    @When("user fills the form from given sheetname {string} and rownumber {int}")
    public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData =
                reader.getData(System.getProperty("user.dir") + "/automation.xlsx", sheetName);
        String heading = testData.get(rowNumber).get("subjectheading");
        String email = testData.get(rowNumber).get("email");
        String orderRef = testData.get(rowNumber).get("orderref");
        String message = testData.get(rowNumber).get("message");
        contactUsPage.fillContactUsForm(heading, email, orderRef, message);
    }

    @When("user clicks on Send button")
    public void user_clicks_on_send_button() {
        contactUsPage.clickSend();
    }

    @Then("verify successful message {string} is shown")
    public void it_shows_a_successful_message(String expectedMessage) {
        String actualMessage = contactUsPage.getSuccessMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
