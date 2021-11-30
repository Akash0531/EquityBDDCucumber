package com.equitymobile.stepdef;


import com.equitymobile.pages.BUYGOODS.EnterTillNumberPage;
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

public class BuyGoods {

    @Given("^on login page click let me in button:buy goods$")
    public void on_login_page_click_let_me_in_button_buy_goods() {
        new SubsequentLoginPage().clickProceed();//clear for mobile device
        new SubsequentLoginPage().clickLogin("123456@Test");
    }
    @When("^click transfer icon:buy goods$")
    public void click_transfer_icon_buy_goods() {
        new HomePage().clickOnTransferLanding();
    }
    @When("^scroll and click buy goods$")
    public void scroll_and_click_buy_goods() {
        new BasePage().scrollDown();
        new TransferPage().clickBuyGoodsOptions();
    }
    @When("^click select merchant option:buy goods$")
    public void click_select_merchant_option_buy_goods() {
        new TransactionDetailsPage().clickSelectMerchant();
    }
    @When("^click enter till number:buy goods$")
    public void click_enter_till_number_buy_goods() {
        new EnterTillNumberPage().clickTillNumberOption();
    }
    @When("^enter till number \"([^\"]*)\":buy goods$")
    public void enter_till_number_buy_goods(String tillNumber) {
        new TillNumberPage().enterTillNumber(tillNumber);
    }
    @When("^hide keyboard and click continue:buy goods$")
    public void hide_keyboard_and_click_continue_buy_goods() {
        new BasePage().hideKeyboard();
        new TillNumberPage().clickContinueButton();
    }
    @When("^enter \"([^\"]*)\" to send:buy goods$")
    public void enter_to_send_buy_goods(String amount) {
        new TransactionDetailsPage().enterAmount(amount);
    }
    @When("^enter reason as \"([^\"]*)\" and hide keyboard:buy goods$")
    public void enter_reason_as_and_hide_keyboard_buy_goods(String reason) {
        new TransactionDetailsPage().enterPaymentReason(reason);
        new BasePage().hideKeyboard();
    }
    @When("^click send money button:buy goods$")
    public void click_send_money_button_buy_goods() {
        new TransactionDetailsPage().clickConfirmButton();
    }
    @When("^enter OTP:buy goods$")
    public void enter_otp_buy_goods() {
        new PaymentConfirmationPage().clikcConfirmBuyButton();
        new OTP().clickNeedHelp();
        new NeedHelpPage().clickTryAnotherMethod();
        new TransactionVerification().clickGetOtpByEmail();
        new TransactionVerification().clickNextButton();
        new OTP().enterOTP();
    }

    @Then( "till error \"([^\"]*)\" is displayed to the customer:buy goods")
    public void tillErrorIsDisplayedToTheCustomerBuyGoods(String tillError) {
        Assert.assertEquals(new TillNumberPage().getTillNumberErrMsg(),tillError);
    }

    @Then("transaction error is displayed as  \"([^\"]*)\":buy goods")
    public void transactionErrorIsDisplayedAsBuyGoods(String amountError) {
        Assert.assertEquals(new TransactionDetailsPage().getErrorMessage(),amountError);
    }

    @Then("^transaction success is displayed as \"([^\"]*)\":buy goods$")
    public void transaction_success_is_displayed_as_buy_goods(String transactionSuccess) {
        Assert.assertEquals(new TransactionSuccessPage().getConfirmationSuccess(),transactionSuccess);
    }


}
