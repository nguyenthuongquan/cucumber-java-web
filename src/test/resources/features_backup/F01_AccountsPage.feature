@accounts
Feature: F01 - Account page feature

  Background:
    Given user has already logged in to application
      | username             | password |
      | quannguyen@gmail.com | Quan@123 |

  @TC01-001
  Scenario: TC01-001 Accounts page title
    Then verify the current page title is "My account - My Store"

  @TC01-002
  Scenario: TC01-002 Accounts section count
    Then verify accounts section includes
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |
      | Home                      |
    And verify accounts section count should be 6