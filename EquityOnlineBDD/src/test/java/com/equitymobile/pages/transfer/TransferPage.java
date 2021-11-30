package com.equitymobile.pages.transfer;

import com.equitymobile.pages.BasePage;
import com.equitymobile.pages.TRANSACTIONDETAILPAGE.TransactionDetailsPage;
import com.equitymobile.pages.transfer.ownEquity.OwnEquityAccountDetailsPage;
import com.equitymobile.pages.transfer.toEquity.PaymentConfirmationPage;
import com.equitymobile.pages.transfer.toEquity.TransferToEquity;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.FindBy;

public class TransferPage  extends BasePage {

    //send to other Equity
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/toEquity")
    MobileElement sendToOtherEquity;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/toSendToOwnAccount")
    MobileElement sendToOwnEquity;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/toAccount")
    MobileElement anotherAccountOption;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/toMobileWallet")
    MobileElement sendMoneyButton;

    @FindBy(id = "ke.co.equitygroup.equitymobile.debug:id/toBuyGoods")
    MobileElement buyGoodsOption;
    String id = "Buy goods";

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/toMpesaTills")
    MobileElement payToMpesaTill;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/toBuyAirtime")
    MobileElement buyAirtime;

    public TransferPage(){}

    public TransferToEquity clickToEquityBank(){
        clickElement(sendToOtherEquity);
        return new TransferToEquity();
    }

    public TransactionDetailsPage clickMobileMoney(){
        clickElement(sendMoneyButton);
    return new TransactionDetailsPage();
    }
    public OwnEquityAccountDetailsPage clickSendOwnEquityAccount(){
        clickElement(sendToOwnEquity);
        return new OwnEquityAccountDetailsPage();
    }
    public TransactionDetailsPage clickAnotherBankOption(){
        clickElement(anotherAccountOption);
        return new TransactionDetailsPage();
    }
    public TransactionDetailsPage clickBuyGoodsOptions(){
        clickElement(buyGoodsOption);
        return new TransactionDetailsPage();
    }

    public TransactionDetailsPage clickPayToMpesaTill(){
        clickElement(payToMpesaTill);
        return new TransactionDetailsPage();
    }

    public TransactionDetailsPage clickBuyAirtime(){
        clickElement(buyAirtime);
        return new TransactionDetailsPage();
    }


    public void scrollIntoBuyGoodds(){
        scrollIntoView(buyGoodsOption,id);
    }
}
