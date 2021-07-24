package com.pages;

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

    private WebDriver driver;

    //2. Constructor
    public FacebookHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //3. Actions

}
