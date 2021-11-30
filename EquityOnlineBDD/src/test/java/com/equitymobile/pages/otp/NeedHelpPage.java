package com.equitymobile.pages.otp;

import com.equitymobile.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NeedHelpPage extends BasePage {

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/tryAnotherMethodTitle")
    MobileElement tryAnotherMethod;

    public NeedHelpPage(){}

    //click try another method

    public TransactionVerification clickTryAnotherMethod(){
        clickElement(tryAnotherMethod);
        return new  TransactionVerification();
    }
}
