@SmokeScenario  # example of tag
Feature: feature to test login functionality

  Scenario: Check login is successful with valid credentials 1
    Given "chrome" is used
    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigated to the home page



