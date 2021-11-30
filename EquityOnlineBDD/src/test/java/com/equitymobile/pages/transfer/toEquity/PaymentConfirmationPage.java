package com.equitymobile.pages.transfer.toEquity;

import com.equitymobile.pages.BasePage;
import com.equitymobile.pages.otp.OTP;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PaymentConfirmationPage extends BasePage {

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/sendActionHolder")
    MobileElement confirmButton;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/buyButtonHolder")
    MobileElement confirmBuyGoods;

    public PaymentConfirmationPage(){}

    public OTP clikcConfirmButton(){
        clickElement(confirmButton);
        return new OTP();
    }

    public OTP clikcConfirmBuyButton(){
        clickElement(confirmBuyGoods);
        return new OTP();
    }

}
