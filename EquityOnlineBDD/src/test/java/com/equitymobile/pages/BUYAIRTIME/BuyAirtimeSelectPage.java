package com.equitymobile.pages.BUYAIRTIME;

import com.equitymobile.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BuyAirtimeSelectPage extends BasePage {
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/toSomeoneNew")
    MobileElement buySomeoneNewButton;

    public BuyAirtimeSelectPage(){}

    public BuyAirtimeOperatorPage clickSomeOneNew(){
        clickElement(buySomeoneNewButton);
        return new BuyAirtimeOperatorPage();
    }


}
