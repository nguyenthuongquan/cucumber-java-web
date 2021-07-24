package com.pages;

import com.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookHomePage {

    //1. Locators
    private final By mnu_left(String text) {
        return By.xpath("//span[@style='-webkit-box-orient:vertical;-webkit-line-clamp:2;display:-webkit-box' and text() = '"+ text +"']");
    }

    private final By mnu_left_findFriends = mnu_left("Tìm kiếm bạn bè");
    private final By mnu_left_group = mnu_left("Nhóm");
    private final By mnu_left_marketPlace = mnu_left("Marketplace");
    private final By mnu_left_watch = mnu_left("Watch");
    private final By mnu_left_event = mnu_left("Sự kiện");
    private final By mnu_left_memory = mnu_left("Kỷ niệm");

    private WebDriver driver;

    //2. Constructor
    public FacebookHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //3. Actions
    public boolean isLeftNavMenuDisplayedFor(String userName) {
        boolean a = ElementUtil.isElementIsDisplayed(mnu_left(userName));
        boolean b = ElementUtil.isElementIsDisplayed(mnu_left_findFriends);
        boolean c = ElementUtil.isElementIsDisplayed(mnu_left_group);
        boolean d = ElementUtil.isElementIsDisplayed(mnu_left_marketPlace);
        boolean e = ElementUtil.isElementIsDisplayed(mnu_left_watch);
        boolean f = ElementUtil.isElementIsDisplayed(mnu_left_event);
        boolean g = ElementUtil.isElementIsDisplayed(mnu_left_memory);
        return a && b && c && d && e && f && g;
    }

}
