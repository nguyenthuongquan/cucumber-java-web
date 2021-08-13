package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage extends BasePage {

    private final By account_sections = By.cssSelector("div#center_column span");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    public int getAccountSectionCount() {
        return driver.findElements(account_sections).size();
    }

    public List<String> getAccountSectionsList() {
        List<String> accountList = new ArrayList<>();
        List<WebElement> accountHeaderList = driver.findElements(account_sections);
        for (WebElement e : accountHeaderList) {
            String text = e.getText();
            System.out.println(text);
            accountList.add(text);
        }
        return accountList;
    }


}
