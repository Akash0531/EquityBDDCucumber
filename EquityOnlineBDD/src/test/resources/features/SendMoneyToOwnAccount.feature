@sendMoneyOwn
Feature: Send Money to own account Scenarios
  Scenario Outline: Send money to own equity bank -positive
    Given on login page click let me in button: send money own
    When click transfer icon: send money own
    And click onw equity account : send money own
    And click send to option : send money own
    And select account to send money own
    And enter "<amount>" to send :send money own
    And enter reason as "<reason>" and hide keyboard:send money own
    And taken to review page and click confirm button:send money own
    And enter OTP:send money own
    Then transaction success is displayed as "<transactsuccess>":send money own
    Examples:
      | amount | reason | transactsuccess                         |
      | 10     | test   | Great! Your transaction was successful. |

  Scenario Outline: Send money to own equity bank negative< limit
    Given on login page click let me in button: send money own
    When click transfer icon: send money own
    And click onw equity account : send money own
    And click send to option : send money own
    And select account to send money own
    And enter "<amount>" to send :send money own
    Then error message is displayed as "<errorMessage>":send money own
    Examples:
      | amount | errorMessage                                                |
      | 0      | The minimum amount you can send is 1 KES. Please try again. |

  Scenario Outline: Send money to own equity bank negative > limit
    Given on login page click let me in button: send money own
    When click transfer icon: send money own
    And click onw equity account : send money own
    And click send to option : send money own
    And select account to send money own
    And enter "<amount>" to send :send money own
    Then error message is displayed as "<errorMessage>":send money own
    Examples:
      | amount   | errorMessage                                                      |
      | 10000000 | The maximum amount you can send is 5000000 KES. Please try again. |