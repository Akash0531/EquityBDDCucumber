package com.equitymobile.stepdef;

import com.equitymobile.pages.BUYAIRTIME.BuyAirtimeErrorPage;
import com.equitymobile.pages.BUYAIRTIME.BuyAirtimeMobileDetails;
import com.equitymobile.pages.BUYAIRTIME.BuyAirtimeOperatorPage;
import com.equitymobile.pages.BUYAIRTIME.BuyAirtimeSelectPage;
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

public class BuyAirtime {

    @Given("^on login page click let me in button:buy airtime$")
    public void on_login_page_click_let_me_in_button_buy_airtime() {
        new SubsequentLoginPage().clickProceed();//clear for mobile device
        new SubsequentLoginPage().clickLogin("@Port5050");
    }
    @When("^click transfer icon:buy airtime$")
    public void click_transfer_icon_buy_airtime() {
        new HomePage().clickOnTransferLanding();
    }
    @When("^scroll and click buy airtime$")
    public void scroll_and_click_buy_airtime() {
        new BasePage().scrollDown();
        new TransferPage().clickBuyAirtime();
    }
    @When("^click select contact:buy airtime$")
    public void click_select_contact_buy_airtime() {
        new TransactionDetailsPage().clickSelectContactOption();
    }
    @When("^click buy for someone:buy airtime$")
    public void click_buy_for_someone_buy_airtime() {
        new BuyAirtimeSelectPage().clickSomeOneNew();
    }
    @When("^select mobile operator \"([^\"]*)\":buy airtime$")
    public void select_mobile_operator_buy_airtime(String mobileOperator) {
        new BuyAirtimeOperatorPage().selectMobileOperator(mobileOperator);
    }
    @When("^enter recipient details \"([^\"]*)\":buy airtime$")
    public void enter_recipient_details_buy_airtime(String mobileNumber) {

        new BuyAirtimeMobileDetails().enterMobileNumber(mobileNumber.substring(1));
    }
    @When("^click add button::buy airtime$")
    public void click_add_button_buy_airtime() {
        new BuyAirtimeMobileDetails().clickAddButton();
    }
    @When("^enter \"([^\"]*)\" to send::buy airtime$")
    public void enter_to_send_buy_airtime(String amount) {

        new TransactionDetailsPage().enterAmount(amount);
    }
    @When("^enter reason as \"([^\"]*)\" and hide keyboard:buy airtime$")
    public void enter_reason_as_and_hide_keyboard_buy_airtime(String paymentReason) {
        new TransactionDetailsPage().enterPaymentReason(paymentReason);
        new BasePage().hideKeyboard();
    }
    @When("^click send money button:buy airtime$")
    public void click_send_money_button_buy_airtime() {
        new TransactionDetailsPage().clickBuyAirtime();
        new PaymentConfirmationPage().clikcConfirmButton();
    }

    @Then("^transaction amount error is displayed as \"([^\"]*)\":buy airtime$")
    public void transactionAmountErrorIsDisplayedAsBuyAirtime(String amountError) {
        Assert.assertEquals(new TransactionDetailsPage().getErrorMessage(),amountError);
    }

    @Then("^transaction success is displayed as \"([^\"]*)\":buy airtime$")
    public void transaction_success_is_displayed_as_buy_airtime(String transactionSuccess) {
        Assert.assertEquals(new TransactionSuccessPage().getConfirmationSuccess(),transactionSuccess);
    }

}
