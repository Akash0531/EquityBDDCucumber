@test
Feature: Welcome Page

  Scenario Outline: Welcome page after selecting language

    When I click the continue button
    And  And I click get started button
    Then I'm taken to the login screen
    Examples:
      |  |  |  |
      |  |  |  |