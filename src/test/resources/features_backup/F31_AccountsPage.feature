@accounts
Feature: F31 - Account page feature

  Background:
    Given user has already logged in to application
      | username             | password |
      | quannguyen@gmail.com | Quan@123 |

  @TC31-001
  Scenario: TC31-001 Accounts page title
    Given user is on Accounts page
    When user gets the title of the page
    Then page title should be "My account - My Store"

  @TC31-002
  Scenario: TC31-002 Accounts section count
    Given user is on Accounts page
    Then user gets accounts section
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |
      | Home                      |
    And accounts section count should be 6