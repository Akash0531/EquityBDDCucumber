Feature: Pay till Scenarios
  @Paytill
  Scenario Outline: Pay to till scenario-positive
    Given on login page click let me in button:Pay till
    When click transfer icon:Pay till
    And scroll and click Pay till
    And click select merchant option:Pay till
    And click enter till number:Pay till
    And choose the mobile operator"<mobileoperator>":Pay till
    And enter till number "<tillnumber>":Pay till
    And hide keyboard and click continue:Pay till
    And enter "<amount>" to send:Pay till
    And enter reason as "<reason>" and hide keyboard:Pay till
    And click send money button:Pay till
    And enter OTP:Pay till
    Then transaction success is displayed as "<transactsuccess>":Pay till
    Examples:
      | mobileoperator | tillnumber |  | amount | reason | transactsuccess             |
      | M-PESA         | 0766999926 |  | 100    | test   | Your payment was successful |