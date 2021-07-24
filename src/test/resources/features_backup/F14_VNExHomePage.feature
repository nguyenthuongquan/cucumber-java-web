@vnExpress
Feature: F14 - VnExpress Home page feature

  @TC14-001 @Smoke
  Scenario: TC14-001 VnExpress page title
    Given user is on VnExpress home page
    When user gets the title of the page
    Then page title should be "VnExpress - Báo tiếng Việt nhiều người xem nhất"

  @TC14-002 @Smoke
  Scenario: TC14-002 VnExpress Dang Nhap link
    Given user is on VnExpress home page
    Then Dang Nhap link should be displayed

  @TC14-003
  Scenario: TC14-003 VnExpress Login with correct credentials
    Given user is on VnExpress home page
    And user clicks on VnExpress Dang Nhap link
    When user logins VnExpress with username "quannguyen1@gmail.com" and password "Quan@123"
    Then "quannguyen1" text should be displayed in user profile button
