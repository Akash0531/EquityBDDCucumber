package com.equitymobile.utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;

import java.io.IOException;

public class DriverManager {

public static ThreadLocal<AppiumDriver> appiumDriverThreadLocal = new ThreadLocal<>();

//get driver
    public AppiumDriver getDriver(){

       return appiumDriverThreadLocal.get();
    }
    
    //set the driver
    public void setAppiumDriverThreadLocal(AppiumDriver appiumDriverThreadLocal1){
        appiumDriverThreadLocal.set(appiumDriverThreadLocal1);
    }
    //create a driver initializing method


    public void getDriverInitialize() throws Exception {
        TestUtililtiy utililtiy = new TestUtililtiy();
        GlobalParameters globalParameters = new GlobalParameters();
        PropertyManager propertyManager = new PropertyManager();
        AppiumDriver appiumDriver = null;
        if (appiumDriver == null){
            try{
                utililtiy.log().info("*********Initializing  driver**********");
                switch (globalParameters.getPlatFormName()){
                    case "Android":
                        appiumDriver = new AndroidDriver( new ServerManager().getServer().getUrl(),new CapabilitiesManager().desiredCapabilities());
                        break;
                    case "Ios":
                        appiumDriver = new IOSDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().desiredCapabilities());
                        break;
                }
                if (appiumDriver==null){
                    throw new Exception("Driver is null:Abort");
                }
                utililtiy.log().info("Driver is initialized");
                this.setAppiumDriverThreadLocal(appiumDriver);//setting the driver in the current thread
            }catch (IOException exception){
                exception.printStackTrace();
                utililtiy.log().info("Driver initialization has failed");
                throw exception;
            }

        }
    }
}
