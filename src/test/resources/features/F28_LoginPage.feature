@login
Feature: F28 - Login page feature

  @TC28-001
  Scenario: TC28-001 Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Login - My Store"

  @TC28-002
  Scenario: TC28-002 Forgot Password link
    Given user is on login page
    Then forgot password link should be displayed

  @TC28-003
  Scenario: TC28-003 Login with correct credentials
    Given user is on login page
    When user enters username "quannguyen@gmail.com"
    And user enters password "Quan@123"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "My account - My Store"