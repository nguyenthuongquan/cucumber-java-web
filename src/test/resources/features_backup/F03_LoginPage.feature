@login
Feature: F03 - Login page feature

  Background:
    Given user navigates to Login page

  @TC03-001
  Scenario: TC03-001 Login page title
    Then verify the current page title is "Login - My Store"

  @TC03-002
  Scenario: TC03-002 Forgot Password link
    Then verify forgot password link should be displayed

  @TC03-003
  Scenario: TC03-003 Login with correct credentials
    When user enters username "quannguyen@gmail.com"
    And user enters password "Quan@123"
    And user clicks on Login button
    Then verify the current page title is "My account - My Store"