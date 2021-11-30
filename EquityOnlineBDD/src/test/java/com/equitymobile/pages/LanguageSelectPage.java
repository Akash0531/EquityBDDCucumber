package com.equitymobile.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.FindBy;

public class LanguageSelectPage extends BasePage{
    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/scrollView")
    MobileElement scrollView;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/sw")
    MobileElement languageSelectEN;

    @AndroidFindBy(id = "ke.co.equitygroup.equitymobile.debug:id/nextActionButton")
    MobileElement continueWelcomeButton;
    public LanguageSelectPage(){}
    //scroll into view
    public LanguageSelectPage scrollToView(){
       // scrollIntoView(scrollView);
        return this;
    }
    //select the language
    public LanguageSelectPage selectLanguage(){
        clickElement(languageSelectEN);
        return this;
    }

    //click button continue

    public WelcomePage clickWelcomePageButton(){
        clickElement(continueWelcomeButton);
        return new WelcomePage();
    }
}
