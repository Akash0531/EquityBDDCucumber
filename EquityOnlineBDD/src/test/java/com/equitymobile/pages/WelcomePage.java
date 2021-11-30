package com.equitymobile.pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WelcomePage extends BasePage{

    @FindBy(id = "ke.co.equitygroup.equitymobile.debug:id/toolbarTitle")
    MobileElement welcomePageTitle;

    @FindBy(id = "ke.co.equitygroup.equitymobile.debug:id/getStartedButton")
    List<MobileElement> getStartedButtons;

    //get the title of welcome page
    public String getWelcomePageTitle(){
        return  getTextValue(welcomePageTitle);
    }
    //get the button elements
    public void clickNextButton(){
        for (int i=0;i < getStartedButtons.size();i++){
            clickElement(getStartedButtons.get(i));
            if (getAttributeName(getStartedButtons.get(i),"text")=="Get started"){
                clickElement(getStartedButtons.get(i));
                break;
            }
        }
    }
    //click on get started button
    public LoginFirstTimeUser clickGetStartedButton(){
        clickNextButton();
        return new LoginFirstTimeUser();
    }


}
