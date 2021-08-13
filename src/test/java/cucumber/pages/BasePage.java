package cucumber.pages;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import utilities.Constants;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(Constants.TIMEOUT))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
    }

    //ELEMENT
    protected boolean isElementDisplayed(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
    }

    protected WebElement waitAndFindElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement waitAndFindElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected String waitAndGetText(By by) {
        return waitAndFindElement(by).getText();
    }

    protected String waitAndGetText(WebElement element) {
        return waitAndFindElement(element).getText();
    }

    protected void waitAndSendKey(By by, String text) {
        waitAndFindElement(by).sendKeys(text);
    }

    protected void waitAndSendKey(WebElement element, String text) {
        waitAndFindElement(element).sendKeys(text);
    }

    protected void waitAndSelect(By by, String text) {
        Select select = new Select(waitAndFindElement(by));
        select.selectByVisibleText(text);
    }

    protected void waitAndClick(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    protected void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    protected void click(By by) {
        driver.findElement(by).click();
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected void clickIfDisplayed(WebElement element) {
        if (wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed()) {
            wait.until(ExpectedConditions.visibilityOf(element)).click();
        }
    }

    //LIST ELEMENTS
    protected int getElementsListSize(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by)).size();
    }

    protected List<WebElement> waitAndFindAllElements(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    protected List<WebElement> waitAndFindAllElements(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    //PAGE
    protected void navigateToPage(String url) {
        driver.get(url);
    }

    protected void navigateBackToPreviousPage() {
        driver.navigate().back();
    }

    protected String getCurrentPageTitle() {
        return driver.getTitle();
    }

    protected String getCurrentPageURL() {
        return driver.getCurrentUrl();
    }

    @SneakyThrows
    protected boolean doesPageTitleContain(String text) {
        wait.until(ExpectedConditions.titleContains(text));
        return getCurrentPageTitle().contains(text);
    }

    @SneakyThrows
    protected boolean isPageTitleEqual(String text) {
        wait.until(ExpectedConditions.titleIs(text));
        return getCurrentPageTitle().equals(text);
    }

    @SneakyThrows
    protected boolean doesPageURLContain(String text) {
        wait.until(ExpectedConditions.urlContains(text));
        return getCurrentPageURL().contains(text);
    }

    @SneakyThrows
    protected boolean isPageURLEqual(String text) {
        wait.until(ExpectedConditions.urlToBe(text));
        return getCurrentPageURL().equals(text);
    }

    //SCREENSHOT
    protected void takeScreenShot() throws IOException {
        String date = new SimpleDateFormat("yyMMdd-HHmmss-SS").format(new Date());
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshots/" + date + ".png"));
    }

    //IFRAME
    @SneakyThrows
    protected void switchToFrame(By by) {
        driver.switchTo().frame(waitAndFindElement(by));
        Thread.sleep(1000);
    }

    @SneakyThrows
    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
    }
}
