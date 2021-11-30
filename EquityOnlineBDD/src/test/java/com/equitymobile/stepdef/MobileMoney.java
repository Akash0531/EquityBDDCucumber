package com.equitymobile.stepdef;


import com.equitymobile.pages.BasePage;
import com.equitymobile.pages.SENDMONEYMOBILE.MobileOperatorDetails;
import com.equitymobile.pages.SENDMONEYMOBILE.SelectOperatorSendToMobile;
import com.equitymobile.pages.SENDMONEYMOBILE.SendToMobileOption;
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

public class MobileMoney {
    @Given("^on login page click let me in button:mobile$")
    public void on_login_page_click_let_me_in_button_mobile() {

        new SubsequentLoginPage().clickProceed();//clear for mobile device
        new SubsequentLoginPage().clickLogin("123456@Test");
    }

    @When("^click transfer icon:mobile$")
    public void click_transfer_icon_mobile() {
        new HomePage().clickOnTransferLanding();
    }

    @When("^click mobile wallet:mobile$")
    public void click_mobile_wallet_mobile() {
        new TransferPage().clickMobileMoney();
    }

    @When("^click send to option:mobile$")
    public void click_send_to_option_mobile() {
        new TransactionDetailsPage().clickMobileMoneyOption();
    }

    @When("^click send to someone new:mobile$")
    public void click_send_to_someone_new_mobile() {
        new SendToMobileOption().clickSendToSomeoneNew();
    }

    @When("^select mobile operator \"([^\"]*)\":mobile$")
    public void select_mobile_operator_mobile(String mobileOperator) {
        new SelectOperatorSendToMobile().selectMobileOperator(mobileOperator);
    }
    @When("^enter mobile details \"([^\"]*)\" ,hide keyboard and click continue:mobile$")
    public void enter_mobile_details_hide_keyboard_and_click_continue_mobile(String mobileNumber) {
        new MobileOperatorDetails().setEnterMobilePhone(mobileNumber);
        new BasePage().hideKeyboard();
        new MobileOperatorDetails().clickContinueButton();
    }
    @When("^enter \"([^\"]*)\" to send:mobile$")
    public void enter_to_send_mobile(String amount) {

        new TransactionDetailsPage().enterAmount(amount);
    }
    @When("^enter reason as \"([^\"]*)\" and hide keyboard:mobile$")
    public void enter_reason_as_and_hide_keyboard_mobile(String reason) {
        new TransactionDetailsPage().enterPaymentReason(reason);
    }
    @When("^click send money button:mobile$")
    public void click_send_money_button_mobile() {
        new TransactionDetailsPage().clickSendButton();
    }
    @When("^enter OTP:mobile$")
    public void enter_otp_mobile() {
        new PaymentConfirmationPage().clikcConfirmButton();
        new OTP().clickNeedHelp();
        new NeedHelpPage().clickTryAnotherMethod();
        new TransactionVerification().clickGetOtpByEmail();
        new TransactionVerification().clickNextButton();
        new OTP().enterOTP();
    }
    @Then("^transaction error is displayed as \"([^\"]*)\":mobile$")
    public void transactionErrorIsDisplayedAsSomethingmobile(String errordescription)  {
        Assert.assertEquals(new TransactionDetailsPage().getErrorMessage(),errordescription);
    }

    @Then("^transaction success is displayed as \"([^\"]*)\":mobile$")
    public void transaction_success_is_displayed_as_mobile(String transactionSuccess) {
        Assert.assertEquals(new TransactionSuccessPage().getConfirmationSuccess(),transactionSuccess);
    }
}
