package com.equitymobile.pages.login;

import com.equitymobile.pages.BasePage;
import com.equitymobile.pages.home.HomePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SubsequentLoginPage extends BasePage {
    //find the locators on the page
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/secondaryButton")
    MobileElement proceed;


    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your password']")
    MobileElement passwordField;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/loginActionHolder")
    MobileElement loginButton;

    public SubsequentLoginPage() {

    }
    public SubsequentLoginPage clickProceed(){
        clickElement(proceed);
        return new SubsequentLoginPage();
    }
    public SubsequentLoginPage enterPassword(String passwordEntered){

        sendKeys(passwordField,passwordEntered);
        return this;
    }
    //click on login Button error message

    public HomePage clickLoginButton(){
        clickElement(loginButton);
        return new HomePage();
    }
    //click using valid credentials
    //public HomePage
    public HomePage clickLogin(String passwordFieldP){
        sendKeys(passwordField,passwordFieldP);
        return clickLoginButton();
    }


}
