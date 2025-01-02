@SmokeScenario  # example of tag
Feature: feature to test login functionality

  Scenario: Check login is successful with valid credentials 2
    Given "firefox" is used
    And user is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigated to the home page

  # If we want to use parameters, use "Scenario Outline" keyword instead of "Scenario"
  Scenario Outline: Check login is successful with valid credentials 3
    Given "<browser>" is used
    Given user is on login page
    When user enters a "<username>" and a "<password>"
    And clicks on login button
    Then user is navigated to the home page

    Examples:
    | username  | password  | browser |
    |  user1        | pass1  | firefox|
    |  user2        | pass2   |chrome  |


