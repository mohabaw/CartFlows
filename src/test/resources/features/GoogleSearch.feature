@GoogleSearch  # we can put the tag here
Feature: feature to test Google Search functionality
  # @GoogleSearch: we can put the tag here
  Scenario: Validate Google search is working
    Given "firefox" is used
    And browser is open
    And user is on google search page
    When user enters a text in search box
    And hits enter
    Then user is navigated to search results