package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.LinkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GeneralPage extends BasePage {

    public GeneralPage(WebDriver driver) {
        super(driver);
    }

    public boolean doesTitleContain(String text) {
        return doesPageTitleContain(text);
    }

    public boolean doesURLContain(String text) {
        return doesPageURLContain(text);
    }

    public boolean isTitleEqual(String text) {
        return isPageTitleEqual(text);
    }

    public boolean isURLEqual(String text) {
        return isPageURLEqual(text);
    }

    public void navigateTo(String url) {
        navigateToPage(url);
    }

    public void navigateBack() {
        navigateBackToPreviousPage();
    }

    public void takeAScreenShot() throws IOException {
        takeScreenShot();
    }

    public boolean doAllLinksInPageWork() {
        //1. Get all link element in the page
        List<WebElement> links = driver.findElements(By.xpath("//*[@href]"));
        System.out.println("No of all link element is: " + links.size());

        //2. Get the urls from the elements
        List<String> urlList = new ArrayList<>();
        for (WebElement e : links) {
            if (e.isDisplayed()) {
                String url = e.getAttribute("href");
                urlList.add(url);
            }
        }
        System.out.println("No of links that displayed is: " + urlList.size());

        //3. Remove the duplicate urls
        List<String> urlListWithoutDuplicates = new ArrayList<>(new HashSet<>(urlList));
        System.out.println("No of links that displayed and not duplicated is: " + urlListWithoutDuplicates.size());

        //4. Remove the incorrect format urls
        urlListWithoutDuplicates.removeIf(s -> !s.startsWith("http"));
        System.out.println("No of valid links that displayed and not duplicated is: " + urlListWithoutDuplicates.size());

        //5. Print response Code and response Message of the links
        long startTime = System.currentTimeMillis();
        urlListWithoutDuplicates.parallelStream().forEach(LinkUtil::checkBrokenLink);
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (endTime - startTime));

        //Todo:
        return true;
    }

    public void switchToIFrame(By by) {
        switchToFrame(by);
    }

    public void switchBackToDefaultContent() {
        switchToDefaultContent();
    }
}
