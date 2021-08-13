package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class VNExInternationalPage extends BasePage {

    private final By headers_lbl = By.xpath("//div[contains(@class,'item_menu_left')]");

    public VNExInternationalPage(WebDriver driver) {
        super(driver);
    }

    public int getHeadersCount() {
        return getElementsListSize(headers_lbl);
    }

    public List<String> getHeaderNamesList() {
        List<String> headerNamesList = new ArrayList<>();
        List<WebElement> headersList = waitAndFindAllElements(headers_lbl);
        for (WebElement e : headersList) {
            String text = e.getText();
            if (text.equals(""))
                text = "[blank]";
            System.out.println(text);
            headerNamesList.add(text);
        }
        return headerNamesList;
    }
}
