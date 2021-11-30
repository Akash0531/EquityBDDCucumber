package com.equitymobile.pages.SENDMONEYMOBILE;

import com.equitymobile.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SelectOperatorSendToMobile  extends BasePage {

    //call class to find mobileOperator and click
    //click element to choose operator
    public SelectOperatorSendToMobile(){}

    public MobileOperatorDetails selectMobileOperator(String mobileOperator){
        clickElement(findOperator(mobileOperator));
        return new MobileOperatorDetails();
    }

}

    //pass generic value to Xpath


