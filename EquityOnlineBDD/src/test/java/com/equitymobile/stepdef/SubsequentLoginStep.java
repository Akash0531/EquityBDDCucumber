package com.equitymobile.stepdef;

import com.equitymobile.pages.LoginErrorPage;
import com.equitymobile.pages.login.SigninRegisterPage;
import com.equitymobile.pages.login.SubsequentLoginPage;
import com.equitymobile.pages.otp.NeedHelpPage;
import com.equitymobile.pages.otp.OTP;
import com.equitymobile.pages.otp.TransactionVerification;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SubsequentLoginStep {


    @Given("^I click on sign in button$")
    public void iClickOnSignInButton() {
        new SigninRegisterPage().clickSignInButton();
    }

    @When("^I enter  username as \"([^\"]*)\" on username field$")
    public void i_enter_username_as_on_username_field(String username) {
        //new SubsequentLoginPage().enterUsername(username);
    }

    @When("^I enter a password as \"([^\"]*)\" on password field$")
    public void i_enter_a_password_as_on_password_field(String password) {
        new SubsequentLoginPage().enterPassword(password);
    }

    @When("click sign in button")
    public void click_sign_in_button() {
    new SubsequentLoginPage().clickLoginButton();
    }

    @Then("^error message \"([^\"]*)\" is diplayed$")
    public void error_message_is_diplayed(String error) {
        Assert.assertEquals(error,new LoginErrorPage().getErrorDescription());
    }

    @Then("^I'm taken to homepage with title \"([^\"]*)\"$")
    public void i_m_taken_to_homepage_with_title(String homepageTitle) {
        //click on the help page
        new OTP().clickNeedHelp();
        //click try another method
        new NeedHelpPage().clickTryAnotherMethod();

        //choose email
        new TransactionVerification().clickGetOtpByEmail();

        System.out.println("Done for now");
    }


}
