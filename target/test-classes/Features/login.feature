Feature: Test login functionalities of amazon
  Scenario: Check login is successful with valid credentials
    Given a user is on the login page of amazon
    When user enter username and click on Continue button
    And user enter password and click on sign-in button
    Then user is navigated to home page login of amazon