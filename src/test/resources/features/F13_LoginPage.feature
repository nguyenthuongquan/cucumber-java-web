@login
Feature: F13 - Login page feature

  @TC13-001
  Scenario: TC13-001 Login page title
    Given user is on Login page
    When user gets the title of the page
    Then page title should be "Login - My Store"

  @TC13-002
  Scenario: TC13-002 Forgot Password link
    Given user is on Login page
    Then forgot password link should be displayed

  @TC13-003
  Scenario: TC13-003 Login with correct credentials
    Given user is on Login page
    When user enters username "quannguyen@gmail.com"
    And user enters password "Quan@123"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "My account - My Store"