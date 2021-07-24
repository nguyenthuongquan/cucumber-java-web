@login
Feature: F03 - Login page feature

  @TC03-001
  Scenario: TC03-001 Login page title
    Given user is on Login page
    When user gets the title of the page
    Then page title should be "Login - My Store"

  @TC03-002
  Scenario: TC03-002 Forgot Password link
    Given user is on Login page
    Then forgot password link should be displayed

  @TC03-003
  Scenario: TC03-003 Login with correct credentials
    Given user is on Login page
    When user enters username "quannguyen@gmail.com"
    And user enters password "Quan@123"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "My account - My Store"