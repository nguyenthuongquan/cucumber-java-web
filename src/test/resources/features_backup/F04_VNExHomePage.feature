@vnExpress
Feature: F04 - VnExpress Home page feature

  Background:
    Given user navigates to VnExpress home page

  @TC04-001
  Scenario: TC04-001 VnExpress page title
    Then verify the current page title is "VnExpress - Báo tiếng Việt nhiều người xem nhất"

  @TC04-002
  Scenario: TC04-002 VnExpress Dang Nhap link
    Then verify Dang Nhap link should be displayed

  @TC04-003
  Scenario: TC04-003 VnExpress Login with correct credentials
    And user clicks on VnExpress Dang Nhap link
    When user logins VnExpress with username "quannguyen1@gmail.com" and password "Quan@123"
    Then verify "quannguyen1" text should be displayed in user profile button