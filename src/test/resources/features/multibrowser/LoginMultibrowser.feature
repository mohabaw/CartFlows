
Feature: Login - Multibrowser

  # All these test cases are executed in parallel, even the examples of the outline

  @MultibrowserLogin
  Scenario: Scenario 1 - Positive test - chrome
    Given "chrome" is used
    When user navigates to SAUCE_DEMO website
    And user is on login page
    And user enters "error_user" and "secret_sauce"
    And user clicks on login button
    Then user is navigated to products page

  @MultibrowserLogin
  Scenario: Scenario 2 - Positive test - firefox
    Given "firefox" is used
    When user navigates to SAUCE_DEMO website
    And user is on login page
    And user enters "error_user" and "secret_sauce"
    And user clicks on login button
    Then user is navigated to products page

  @MultibrowserLogin
  Scenario Outline: Scenari When user is on login pageo - Positive tests
    Given "<browser>" is used
    When user navigates to SAUCE_DEMO website
    And user is on login page
    And user enters "<username>" and "<password>"
    And user clicks on login button
    Then user is navigated to products page


    Examples:
    | browser | username  | password  |
    | chrome |  standard_user    | secret_sauce |
    | firefox  |  problem_user    | secret_sauce |
