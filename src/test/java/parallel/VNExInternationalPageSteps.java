package parallel;

import com.pages.VNExInternationalPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.*;

public class VNExInternationalPageSteps {

    private VNExInternationalPage vnExInternationalPage = new VNExInternationalPage(DriverFactory.getDriver());

    @Given("user is on VnExpress International page")
    public void user_is_on_vn_express_international_page() {
        DriverFactory.getDriver().get("https://e.vnexpress.net/");
        String title = vnExInternationalPage.getPageTitle();
        System.out.println("VnExpress International page title is: " + title);
    }


    @Then("user gets VnExpress headers")
    public void user_gets_vn_express_headers(DataTable headersTable) {
        List<String> expectHeaderNamesList = headersTable.asList(String.class);
        System.out.println("Expected header names list: " + expectHeaderNamesList);
        List<String> actualHeaderNamesList = vnExInternationalPage.getHeaderNamesList();
        System.out.println("Actual header names list: " + actualHeaderNamesList);
        Assert.assertTrue(expectHeaderNamesList.containsAll(actualHeaderNamesList));
    }

    @Then("VnExpress International headers count should be {int}")
    public void vn_express_international_headers_count_should_be(Integer expectedHeaderCount) {
        Assert.assertEquals(vnExInternationalPage.getHeadersCount(), (int) expectedHeaderCount);

    }


}
