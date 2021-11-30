package com.equitymobile.pages.BUYGOODS;

import com.equitymobile.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EnterTillNumberPage extends BasePage {

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/toEnterTillNumber")
    MobileElement enterTillNumber;

    public EnterTillNumberPage(){}
    

    public EnterTillNumberPage clickTillNumberOption(){
        clickElement(enterTillNumber);
        return new EnterTillNumberPage();
    }

}
