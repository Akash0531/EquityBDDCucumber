package com.equitymobile.pages.BUYGOODS;

import com.equitymobile.pages.BUYGOODS.PAYTILL.TillProvider;
import com.equitymobile.pages.BasePage;
import com.equitymobile.pages.TRANSACTIONDETAILPAGE.TransactionDetailsPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TillNumberPage extends BasePage {

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/tillNumber")
    MobileElement tillNumberFiled;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/textinput_placeholder")
    MobileElement payMpesaTill;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/addTill")
    MobileElement continueButton;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/sendActionHolder")
    MobileElement continueMpesaTill;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/textinput_error")
    MobileElement getTillErrorMessage;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/tillProviderParent")
    MobileElement selectTillProvider;

    public TillNumberPage(){}

    public TillNumberPage enterTillNumber(String tillNumber){
        sendKeys(tillNumberFiled,tillNumber);
        return this;
    }
//    public TillNumberPage enterMpesaTillNumber(String tillNumber){
//        sendKeys(payMpesaTill,tillNumber);
//        return this;
//    }

    public TransactionDetailsPage clickContinueButton(){
        clickElement(continueButton);
        return new TransactionDetailsPage();
    }
    public TransactionDetailsPage clickContinueButtonMpesaTill(){
        clickElement(continueMpesaTill);
        return new TransactionDetailsPage();
    }
    public TillNumberPage getTillNumberErrMsg(){
        getTextValue(getTillErrorMessage);
        return this;
    }
    public TillProvider selectTillProvider(){
        clickElement(selectTillProvider);
        return new TillProvider();
    }

}
