@FB-LandingPage
Feature: F07 - Facebook Landing page feature

  Background:
    Given user navigates to Facebook landing page

  @TC07-001
  Scenario: TC07-001 FB Landing page - verify page 'url' and 'title'
    Then verify Facebook landing page is navigated

  @TC07-002
  Scenario: TC07-002 FB Landing page - verify 'login' button works
    When user clicks on login button in Facebook landing page
    Then verify Facebook login page is navigated

  @TC07-003
  Scenario: TC07-003 FB Landing page - verify 'forgot password' link works
    When user clicks on forgot password link in Facebook landing page
    Then verify Facebook forgot password page is navigated

  @TC07-004
  Scenario: TC07-004 FB Landing page - verify 'create account' button works
    When user clicks on create account button in Facebook landing page
    Then verify Facebook create account form is opened in Facebook landing page

  @TC07-005
  Scenario: TC07-005 FB Landing page - verify 'create page' link works
    When user clicks on create page link in Facebook landing page
    Then verify Facebook create page page is navigated