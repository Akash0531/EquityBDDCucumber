package com.equitymobile.pages.SENDMONEYMOBILE;

import com.equitymobile.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SendToMobileOption extends BasePage {

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/toSomeoneNew")
    MobileElement sendToSomeOneNewButton;

    public SendToMobileOption(){}
    //click on the option
    public SelectOperatorSendToMobile clickSendToSomeoneNew(){
        clickElement(sendToSomeOneNewButton);
        return new SelectOperatorSendToMobile();
    }


}
