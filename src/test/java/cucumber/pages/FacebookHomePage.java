package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookHomePage extends BasePage {

    public FacebookHomePage(WebDriver driver) {
        super(driver);
    }

    private By mnu_left(String text) {
        return By.xpath("//span[@style='-webkit-box-orient:vertical;-webkit-line-clamp:2;display:-webkit-box' and text() = '" + text + "']");
    }

    private final By mnu_left_findFriends = mnu_left("Tìm kiếm bạn bè");
    private final By mnu_left_group = mnu_left("Nhóm");
    private final By mnu_left_marketPlace = mnu_left("Marketplace");
    private final By mnu_left_watch = mnu_left("Watch");
    private final By mnu_left_event = mnu_left("Sự kiện");
    private final By mnu_left_memory = mnu_left("Kỷ niệm");

    public boolean isLeftNavMenuDisplayedFor(String userName) {
        if (!isElementDisplayed(mnu_left(userName))) return false;
        if (!isElementDisplayed(mnu_left_findFriends)) return false;
        if (!isElementDisplayed(mnu_left_group)) return false;
        if (!isElementDisplayed(mnu_left_marketPlace)) return false;
        if (!isElementDisplayed(mnu_left_watch)) return false;
        if (!isElementDisplayed(mnu_left_event)) return false;
        return isElementDisplayed(mnu_left_memory);
    }


}
