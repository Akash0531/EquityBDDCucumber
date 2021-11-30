package com.equitymobile.pages.SENDMONEYMOBILE;

import com.equitymobile.pages.BasePage;
import com.equitymobile.pages.TRANSACTIONDETAILPAGE.TransactionDetailsPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MobileOperatorDetails extends BasePage {

    @AndroidFindBy(id ="ke.co.equitygroup.equitymobile.debug:id/phoneNumberValue" )
    MobileElement enterMobilePhone;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/addBeButtonHolder")
    MobileElement clickContinueButton;

    public MobileOperatorDetails(){}

    public void setEnterMobilePhone(String mobileNumber){
        sendKeys(enterMobilePhone,mobileNumber);
    }

    public TransactionDetailsPage clickContinueButton(){
        clickElement(clickContinueButton);
        return new TransactionDetailsPage();
    }

}
