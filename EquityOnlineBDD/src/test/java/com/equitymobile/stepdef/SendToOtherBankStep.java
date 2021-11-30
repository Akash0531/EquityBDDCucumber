package com.equitymobile.stepdef;

import com.equitymobile.pages.BasePage;
import com.equitymobile.pages.home.HomePage;
import com.equitymobile.pages.login.SubsequentLoginPage;
import com.equitymobile.pages.otp.NeedHelpPage;
import com.equitymobile.pages.otp.OTP;
import com.equitymobile.pages.otp.TransactionVerification;
import com.equitymobile.pages.transfer.TransferPage;
import com.equitymobile.pages.TRANSACTIONDETAILPAGE.TransactionDetailsPage;
import com.equitymobile.pages.transfer.anotherbank.OtherBankDetailsPage;
import com.equitymobile.pages.transfer.anotherbank.SearchAccountPage;
import com.equitymobile.pages.transfer.anotherbank.SelectAccountOptionPage;
import com.equitymobile.pages.transfer.toEquity.PaymentConfirmationPage;
import com.equitymobile.pages.transfer.toEquity.TransactionSuccessPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SendToOtherBankStep {

    @Given("^on login page click let me in button:another bank$")
    public void on_login_page_click_let_me_in_button_another_bank() {
        // Write code here that turns the phrase above into concrete actions
        //login
        new SubsequentLoginPage().clickProceed();//clear for mobile device
        new SubsequentLoginPage().clickLogin("@Port5050");//Read from excell
    }

    @When("^click transfer icon:oanother bank$")
    public void click_transfer_icon_oanother_bank() {
       new HomePage().clickOnTransferLanding();
    }

    @When("^click other bank option$")
    public void click_other_bank_option() {
      new TransferPage().clickAnotherBankOption();
    }

    @When("^click send to option:another bank$")
    public void click_send_to_option_another_bank() {
        new TransactionDetailsPage().clickSendToOption();
    }

    @When("^click send to bank account number$")
    public void click_send_to_bank_account_number() {
        new SelectAccountOptionPage().clickToSearchOtherBankAccount();
    }

    @When("^enter another bank name as \"([^\"]*)\" and search$")
    public void enter_another_bank_name_as_and_search(String bankName) {
        new SearchAccountPage().searchAccountPage(bankName);
    }

    @When("^select the searched bank from the list$")
    public void select_the_searched_bank_from_the_list() {
        new SearchAccountPage().selectSearchedBank();
    }

    @When("^enter customer name as \"([^\"]*)\":another bank$")
    public void enter_customer_name_as_another_bank(String customerName) {
        new OtherBankDetailsPage().enterCustomerName(customerName);
    }

    @When("^enter customer account as \"([^\"]*)\" and hide keyboard:another bank$")
    public void enter_customer_account_as_and_hide_keyboard_another_bank(String bankAccount) {
        new OtherBankDetailsPage().enterBankCustomerAcc(bankAccount);
        new BasePage().hideKeyboard();
    }

    @When("^click continue button:another bank$")
    public void click_continue_button_another_bank() {
        new OtherBankDetailsPage().clickAddBeneficiaryButton();
    }

    @When("^enter transaction amount as \"([^\"]*)\":another bank$")
    public void enter_transaction_amount_as_another_bank(String amount) {
        new TransactionDetailsPage().enterAmount(amount);
    }

    @When("^enter transaction reason as \"([^\"]*)\":another bank$")
    public void enter_transaction_reason_as_another_bank(String transactReason) {
        new TransactionDetailsPage().enterPaymentReason(transactReason);
    }

    @When("^click continue from the transaction review page$")
    public void click_continue_from_the_transaction_review_page() {
        new TransactionDetailsPage().clickSendButton();
    }

    @When("^enter OTP:another bank$")
    public void enter_otp_another_bank() {
        new PaymentConfirmationPage().clikcConfirmButton();
        new OTP().clickNeedHelp();
        new NeedHelpPage().clickTryAnotherMethod();
        new TransactionVerification().clickGetOtpByEmail();
        new TransactionVerification().clickNextButton();
        new OTP().enterOTP();
    }

    @Then("^transaction error is displayed as \"([^\"]*)\":another bank$")
    public void transactionErrorIsDisplayedAsSomethinganotherBank(String transerror)  {
      Assert.assertEquals(new TransactionDetailsPage().getErrorMessage(),transerror);
    }
    @Then("^transaction success is displayed as \"([^\"]*)\":another bank$")
    public void transaction_success_is_displayed_as_another_bank(String transactionSuccess) {
        Assert.assertEquals(new TransactionSuccessPage().getConfirmationSuccess(),transactionSuccess);
    }
}
