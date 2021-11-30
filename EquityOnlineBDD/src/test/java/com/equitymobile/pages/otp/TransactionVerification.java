package com.equitymobile.pages.otp;

import com.equitymobile.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TransactionVerification  extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='By Email']")
    MobileElement byEmail;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='By Sms']")
    MobileElement bySMS;
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/nextButton")
    MobileElement contineuButton;

    public TransactionVerification(){

    }
    public  TransactionVerification clickGetOtpByEmail(){
        clickElement(byEmail);
        return this;
    }
    public  TransactionVerification clickGetOtpBySms(){
        clickElement(bySMS);
        return this;
    }
    //click continue button
    public OTP clickNextButton(){
        clickElement(contineuButton);
        return new OTP();
    }

}
