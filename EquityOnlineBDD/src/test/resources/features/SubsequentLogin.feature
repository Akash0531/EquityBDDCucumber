@login
Feature: Login Scenarios for subsequent user

  Scenario Outline: Login with invalid username for already logged in user
    Given I click on sign in button
    When I enter  username as "<username>" on username field
    And I enter a password as "<password>" on password field
    And click sign in button
    Then error message "<err>" is diplayed
    Examples:
      | username         | password  | err                                     |
      | invalid_username | @port5050 | The username/password couple is invalid |

  Scenario Outline: Login with invalid password for already logged in user
    Given I click on sign in button
    When I enter  username as "<username>" on username field
    And I enter a password as "<password>" on password field
    And click sign in button
    Then error message "<err>" is diplayed
    Examples:
      | username   | password     | err                                     |
      | 0765555104 | invalid_pass | The username/password couple is invalid |

  Scenario Outline: Login with valid password and username for already logged in user
    Given I click on sign in button
    When I enter  username as "<username>" on username field
    And I enter a password as "<password>" on password field
    And click sign in button
    Then I'm taken to homepage with title "<title>"
    Examples:
      | username   | password | title              |
      | 0765555104 | 123456   | verify transaction |