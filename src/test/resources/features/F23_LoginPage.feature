@login
Feature: F23 - Login page feature

  @TC23-001
  Scenario: TC23-001 Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Login - My Store"

  @TC23-002
  Scenario: TC23-002 Forgot Password link
    Given user is on login page
    Then forgot password link should be displayed

  @TC23-003
  Scenario: TC23-003 Login with correct credentials
    Given user is on login page
    When user enters username "quannguyen@gmail.com"
    And user enters password "Quan@123"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "My account - My Store"