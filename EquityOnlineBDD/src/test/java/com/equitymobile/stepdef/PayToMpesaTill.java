package com.equitymobile.stepdef;

import com.equitymobile.pages.BUYGOODS.EnterTillNumberPage;
import com.equitymobile.pages.BUYGOODS.PAYTILL.TillProvider;
import com.equitymobile.pages.BUYGOODS.TillNumberPage;
import com.equitymobile.pages.BasePage;
import com.equitymobile.pages.TRANSACTIONDETAILPAGE.TransactionDetailsPage;
import com.equitymobile.pages.home.HomePage;
import com.equitymobile.pages.login.SubsequentLoginPage;
import com.equitymobile.pages.otp.NeedHelpPage;
import com.equitymobile.pages.otp.OTP;
import com.equitymobile.pages.otp.TransactionVerification;
import com.equitymobile.pages.transfer.TransferPage;
import com.equitymobile.pages.transfer.toEquity.PaymentConfirmationPage;
import com.equitymobile.pages.transfer.toEquity.TransactionSuccessPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class PayToMpesaTill {

    @Given("^on login page click let me in button:Pay till$")
    public void on_login_page_click_let_me_in_button_pay_till() {
        new SubsequentLoginPage().clickProceed();//clear for mobile device
        new SubsequentLoginPage().clickLogin("@Port5050");
    }
    @When("^click transfer icon:Pay till$")
    public void click_transfer_icon_pay_till() {
        new HomePage().clickOnTransferLanding();
    }
    @When("^scroll and click Pay till$")
    public void scroll_and_click_pay_till() {
        new BasePage().scrollDown();
        new TransferPage().clickPayToMpesaTill();
    }
    @When("^click select merchant option:Pay till$")
    public void click_select_merchant_option_pay_till() {
        new TransactionDetailsPage().clickSelectMerchant();
    }
    @When("^click enter till number:Pay till$")
    public void click_enter_till_number_pay_till() {
        new EnterTillNumberPage().clickTillNumberOption();

    }

    @When("^choose the mobile operator\"([^\"]*)\":Pay till$")
    public void chooseTheMobileOperatorPayTill(String tillProvider) {
        new TillNumberPage().selectTillProvider();
        new TillProvider().selectMobileOperator(tillProvider);
    }
    @When("^enter till number \"([^\"]*)\":Pay till$")
    public void enter_till_number_pay_till(String tillNumber) {
        new TillNumberPage().enterTillNumber(tillNumber);
    }

    @When("^hide keyboard and click continue:Pay till$")
    public void hide_keyboard_and_click_continue_pay_till() {
        new BasePage().hideKeyboard();
        new TillNumberPage().clickContinueButtonMpesaTill();
    }
    @When("^enter \"([^\"]*)\" to send:Pay till$")
    public void enter_to_send_pay_till(String amount) {
        new TransactionDetailsPage().enterAmount(amount);
    }

    @When("^enter reason as \"([^\"]*)\" and hide keyboard:Pay till$")
    public void enter_reason_as_and_hide_keyboard_pay_till(String paymentReason) {
        new TransactionDetailsPage().enterPaymentReason(paymentReason);
        new BasePage().hideKeyboard();
    }
    @When("^click send money button:Pay till$")
    public void click_send_money_button_pay_till() {
        new TransactionDetailsPage().clickConfirmButton();
    }

    @When("^enter OTP:Pay till$")
    public void enter_otp_pay_till() {
        new PaymentConfirmationPage().clikcConfirmBuyButton();
        new OTP().clickNeedHelp();
        new NeedHelpPage().clickTryAnotherMethod();
        new TransactionVerification().clickGetOtpByEmail();
        new TransactionVerification().clickNextButton();
        new OTP().enterOTP();
    }
    @Then("^transaction success is displayed as \"([^\"]*)\":Pay till$")
    public void transaction_success_is_displayed_as_pay_till(String transactionSuccess) {
        Assert.assertEquals(new TransactionSuccessPage().getConfirmationSuccess(),transactionSuccess);
    }


}
