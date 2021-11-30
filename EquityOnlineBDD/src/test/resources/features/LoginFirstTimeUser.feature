Feature: Login Scenarios

  Scenario Outline: Login with invalid username
    Given I'm on the login page
    When I enter  username as "<username>"
    And I enter a password as "<password>"
    And I click sign in button
    Then login error message "<err>" is diplayed
    Examples:
      | username         | password  | err                                     |
      | invalid_username | @port5050 | The username/password couple is invalid |

  Scenario Outline: Login with invalid password
    Given I'm on the login page
    When I enter  username as "<username>"
    And I enter a password as "<password>"
    And I click sign in button
    Then login error message "<err>" is diplayed
    Examples:
      | username   | password     | err                                     |
      | 0765555104 | invalid_pass | The username/password couple is invalid |

  Scenario Outline: Login with valid password and username
    Given I'm on the login page
    When I enter  username as "<username>"
    And I enter a password as "<password>"
    And I click sign in button
    Then I'm taken to login authentication page with "<title>"
    Examples:
      | username   | password | title              |
      | 0765555104 | 123456   | verify transaction |