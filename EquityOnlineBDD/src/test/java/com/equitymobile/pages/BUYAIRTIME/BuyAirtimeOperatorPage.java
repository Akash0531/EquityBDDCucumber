package com.equitymobile.pages.BUYAIRTIME;

import com.equitymobile.pages.BasePage;
import com.equitymobile.pages.SENDMONEYMOBILE.MobileOperatorDetails;

public class BuyAirtimeOperatorPage  extends BasePage {

    public BuyAirtimeMobileDetails selectMobileOperator(String mobileOperator){
        clickElement(findOperator(mobileOperator));
        return new BuyAirtimeMobileDetails();
    }
}
