package com.equitymobile.stepdef;

import com.equitymobile.pages.LanguageSelectPage;
import com.equitymobile.pages.LoginFirstTimeUser;
import com.equitymobile.pages.WelcomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WelcomePageStepDef {
WelcomePage welcomePage = new WelcomePage();
LoginFirstTimeUser loginFirstTimeUser;

    @When("I click the continue button")
    public void i_click_the_continue_button() {
       new LanguageSelectPage().clickWelcomePageButton();
    }

    @When("And I click get started button")
    public void and_i_click_get_started_button() {
        loginFirstTimeUser = welcomePage.clickGetStartedButton();
    }

    @Then("I'm taken to the login screen")
    public void i_m_taken_to_the_login_screen() {
        System.out.println("Successfully landed on the Page");
    }
}

