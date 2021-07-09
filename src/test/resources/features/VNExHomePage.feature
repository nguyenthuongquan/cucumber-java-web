Feature: VnExpress Home page feature

  @vnExpress
  Scenario: VnExpress page title
    Given user is on VnExpress home page
    When user gets the title of the page
    Then page title should be "VnExpress - Báo tiếng Việt nhiều người xem nhấtabc"

  @vnExpress
  Scenario: VnExpress Dang Nhap link
    Given user is on VnExpress home page
    Then Dang Nhap link should be displayed

  @vnExpress
  Scenario: VnExpress Login with correct credentials
    Given user is on VnExpress home page
    And user clicks on VnExpress Dang Nhap link
    When user logins VnExpress with username "quannguyen1@gmail.com" and password "Quan@123"
    Then "quannguyen1abc" text should be displayed in user profile button
