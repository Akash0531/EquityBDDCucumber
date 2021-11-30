package com.equitymobile.pages.transfer.toEquity;

import com.equitymobile.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SendToEquityPage extends BasePage {
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/toSomeoneNew")
    MobileElement sendToSomeone;

    public SendToEquityPage(){}

    public RecipientPage clickSendToSomeone(){
        clickElement(sendToSomeone);
        return new RecipientPage();
    }
}
