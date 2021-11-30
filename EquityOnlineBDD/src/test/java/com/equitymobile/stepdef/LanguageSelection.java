package com.equitymobile.stepdef;

import com.equitymobile.pages.LanguageSelectPage;
import com.equitymobile.pages.WelcomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LanguageSelection {
    //create page object

    @When("I open the app and select language")
    public void i_open_the_app_and_select_language() {
        new LanguageSelectPage().selectLanguage();
    }

    @When("And I click continue button")
    public void and_i_click_continue_button() {
        new LanguageSelectPage().clickWelcomePageButton();
    }

    @Then("^I'm taken to the welcome page with title (.+)$")
    public void i_m_taken_to_the_welcome_page_with_title(String ExpectedTitle) {
       String getTitle = new WelcomePage().getWelcomePageTitle();
       System.out.println("DEBUGGING LINE:"+getTitle + "============="+ExpectedTitle);
       Assert.assertEquals(ExpectedTitle,getTitle);
    }
}
