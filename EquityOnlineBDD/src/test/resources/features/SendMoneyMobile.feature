Feature: Send Money to Mobile Money Scenarios
  @sendMoneyMobile
  Scenario Outline: Send money to Mobile Money:mobile-positive
    Given on login page click let me in button:mobile
    When click transfer icon:mobile
    And click mobile wallet:mobile
    And click send to option:mobile
    And click send to someone new:mobile
    And select mobile operator "<mobileoperator>":mobile
    And enter mobile details "<mobilenumber>" ,hide keyboard and click continue:mobile
    And enter "<amount>" to send:mobile
    And enter reason as "<reason>" and hide keyboard:mobile
    And click send money button:mobile
    And enter OTP:mobile
    Then transaction success is displayed as "<transactsuccess>":mobile
    Examples:
      | mobileoperator | mobilenumber | amount | reason | transactsuccess                         |
      | M-PESA         | 0722000000   | 100    | test   | Great! Your transaction was successful. |
      | Airtel Money   | 733000000    | 100    | test   | Great! Your transaction was successful. |

  @sendMoneyMobile
  Scenario Outline: Send money to Mobile Money:mobile-positive
    Given on login page click let me in button:mobile
    When click transfer icon:mobile
    And click mobile wallet:mobile
    And click send to option:mobile
    And click send to someone new:mobile
    And select mobile operator "<mobileoperator>":mobile
    And enter mobile details "<mobilenumber>" ,hide keyboard and click continue:mobile
    And enter "<amount>" to send:mobile
    Then transaction error is displayed as "<errorDescription>":mobile
    Examples:
      | mobileoperator | mobilenumber | amount   | errorDescription                                                 |
      | M-PESA         | 722000000    | 10       | The minimum amount you can send is 100 KES. Please try again.    |
      | Airtel Money        | 722000000    | 10000000 | The maximum amount you can send is 140000 KES. Please try again. |