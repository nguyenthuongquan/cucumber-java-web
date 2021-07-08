package parallel;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AccountsPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountsPage accountsPage;

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable credTable) {
        List<Map<String, String>> creList = credTable.asMaps();
        String username = creList.get(0).get("username");
        String password = creList.get(0).get("password");
        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        accountsPage = loginPage.doLogin(username, password);
    }

    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {
        String title = accountsPage.getAccountPageTitle();
        System.out.println("Account page title is: " + title);
    }

    @Then("user gets accounts section")
    public void user_gets_accounts_section(DataTable sectionsTable) {
        List<String> expectAccountSectionList = sectionsTable.asList();
        System.out.println("Expected accounts section list: " + expectAccountSectionList);

        List<String> actualAccountSectionList = accountsPage.getAccountSectionsList();
        System.out.println("Actual accounts section list: " + actualAccountSectionList);

        Assert.assertTrue(expectAccountSectionList.containsAll(actualAccountSectionList));
    }

    @Then("accounts section count should be {int}")
    public void accounts_section_count_should_be(Integer expectedSectionCount) {
        Assert.assertTrue(accountsPage.getAccountSectionCount() == expectedSectionCount);
    }


}
