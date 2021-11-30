package com.equitymobile.pages.transfer;

import com.equitymobile.pages.BasePage;
import com.equitymobile.pages.transfer.ownEquity.OwnEquityAccountDetailsPage;
import com.equitymobile.pages.transfer.ownEquity.SelectAccountDisplayedPage;
import com.equitymobile.pages.transfer.toEquity.PaymentConfirmationPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TransferPageDetailsConfirmation extends BasePage {
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/payToParent")
    MobileElement selectAccount;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/editTextValue")
    MobileElement enterAmountField;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/paymentReasonValue")
    MobileElement paymentReason;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/sendActionHolder")
    MobileElement clickSendMoneyOwnAccount;
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/errorText")
    MobileElement errorMessageOwnAccount;


    public TransferPageDetailsConfirmation(){}

    public SelectAccountDisplayedPage clickToSelectAccount(){
        clickElement(selectAccount);
        return new SelectAccountDisplayedPage();
    }
    public OwnEquityAccountDetailsPage enterAmountOwnAccount(String amount){
        sendKeys(enterAmountField,amount);
        return new OwnEquityAccountDetailsPage();
    }
    public OwnEquityAccountDetailsPage enterReasonOwnAccount(String reason){
        sendKeys(paymentReason,reason);
        return new OwnEquityAccountDetailsPage();
    }
    public PaymentConfirmationPage clickSendMoneyButtonOwnAccount(){
        clickElement(clickSendMoneyOwnAccount);
        return new PaymentConfirmationPage();
    }
    public  String getErrorMessageOwnAccount(){
        return getTextValue(errorMessageOwnAccount);
    }

}
