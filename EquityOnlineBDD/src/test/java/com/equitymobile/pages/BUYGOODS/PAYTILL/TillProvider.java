package com.equitymobile.pages.BUYGOODS.PAYTILL;

import com.equitymobile.pages.BasePage;
import com.equitymobile.pages.SENDMONEYMOBILE.MobileOperatorDetails;

public class TillProvider extends BasePage {

    public MobileOperatorDetails selectMobileOperator(String mobileOperator){
        clickElement(findOperator(mobileOperator));
        return new MobileOperatorDetails();
    }


}
