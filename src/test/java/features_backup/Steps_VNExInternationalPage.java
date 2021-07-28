package features_backup;

import com.pages.Page;
import com.pages.VNExInternationalPage;
import com.util.Constants;
import com.util.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class Steps_VNExInternationalPage {

    private VNExInternationalPage vnExInternationalPage = new VNExInternationalPage(DriverFactory.getDriver());
    private Page page = new Page(DriverFactory.getDriver());

    @Given("user is on VnExpress International page")
    public void user_is_on_vn_express_international_page() {
        page.navigateTo(Constants.URL_VNEXPRESS_INTERNATIONAL_PAGE);
        String title = page.getPageTitle();
        System.out.println("VnExpress International page title is: " + title);
    }


    @Then("verify VnExpress International headers include")
    public void user_gets_vn_express_headers(DataTable headersTable) {
        List<String> expectHeaderNamesList = headersTable.asList(String.class);
        System.out.println("Expected header names list: " + expectHeaderNamesList);
        List<String> actualHeaderNamesList = vnExInternationalPage.getHeaderNamesList();
        System.out.println("Actual header names list: " + actualHeaderNamesList);
        Assert.assertTrue(expectHeaderNamesList.containsAll(actualHeaderNamesList));
    }

    @Then("verify VnExpress International headers count should be {int}")
    public void vn_express_international_headers_count_should_be(Integer expectedHeaderCount) {
        Assert.assertEquals(vnExInternationalPage.getHeadersCount(), (int) expectedHeaderCount);
    }

}
