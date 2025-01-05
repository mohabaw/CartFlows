
Feature: Login - Monobrowser
  @LoginSystemProperties
  # mvn clean test -Dtest=TestRunner2 -DBrowser=Firefox  : Chrome will be bypassed, Firefox will be used
  # mvn clean test -Dtest=TestRunner2                 : Chrome will be used
  Scenario: Scenario 1 - Positive test - chrome or system property browser
    Given "chrome" is used
    When user is on login page
    And user enters a "error_user" and a "secret_sauce"
    And clicks on login button
    Then user is navigated to the home page


