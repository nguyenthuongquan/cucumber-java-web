@vnExpress
Feature: F09 - VnExpress Home page feature

  @TC09-001
  Scenario: TC09-001 VnExpress page title
    Given user is on VnExpress home page
    When user gets the title of the page
    Then page title should be "VnExpress - Báo tiếng Việt nhiều người xem nhất"

  @TC09-002
  Scenario: TC09-002 VnExpress Dang Nhap link
    Given user is on VnExpress home page
    Then Dang Nhap link should be displayed

  @TC09-003
  Scenario: TC09-003 VnExpress Login with correct credentials
    Given user is on VnExpress home page
    And user clicks on VnExpress Dang Nhap link
    When user logins VnExpress with username "quannguyen1@gmail.com" and password "Quan@123"
    Then "quannguyen1" text should be displayed in user profile button
