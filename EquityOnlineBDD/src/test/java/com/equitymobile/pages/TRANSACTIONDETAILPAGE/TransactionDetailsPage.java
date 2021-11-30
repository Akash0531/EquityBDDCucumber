package com.equitymobile.pages.TRANSACTIONDETAILPAGE;


import com.equitymobile.pages.BUYAIRTIME.BuyAirtimeSelectPage;
import com.equitymobile.pages.BUYGOODS.EnterTillNumberPage;
import com.equitymobile.pages.BasePage;
import com.equitymobile.pages.SENDMONEYMOBILE.SendToMobileOption;
import com.equitymobile.pages.transfer.anotherbank.SelectAccountOptionPage;
import com.equitymobile.pages.transfer.toEquity.PaymentConfirmationPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TransactionDetailsPage extends BasePage {
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/payToParent")
    MobileElement selectAccount;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/editTextValue")
    MobileElement enterAmountField;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/paymentReasonValue")
    MobileElement paymentReason;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/sendActionHolder")
    MobileElement clickSendMoney;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/errorText")
    MobileElement errorMessageOwnAccount;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/payToParent")
    MobileElement selectMobileOption;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/payToParent")
    MobileElement selectContact;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/selectMerchant")
    MobileElement selectMerchantOption;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/continueAction")
    MobileElement continueButtonBuyGoods;


    public TransactionDetailsPage(){}

    public SelectAccountOptionPage clickSendToOption(){
        clickElement(selectAccount);
        return new SelectAccountOptionPage();
    }

    public TransactionDetailsPage enterPaymentReason(String paymentRe){
        sendKeys(paymentReason,paymentRe);
        return this;
    }
    public TransactionDetailsPage enterAmount(String amount){
        sendKeys(enterAmountField,amount);
        return this;
    }
    public PaymentConfirmationPage clickSendButton(){
        clickElement(clickSendMoney);
        return new PaymentConfirmationPage();
    }
    public PaymentConfirmationPage clickBuyAirtime(){
        clickElement(clickSendMoney);
        return new PaymentConfirmationPage();
    }

    public PaymentConfirmationPage clickConfirmButton(){
        clickElement(continueButtonBuyGoods);
        return new PaymentConfirmationPage();
    }


    public String getErrorMessage(){
        return getTextValue(errorMessageOwnAccount);
    }

    public SendToMobileOption clickMobileMoneyOption(){
            clickElement(selectMobileOption);
            return new SendToMobileOption();
    }

    public EnterTillNumberPage clickSelectMerchant(){
        clickElement(selectMerchantOption);
        return new EnterTillNumberPage();
    }

    public BuyAirtimeSelectPage clickSelectContactOption(){
        clickElement(selectContact);
        return new BuyAirtimeSelectPage();
    }
}
