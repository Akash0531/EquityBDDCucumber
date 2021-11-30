package com.equitymobile.pages.BUYAIRTIME;

import com.equitymobile.pages.BasePage;
import com.equitymobile.pages.TRANSACTIONDETAILPAGE.TransactionDetailsPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BuyAirtimeMobileDetails  extends BasePage {

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/phoneNumberValue")
    MobileElement enterMobileNumber;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/sendActionHolder")
    MobileElement addMobileButton;

    public BuyAirtimeMobileDetails enterMobileNumber(String mobileNumber){
        sendKeys(enterMobileNumber,mobileNumber);
        return this;
    }

    public TransactionDetailsPage clickAddButton(){
        clickElement(addMobileButton);
        return new TransactionDetailsPage();
    }


}
