package com.equitymobile.pages.transfer.toEquity;

import com.equitymobile.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TransactionSuccessPage extends BasePage {

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/thankDetails")
    MobileElement successDescription;

    public TransactionSuccessPage(){}

    public String getConfirmationSuccess(){
        return getTextValue(successDescription);
    }
}
