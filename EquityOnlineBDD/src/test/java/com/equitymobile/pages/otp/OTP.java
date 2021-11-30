package com.equitymobile.pages.otp;

import com.equitymobile.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class OTP extends BasePage {

        @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/findBranchButtonHolder")
        MobileElement needHelp;

        @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/digit1")
        MobileElement otp_one;
        @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/digit2")
        MobileElement otp_two;
        @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/digit3")
        MobileElement otp_three;
        @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/digit4")
        MobileElement otp_four;
        @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/digit5")
        MobileElement otp_five;
        @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/digit6")
        MobileElement otp_six;

        public OTP(){}

        //click on need help page
        public NeedHelpPage clickNeedHelp(){
            clickElement(needHelp);
            return new NeedHelpPage();
        }
        //enter OTP
        public OTP enterOTP(){
            sendKeys(otp_one,"1");
            sendKeys(otp_two,"2");
            sendKeys(otp_three,"3");
            sendKeys(otp_four,"4");
            sendKeys(otp_five,"5");
            sendKeys(otp_six,"6");
            return this;
        }
}
