package com.equitymobile.stepdef;

import com.equitymobile.pages.BasePage;
import com.equitymobile.pages.home.HomePage;
import com.equitymobile.pages.login.SubsequentLoginPage;
import com.equitymobile.pages.otp.NeedHelpPage;
import com.equitymobile.pages.otp.OTP;
import com.equitymobile.pages.otp.TransactionVerification;
import com.equitymobile.pages.transfer.TransferPage;
import com.equitymobile.pages.transfer.toEquity.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.Assert;

public class SendMoneyToOtherEqu {

    @Given("^on login page click let me in button$")
    public void on_login_page_click_let_me_in_button() {
        // Write code here that turns the phrase above into concrete actions
        //login
        new SubsequentLoginPage().clickProceed();//clear for mobile device
        new SubsequentLoginPage().clickLogin("123456@Test");
    }
    @When("^click transfer icon$")
    public void click_transfer_icon() {
        new HomePage().clickOnTransferLanding();
    }

    @And("^click equity account$")
    public void click_equity_account() {
      new TransferPage().clickToEquityBank();
    }

    @And("^click send to option$")
    public void click_send_to_option() {
        new TransferToEquity().clickSendTo();
    }

    @And("^click send to someone new$")
    public void click_send_to_someone_new() {
       new SendToEquityPage().clickSendToSomeone();
    }

    @And("^enter an account as \"([^\"]*)\" and click add button$")
    public void enter_an_account_as_and_click_add_button(String account) {
    new RecipientPage().enterAccountDetails(account);
    new RecipientPage().clickAddButton();
    }

    @And("^enter \"([^\"]*)\" to send$")
    public void enter_to_send(String amount) {
       new TransferToEquity().enterAmount(amount);
    }

    @And("^enter reason as \"([^\"]*)\" and hide keyboard$")
    public void enter_reason_as_and_hide_keyboard(String reason) {
       new TransferToEquity().enterPayReason(reason);
       //hide keyboard
        new BasePage().hideKeyboard();
    }

    @And("^taken to review page and click confirm button$")
    public void taken_to_review_page_and_click_confirm_button() {
       new TransferToEquity().clickSendMoney();
    }

    @And("^enter OTP$")
    public void enter_otp() {
        new PaymentConfirmationPage().clikcConfirmButton();
        new OTP().clickNeedHelp();
        new NeedHelpPage().clickTryAnotherMethod();
        new TransactionVerification().clickGetOtpByEmail();
        new TransactionVerification().clickNextButton();
        new OTP().enterOTP();
    }
    @Then("^transaction error is displayed as \"([^\"]*)\"$")
    public void transactionErrorIsDisplayedAsSomething(String errordescription)  {
        Assert.assertEquals(new TransferToEquity().getErrorDescription(),errordescription);
    }
    @Then("^toast account error is displayed as \"([^\"]*)\"$")
    public void toastAccountErrorIsDisplayedAsSomething(String errordescription) throws Throwable {
        Assert.assertEquals(new TransferToEquity().getToastErrorMessage(),errordescription );
    }
    @Then("^transaction success is displayed as \"([^\"]*)\"$")
    public void transaction_success_is_displayed_as(String successDescription) {
        Assert.assertEquals(new TransactionSuccessPage().getConfirmationSuccess(),successDescription);
    }
}
