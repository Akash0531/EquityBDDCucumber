package com.equitymobile.pages.home;

import com.equitymobile.pages.BasePage;
import com.equitymobile.pages.transfer.TransferPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {

    //Get the title of the homepage
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/youHaveLabel")
    MobileElement youHaveLabel;
    //transact button
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/transfer_landing_nav_graph")
    MobileElement transferButtonLabel;

    public HomePage(){

    }
    //get text from the label
    public String getYouHaveLabel(){
        return getTextValue(youHaveLabel);
    }
    //click on transfer
    public TransferPage clickOnTransferLanding(){
        clickElement(transferButtonLabel);
        return new TransferPage();
    }


}
