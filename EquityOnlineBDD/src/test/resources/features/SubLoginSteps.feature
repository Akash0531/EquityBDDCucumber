@Logins
Feature: Login Scenarios for subsequent user
  @nlog
  Scenario Outline: Login with invalid password for already signed  user
    When on login page enter  password as "<password>" on password field
    And click let me in button
    Then error message "<err>" is diplayed to the user
    Examples:
      | password  | err                                      |
      | @port5050 | The username/password couple is invalid. |
  @plog
  Scenario Outline: Login with valid password for already signed  user
    When on login page enter  password as "<password>" on password field
    And click let me in button
    Then homepage is displayed to the user "<title>"
    Examples:
      | password  | title                                   |
      | @Port5050 | You have|