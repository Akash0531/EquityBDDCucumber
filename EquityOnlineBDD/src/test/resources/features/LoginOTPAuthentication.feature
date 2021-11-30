Feature: Login authentication Scenarios

  Scenario Outline: Authenticate with wrong OTP
    Given I'm on the login OTP authentication page
    When I click need help button
    And And I click try another method option
    And I verify transaction page is displayed with "<title>"
    And I select to receive OTP by email
    And I click continue button
    And I'm taken to OTTP authentication page and I enter "<OTP>"
    Then authetication error message is displayed as "<errmessage>"
    Examples:
      | title             | OTP    | errmessage |
      | verify transction | 123454 | wrong otp  |