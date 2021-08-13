package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {

    private final By subjectHeading = By.id("id_contact");
    private final By email = By.id("email");
    private final By orderRef = By.id("id_order");
    private final By messageText = By.id("message");
    private final By sendButton = By.id("submitMessage");
    private final By successMessage = By.cssSelector("div#center_column p");
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public void fillContactUsForm(String heading, String emailId, String orderReference, String message) {
        waitAndSelect(subjectHeading, heading);
        waitAndSendKey(email, emailId);
        waitAndSendKey(orderRef, orderReference);
        waitAndSendKey(messageText, message);
    }

    public void clickSend() {
        waitAndClick(sendButton);
    }

    public String getSuccessMessage() {
        return waitAndGetText(successMessage);
    }
}
