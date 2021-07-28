@VNInternational
Feature: F05 - VnExpress International page feature

  @TC05-001
  Scenario: TC05-001 VnExpress International page title
    Given user navigates to VnExpress home page
    When user clicks on International button
    Then verify the current page title is "VnExpress International - Latest Vietnam news, business, sports, life, travel reviews and analyses from VnExpress, Vietnam’s leading news website"

  @TC05-002
  Scenario: TC05-002 VnExpress International headers count
    Given user is on VnExpress International page
    Then verify VnExpress International headers include
      | [blank]      |
      | News         |
      | Business     |
      | Travel       |
      | Life         |
      | Sports       |
      | Perspectives |
    And verify VnExpress International headers count should be 7