Feature: Purchase
  # mvn clean test -Dtest=TestRunner3 -DBrowser=Firefox  : Chrome will be bypassed, Firefox will be used
  # mvn clean test -Dtest=TestRunner3                 : Chrome will be used

  @E2E
  Scenario: E2E Purchase

    Given "chrome" is used
    When user navigates to SAUCE_DEMO website
    And user enters "standard_user" and "secret_sauce"
    And user clicks on login button
    And user adds Backpack to cart
    And user goes to cart
    And user click on Checkout button
    And user enters first name "Toto", last name "Titi", and zip code "44000"
    And user clicks on Continue button
    And user clicks on Finish button
    Then the order is successful
