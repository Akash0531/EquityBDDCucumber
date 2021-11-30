Feature: Send Money to other Equity Bank Scenarios
  @sendMoneyEquity
  Scenario Outline: Send money to equity bank other account-positive
    Given on login page click let me in button
    When click transfer icon
    And click equity account
    And click send to option
    And click send to someone new
    And enter an account as "<account>" and click add button
    And enter "<amount>" to send
    And enter reason as "<reason>" and hide keyboard
    And taken to review page and click confirm button
    And enter OTP
    Then transaction success is displayed as "<transactsuccess>"
    Examples:
      | account       | amount | reason | transactsuccess                         |
      | 0170172311539 | 10     | test   | Great! Your transaction was successful. |

  @sendMoneyEquity
  Scenario Outline: Send money to equity bank other account-negative >below limit
    Given on login page click let me in button
    When click transfer icon
    And click equity account
    And click send to option
    And click send to someone new
    And enter an account as "<account>" and click add button
    And enter "<amount>" to send
    Then transaction error is displayed as "<errorDescription>"
    Examples:
      | account       | amount | errorDescription                                            |
      | 0170172311539 | 0      | The minimum amount you can send is 1 KES. Please try again. |
  @sendMoney
  Scenario Outline: Send money to equity bank other account-negative >exceed limit
    Given on login page click let me in button
    When click transfer icon
    And click equity account
    And click send to option
    And click send to someone new
    And enter an account as "<account>" and click add button
    And enter "<amount>" to send
    Then transaction error is displayed as "<errorDescription>"
    Examples:
      | account       | amount | errorDescription                                                  |
      | 0170172311539 | 0      | The maximum amount you can send is 1000000 KES. Please try again. |

  @sendMoney
  Scenario Outline: Send money to equity bank other account-negative >wrong account
    Given on login page click let me in button
    When click transfer icon
    And click equity account
    And click send to option
    And click send to someone new
    And enter an account as "<account>" and click add button
    Then toast account error is displayed as "<errorDescription>"
    Examples:
      | account | amount | errorDescription                                                  |
      | 01701   | 0      | The maximum amount you can send is 1000000 KES. Please try again. |