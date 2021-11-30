package com.equitymobile.pages.transfer.anotherbank;

import com.equitymobile.pages.BasePage;
import com.equitymobile.pages.TRANSACTIONDETAILPAGE.TransactionDetailsPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OtherBankDetailsPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Full name']")
    MobileElement customerName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Account number']")
    MobileElement bankAccountName;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/addBeneficiary")
    MobileElement addBeneficiaryButton;

    public OtherBankDetailsPage enterCustomerName(String custName){
        sendKeys(customerName,custName);
        return this;
    }

    public OtherBankDetailsPage enterBankCustomerAcc(String bankAcc){
        sendKeys(bankAccountName,bankAcc);
        return  this;
    }
    public TransactionDetailsPage clickAddBeneficiaryButton(){
        clickElement(addBeneficiaryButton);
        return new TransactionDetailsPage();
    }

}
