package com.equitymobile.pages.BUYAIRTIME;

import com.equitymobile.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BuyAirtimeErrorPage  extends BasePage {

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/errorDescription")
    MobileElement errorMessage;

    public BuyAirtimeErrorPage getErrorWrongPhoneNumber(){
        getTextValue(errorMessage);
        return this;
    }
}
