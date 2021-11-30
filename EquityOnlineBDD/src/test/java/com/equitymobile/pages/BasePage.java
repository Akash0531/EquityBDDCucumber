package com.equitymobile.pages;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import com.equitymobile.utility.DriverManager;
import com.equitymobile.utility.TestUtililtiy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    private static AppiumDriver<?>driver;
    TestUtililtiy utililtiy = new TestUtililtiy();

    public BasePage() {
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
    }

    public void waitForElementVisibility(MobileElement element) {
//   WebDriverWait driverWait = new WebDriverWait(driver,10 );
//    driverWait.until(ExpectedConditions.visibilityOf(element));
     driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    }
//    public void waitForElementVisibility(By e) {
//       WebDriverWait wait = new WebDriverWait(driver, 10);
//      wait.until(ExpectedConditions.visibilityOfElementLocated(e));
//    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }

    //method for clicking
    public void clickElement(MobileElement element) {
        waitForElementVisibility(element);
        element.click();
    }

    //send element keys
    public void sendKeys(MobileElement element,String text) {
        waitForElementVisibility(element);
        element.sendKeys(text);

    }
    //get attributes
    public void hideKeyboard(){
        driver.hideKeyboard();
    }

    public String getAttributeName(MobileElement element,String  attribute) {
        waitForElementVisibility(element);
        return element.getAttribute(attribute);

    }
    public String getTextValue(MobileElement element){
        waitForElementVisibility(element);
       return element.getText();
    }
    //tapp actions
    public void tapElement(MobileElement element) {
        TouchAction touch = new TouchAction(driver);
        waitForElementVisibility(element);
        touch.tap(tapOptions().withElement(element(element))).perform();

    }

    public void longTapElement(MobileElement element) {
        waitForElementVisibility(element);
        TouchAction touch = new TouchAction(driver);
        touch.longPress(longPressOptions().withElement(element(element)).withDuration(ofSeconds(2))).release().perform();

    }

    //check if attribute is displayed
    public boolean checkIfElementisDisplayed(MobileElement element) {
        waitForElementVisibility(element);
        return element.isDisplayed();
    }
    //scroll into view
    public WebElement scrollIntoView(MobileElement element,String id){
        waitForElementVisibility(element);
        String command ="new UiScrollable(new UiSelector()).scrollIntoView(text(\""+id+"\"))";
       return driver.findElement(MobileBy.AndroidUIAutomator(command));
    }
    public static void scrollDown() {
        Dimension dimens = driver.manage().window().getSize();
        int x = (int) (dimens.getWidth() * 0.5);
        int startY = (int) (dimens.getHeight() * 0.5);
        int endY = (int) (dimens.getHeight() * 0.2);
    // lest say if above code calculated correct scroll area as per your device then just add static loop to scroll to no of times you want to scroll
        for (int i=0;i <2;i++) {
            new TouchAction(driver).press(PointOption.point(x, startY)).waitAction().moveTo(PointOption.point(x, endY)).release().perform();
        }
    }
    //search a specific xpath using Parameter
    public MobileElement findOperator(String searchText){
        return (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text='"+searchText+"']"));
    }


}
