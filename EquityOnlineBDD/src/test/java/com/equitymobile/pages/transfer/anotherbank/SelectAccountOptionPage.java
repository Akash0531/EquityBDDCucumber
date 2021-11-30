package com.equitymobile.pages.transfer.anotherbank;

import com.equitymobile.pages.BasePage;
import com.equitymobile.pages.transfer.ownEquity.SelectAccountDisplayedPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SelectAccountOptionPage extends BasePage {
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/toSomeoneNew")
    MobileElement anotherAccount;

    public SelectAccountOptionPage(){}

    public SearchAccountPage clickToSearchOtherBankAccount(){
        clickElement(anotherAccount);
        return new SearchAccountPage();
    }



}
