package com.equitymobile.pages.transfer.toEquity;

import com.equitymobile.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TransferToEquity extends BasePage {

    //click on the transfer to Equity
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/payToParent")
    MobileElement payToAccount;

    //enter the amount
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/editTextValue")
    MobileElement amountField;

    //reason field
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/paymentReasonValue")
    MobileElement reasonField;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/sendActionHolder")
    MobileElement sendMoney;

    //error description
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/errorText")
    MobileElement errorDescription;

    //toast message
    @AndroidFindBy(xpath = "//android.widget.Toast[1]")
    MobileElement toastMessage;

    public TransferToEquity(){}

    public SendToEquityPage clickSendTo(){
        clickElement(payToAccount);
        return new SendToEquityPage();
    }
    public TransferToEquity enterAmount(String amount){
        sendKeys(amountField,amount);
        return new TransferToEquity();
    }

    public TransferToEquity enterPayReason(String reason){
        sendKeys(reasonField,reason);
        return new TransferToEquity();
    }

    public PaymentConfirmationPage clickSendMoney(){
        clickElement(sendMoney);
        return new PaymentConfirmationPage();
    }
    public String getErrorDescription(){
        return getTextValue(errorDescription);
    }

    //click to get the toast message
    public String getToastErrorMessage(){
        return getTextValue(toastMessage);
}

}
