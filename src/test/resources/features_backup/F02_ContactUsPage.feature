@contactUs
Feature: F02 - Contact Us page feature

  @TC02-001
  Scenario Outline: TC02-001 Contact Us scenario with different set of data
    Given user navigates to Contact Us page
    When user fills the form from given sheetname "<SheetName>" and rownumber <RowNumber>
    And user clicks on Send button
    Then it shows a successful message "Your message has been successfully sent to our team."

    Examples:
      | SheetName | RowNumber |
      | contactus | 0         |
      | contactus | 1         |
      | contactus | 2         |
      | contactus | 3         |
      | contactus | 4         |
      | contactus | 5         |