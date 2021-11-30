package com.equitymobile.pages;

import com.equitymobile.pages.login.SubsequentLoginPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginErrorPage  extends BasePage{
    //find elements
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/errorDescription")
    MobileElement errorDescription;
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/primaryButton")
    MobileElement tryAgainButton;
    public  LoginErrorPage(){

    }
    //get elementvalue
    public String getErrorDescription(){
        return getTextValue(errorDescription);
    }

    //try again
    public SubsequentLoginPage clickTryAgain(){
        clickElement(tryAgainButton);
        return new SubsequentLoginPage();
    }
}
