package com.equitymobile.pages.login;

import com.equitymobile.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SigninRegisterPage extends BasePage {
    //create the locators here
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/loginAction")
    MobileElement signInButton;

    //click on sign in button
    public SubsequentLoginPage clickSignInButton(){
        clickElement(signInButton);
        return new SubsequentLoginPage();
    }

}
