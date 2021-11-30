package com.equitymobile.pages.transfer.toEquity;

import com.equitymobile.pages.BasePage;
import com.equitymobile.pages.transfer.TransferPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RecipientPage extends BasePage {
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/accountOrPhoneNumberValue")
    MobileElement accountField;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/addBeneficiary")
    MobileElement clickOnAdd;

    public RecipientPage(){}

    public RecipientPage enterAccountDetails(String account){
       sendKeys(accountField,account);
        return this;
    }

    public TransferPage clickAddButton(){
        clickElement(clickOnAdd);
        return new TransferPage();
    }

}
