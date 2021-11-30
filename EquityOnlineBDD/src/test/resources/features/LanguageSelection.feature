@test
Feature: Language Selection
  Scenario Outline: Select language after launching the app

    When I open the app and select language
    And  And I click continue button
    Then I'm taken to the welcome page with title <"title">
    Examples:
      | title                    |
      | Welcome to Equity mobile |