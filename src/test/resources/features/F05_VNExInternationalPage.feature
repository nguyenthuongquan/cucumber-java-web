@VNInternational
Feature: F05 - VnExpress International page feature

  @TC05-001 @Smoke
  Scenario: TC05-001 VnExpress International page title
    Given user is on VnExpress home page
    When user clicks on International button
    And user gets the title of the page
    Then page title should be "VnExpress International - Latest Vietnam news, business, sports, life, travel reviews and analyses from VnExpress, Vietnam’s leading news website"

  @TC05-002
  Scenario: TC05-002 VnExpress International headers count
    Given user is on VnExpress International page
    Then user gets VnExpress headers
      |[blank]|
      |News|
      |Business|
      |Travel|
      |Life|
      |Sports|
      |Perspectives|
    And VnExpress International headers count should be 7