package com.equitymobile.pages.transfer.anotherbank;

import com.equitymobile.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchAccountPage  extends BasePage {
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/searchValue")
    MobileElement searchOtherBank;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/otherBankList")
    MobileElement searchedAccountAnotherBank;

    public SearchAccountPage(){}

    public OtherBankDetailsPage selectSearchedBank(){
        clickElement(searchedAccountAnotherBank);
        return new OtherBankDetailsPage();
    }
    public SearchAccountPage searchAccountPage(String banksName){
        sendKeys(searchOtherBank,banksName);
        return this;
    }


}
