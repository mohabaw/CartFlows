@SmokeScenario  # example of tag
Feature: feature to test login functionality

  Scenario: Check login is successful with valid credentials
    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigated to the home page

    # If we want to use parameters, use "Scenario Outline" keyword instead of "Scenario"
  #Scenario Outline: Check login is successful with valid credentials
  #  Given user is on login page
   # When user enters <username> and <password>
    #And clicks on login button
   # Then user is navigated to the home page

  #  Examples:
  #  | username  | password  |
   # |  user1         | pass1  |
    #|  user2        | pass2   |


