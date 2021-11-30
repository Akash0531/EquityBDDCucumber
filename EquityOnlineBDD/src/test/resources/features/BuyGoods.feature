Feature: Buy goods Scenarios
  @BuyGoods
  Scenario Outline: Buy goods scenario-positive
    Given on login page click let me in button:buy goods
    When click transfer icon:buy goods
    And scroll and click buy goods
    And click select merchant option:buy goods
    And click enter till number:buy goods
    And enter till number "<tillnumber>":buy goods
    And hide keyboard and click continue:buy goods
    And enter "<amount>" to send:buy goods
    And enter reason as "<reason>" and hide keyboard:buy goods
    And click send money button:buy goods
    And enter OTP:buy goods
    Then transaction success is displayed as "<transactsuccess>":buy goods
    Examples:
      | tillnumber | amount | reason | transactsuccess             |
      | 0766999926 | 100    | test   | Your payment was successful |
  @BuyGoods
  Scenario Outline: Buy goods scenario-Negative
    Given on login page click let me in button:buy goods
    When click transfer icon:buy goods
    And scroll and click buy goods
    And click select merchant option:buy goods
    And click enter till number:buy goods
    And enter till number "<tillnumber>":buy goods
    And hide keyboard and click continue:buy goods
    Then till error "<tillError>" is displayed to the customer:buy goods
    Examples:
      | tillnumber | tillError                                                                           |
      | 0766999926 | It looks like the till number you entered is incorrect, please relook and try again |
  @BuyGoods
  Scenario Outline: Buy goods scenario-positive
    Given on login page click let me in button:buy goods
    When click transfer icon:buy goods
    And scroll and click buy goods
    And click select merchant option:buy goods
    And click enter till number:buy goods
    And enter till number "<tillnumber>":buy goods
    And hide keyboard and click continue:buy goods
    And enter "<amount>" to send:buy goods
    And enter reason as "<reason>" and hide keyboard:buy goods
    Then transaction error is displayed as "<tillError>":buy goods
    Examples:
      | tillnumber | amount | reason | tillError             |
      | 0766999926 | 100    | test   | Your payment was successful |