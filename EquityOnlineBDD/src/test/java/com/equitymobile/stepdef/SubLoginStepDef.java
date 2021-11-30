package com.equitymobile.stepdef;

import com.equitymobile.pages.LoginErrorPage;
import com.equitymobile.pages.login.SubsequentLoginPage;
import com.equitymobile.pages.home.HomePage;
import com.equitymobile.pages.otp.NeedHelpPage;
import com.equitymobile.pages.otp.OTP;
import com.equitymobile.pages.otp.TransactionVerification;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SubLoginStepDef {
    int prooced =0;
    @When("^on login page enter  password as \"([^\"]*)\" on password field$")
    public void on_login_page_enter_password_as_on_password_field(String password) throws InterruptedException {
        System.out.println("sdsbfbshfsh+++++==============="+prooced);

        if(prooced==0){
            new SubsequentLoginPage().clickProceed();
        }
        new SubsequentLoginPage().enterPassword(password);
    }

    @And("^click let me in button$")
    public void click_let_me_in_button() {
        new SubsequentLoginPage().clickLoginButton();
    }

    @Then("^error message \"([^\"]*)\" is diplayed to the user$")
    public void error_message_is_diplayed_to_the_user(String errorMessage) {
        prooced =+1;
        Assert.assertEquals(new LoginErrorPage().getErrorDescription(),errorMessage);
        new LoginErrorPage().clickTryAgain();
    }

    @Then("^homepage is displayed to the user \"([^\"]*)\"$")
    public void homepage_is_displayed_to_the_user(String title) {
        //click on the help page
//        new OTP().clickNeedHelp();
//        //click try another method
//        new NeedHelpPage().clickTryAnotherMethod();
//        //choose email
//        new TransactionVerification().clickGetOtpByEmail();
//        new TransactionVerification().clickNextButton();
//        new OTP().enterOTP();
        Assert.assertEquals(new HomePage().getYouHaveLabel(),title);
    }

}
