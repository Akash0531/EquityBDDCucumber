package com.equitymobile.stepdef;

import com.equitymobile.pages.home.HomePage;
import com.equitymobile.pages.login.SubsequentLoginPage;
import com.equitymobile.pages.otp.NeedHelpPage;
import com.equitymobile.pages.otp.OTP;
import com.equitymobile.pages.otp.TransactionVerification;
import com.equitymobile.pages.transfer.TransferPage;
import com.equitymobile.pages.transfer.ownEquity.OwnEquityAccountDetailsPage;
import com.equitymobile.pages.transfer.ownEquity.SelectAccountDisplayedPage;
import com.equitymobile.pages.transfer.toEquity.PaymentConfirmationPage;
import com.equitymobile.pages.transfer.toEquity.TransactionSuccessPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SendMoneyToOwnAccountDef {

    @Given("^on login page click let me in button: send money own$")
    public void on_login_page_click_let_me_in_button_send_money_own() {
        new SubsequentLoginPage().clickProceed();//clear for mobile device
        new SubsequentLoginPage().clickLogin("@Port5050");
    }

    @When("^click transfer icon: send money own$")
    public void click_transfer_icon_send_money_own() {
        new HomePage().clickOnTransferLanding();
    }

    @When("^click onw equity account : send money own$")
    public void click_onw_equity_account_send_money_own() {
        new TransferPage().clickSendOwnEquityAccount();
    }

    @When("^click send to option : send money own$")
    public void click_send_to_option_send_money_own() {
        new OwnEquityAccountDetailsPage().clickToSelectAccount();
    }

    @When("^select account to send money own$")
    public void select_account_to_send_money_own() {
       new SelectAccountDisplayedPage().selectOwnAccount();
    }

    @When("^enter \"([^\"]*)\" to send :send money own$")
    public void enter_to_send_send_money_own(String amount) {
        new OwnEquityAccountDetailsPage().enterAmountOwnAccount(amount);

    }
    @When("^enter reason as \"([^\"]*)\" and hide keyboard:send money own$")
    public void enter_reason_as_and_hide_keyboard_send_money_own(String reason) {
    new OwnEquityAccountDetailsPage().enterReasonOwnAccount(reason);
    }
    @When("^taken to review page and click confirm button:send money own$")
    public void taken_to_review_page_and_click_confirm_button_send_money_own() {
    new OwnEquityAccountDetailsPage().clickSendMoneyButtonOwnAccount();
    }

    @When("^enter OTP:send money own$")
    public void enter_otp_send_money_own() {
        new PaymentConfirmationPage().clikcConfirmButton();
        new OTP().clickNeedHelp();
        new NeedHelpPage().clickTryAnotherMethod();
        new TransactionVerification().clickGetOtpByEmail();
        new TransactionVerification().clickNextButton();
        new OTP().enterOTP();
    }
    @Then("^error message is displayed as \"([^\"]*)\":send money own$")
    public void errorMessageIsDisplayedAsSendMoneyOwn(String errorMessage) {
        Assert.assertEquals(new OwnEquityAccountDetailsPage().getErrorMessageOwnAccount(),errorMessage);
    }
    @Then("^transaction success is displayed as \"([^\"]*)\":send money own$")
    public void transaction_success_is_displayed_as_send_money_own(String successDescription) {
        Assert.assertEquals(new TransactionSuccessPage().getConfirmationSuccess(),successDescription);
    }

}
