@Login
Feature: Login page feature

  @Smoke
  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Login - My Store"

  @Smoke @skip_scenario
  Scenario: Forgot Password link
    Given user is on login page
    Then forgot password link should be displayed

  @Regression @Skip @skip_scenario
  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "quannguyen@gmail.com"
    And user enters password "Quan@123"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "My account - My Store"