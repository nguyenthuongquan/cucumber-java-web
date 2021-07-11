@accounts
Feature: F01 - Account page feature

  Background:
    Given user has already logged in to application
    |username|password|
    |quannguyen@gmail.com|Quan@123|

  @TC01-001
  Scenario: TC01-001 Accounts page title
    Given user is on Accounts page
    When user gets the title of the page
    Then page title should be "My account - My Store"

  @TC01-002 @skip_scenario
  Scenario: TC01-002 Accounts section count
    Given user is on Accounts page
    Then user gets accounts section
    |ORDER HISTORY AND DETAILS|
    |MY CREDIT SLIPS|
    |MY ADDRESSES|
    |MY PERSONAL INFORMATION|
    |MY WISHLISTS           |
    |Home                   |
    And accounts section count should be 6