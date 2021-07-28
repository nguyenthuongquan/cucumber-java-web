package features_backup;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.pages.Page;
import com.util.Constants;
import com.util.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class Steps_AccountsPage {

    private Page page = new Page(DriverFactory.getDriver());
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountsPage accountsPage;

    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {
        String title = page.getPageTitle();
        System.out.println("Account page title is: " + title);
    }

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable credTable) {
        List<Map<String, String>> creList = credTable.asMaps();
        String username = creList.get(0).get("username");
        String password = creList.get(0).get("password");
        page.navigateTo(Constants.URL_HOME_PAGE);
        accountsPage = loginPage.doLogin(username, password);
    }

    @Then("verify accounts section includes")
    public void verifyAccountsSectionIncludes(DataTable sectionsTable) {
        List<String> expectAccountSectionList = sectionsTable.asList();
        System.out.println("Expected accounts section list: " + expectAccountSectionList);
        List<String> actualAccountSectionList = accountsPage.getAccountSectionsList();
        System.out.println("Actual accounts section list: " + actualAccountSectionList);
        Assert.assertTrue(expectAccountSectionList.containsAll(actualAccountSectionList));
    }

    @Then("verify accounts section count should be {int}")
    public void verifyAccountsSectionCountShouldBe(Integer expectedSectionCount) {
        Assert.assertEquals(accountsPage.getAccountSectionCount(), (int) expectedSectionCount);
    }
}
