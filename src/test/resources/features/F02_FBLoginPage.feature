Feature: F02 - Facebook Login page feature

  Background:
    Given user navigates to Facebook landing page

  @TC02-001
  Scenario Outline: TC02-001 FB Login page - verify login with incorrect credentials
    When user logins Facebook with email "<email>" and password "<password>"
    Then verify error "<error>" return in Facebook login page
    Examples:
      | email                               | password | error                   |
      |                                     |          | Sai thông tin đăng nhập |
      | fjkjawdakwfb24kjfđ55kd              |          | Sai thông tin đăng nhập |
      | gagnkwfnjeg@grenjc.com              |          | Sai thông tin đăng nhập |
      | test@gmail.com                      | 123456   | Sai thông tin đăng nhập |
      | quan.fbook@yahoo.com                | 123456   | Sai thông tin đăng nhập |
      | <br><br><b><u>google.com</u></b>    | 123456   | Sai thông tin đăng nhập |
      | <script>alert(\"testing\")</script> | 123456   | Sai thông tin đăng nhập |


  @TC02-002
  Scenario Outline: TC02-001 FB Login page - verify login with correct credentials
    When user logins Facebook with email "<email>" and password "<password>"
    Then verify Facebook home page is navigated
    And verify left navigation bar appears for user "Quan Book" in Facebook home page
    Examples:
      | email                | password  |
      | quan.fbook@yahoo.com | 123456!!! |
      | Quan.fbook@yahoo.com | 123456!!! |
      | QUAN.FBOOK@YAHOO.COM | 123456!!! |