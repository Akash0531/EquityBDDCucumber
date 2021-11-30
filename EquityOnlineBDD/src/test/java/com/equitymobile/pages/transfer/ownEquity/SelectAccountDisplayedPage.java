package com.equitymobile.pages.transfer.ownEquity;

import com.equitymobile.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SelectAccountDisplayedPage extends BasePage {
    //select first account
    @AndroidFindBy(xpath = "//android.widget.CheckBox[@bounds='[100,438][175,513]']")
    MobileElement selectFirstAccount;

    public SelectAccountDisplayedPage(){}

    public OwnEquityAccountDetailsPage selectOwnAccount(){
        clickElement(selectFirstAccount);
        return new OwnEquityAccountDetailsPage();
    }
}
