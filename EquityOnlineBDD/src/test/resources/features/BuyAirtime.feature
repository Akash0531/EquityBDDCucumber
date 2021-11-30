Feature: Buy airtime Scenarios

  Scenario Outline: Buy airtime-positive
    Given on login page click let me in button:buy airtime
    When click transfer icon:buy airtime
    And scroll and click buy airtime
    And click select contact:buy airtime
    And click buy for someone:buy airtime
    And select mobile operator "<mobileoperator>":buy airtime
    And enter recipient details "<recipientmobile>":buy airtime
    And click add button::buy airtime
    And enter "<amount>" to send::buy airtime
    And enter reason as "<reason>" and hide keyboard:buy airtime
    And click send money button:buy airtime
    And enter OTP:buy airtime
    Then transaction success is displayed as "<transactsuccess>":buy airtime
    Examples:
      | mobileoperator | recipientmobile | amount | reason | transactsuccess                 |
      | Safaricom      | 0722000000      | 100    | test   | Airtime Request being processed |
      | Airtel         | 0733000000      | 100    | test   | Airtime Request being processed |

  @BuyAirtime
  Scenario Outline: Buy airtime:wrong amount-Negative
    Given on login page click let me in button:buy airtime
    When click transfer icon:buy airtime
    And scroll and click buy airtime
    And click select contact:buy airtime
    And click buy for someone:buy airtime
    And select mobile operator "<mobileoperator>":buy airtime
    And enter recipient details "<recipientmobile>":buy airtime
    And click add button::buy airtime
    And enter "<amount>" to send::buy airtime
    Then transaction amount error is displayed as "<transacterror>":buy airtime
    Examples:
      | mobileoperator | recipientmobile | amount | transacterror                                         |
      | Safaricom      | 0764553345      | 0      | The amount can’t be less than 5 KES, please try again |

