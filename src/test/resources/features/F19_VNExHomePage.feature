@vnExpress
Feature: F19 - VnExpress Home page feature

  @TC19-001 @Smoke
  Scenario: TC19-001 VnExpress page title
    Given user is on VnExpress home page
    When user gets the title of the page
    Then page title should be "VnExpress - Báo tiếng Việt nhiều người xem nhất"

  @TC19-002 @Smoke
  Scenario: TC19-002 VnExpress Dang Nhap link
    Given user is on VnExpress home page
    Then Dang Nhap link should be displayed

  @TC19-003
  Scenario: TC19-003 VnExpress Login with correct credentials
    Given user is on VnExpress home page
    And user clicks on VnExpress Dang Nhap link
    When user logins VnExpress with username "quannguyen1@gmail.com" and password "Quan@123"
    Then "quannguyen1" text should be displayed in user profile button
