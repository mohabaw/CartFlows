
Feature: Login - Multibrowser

  # All these test cases are executed in parallel, even the examples of the outline

  @MultibrowserLogin
  Scenario: Scenario 1 - Positive test - chrome
    Given "chrome" is used
    When user is on login page
    And user enters a "error_user" and a "secret_sauce"
    And clicks on login button
    Then user is navigated to the home page

  @MultibrowserLogin
  Scenario: Scenario 2 - Positive test - firefox
    Given "firefox" is used
    When user is on login page
    And user enters a "error_user" and a "secret_sauce"
    And clicks on login button
    Then user is navigated to the home page

  @MultibrowserLogin
  Scenario Outline: Scenario - Positive tests
    Given "<browser>" is used
    When user is on login page
    And user enters a "<username>" and a "<password>"
    And clicks on login button
    Then user is navigated to the home page


    Examples:
    | browser | username  | password  |
    | chrome |  standard_user    | secret_sauce |
    | firefox  |  problem_user    | secret_sauce |
