
Feature: Login - Multibrowser

  # To be run from testNGSuite.xml file

  @ReadFromTestNGSuite
  Scenario: Scenario 1
    Given user navigates to SAUCE_DEMO website
    And user is on login page
    And user enters "standard_user" and "secret_sauce"
    And user clicks on login button
    Then user is navigated to products page


