
Feature: Send Money to other Equity Bank Scenarios

  Scenario Outline: Send money to other bank using account number-positive
    Given on login page click let me in button:another bank
    When click transfer icon:oanother bank
    And click other bank option
    And click send to option:another bank
    And click send to bank account number
    And enter another bank name as "<bankname>" and search
    And select the searched bank from the list
    And enter customer name as "<customername>":another bank
    And enter customer account as "<bankaccount>" and hide keyboard:another bank
    And click continue button:another bank
    And enter transaction amount as "<amount>":another bank
    And enter transaction reason as "<reason>":another bank
    And click continue from the transaction review page
    And enter OTP:another bank
    Then transaction success is displayed as "<transactsuccess>":another bank
    Examples:
      | bankname | customername  | bankaccount | amount | reason | transactsuccess                         |
      | ABSA     | Denis Muthomi | 2021499377  | 500    | test   | Great! Your transaction was successful. |

  @SendOtherBank
  Scenario Outline: Send money to other bank using account number-positive
    Given on login page click let me in button:another bank
    When click transfer icon:oanother bank
    And click other bank option
    And click send to option:another bank
    And click send to bank account number
    And enter another bank name as "<bankname>" and search
    And select the searched bank from the list
    And enter customer name as "<customername>":another bank
    And enter customer account as "<bankaccount>" and hide keyboard:another bank
    And click continue button:another bank
    And enter transaction amount as "<amount>":another bank
    Then transaction error is displayed as "<transError>":another bank
    Examples:
      | bankname | customername | bankaccount | amount | transError                                                     |
      | ABSA     | John Mimera  | 2021499377  | 10     | The minimum amount you can send is 5000 UGX. Please try again. |