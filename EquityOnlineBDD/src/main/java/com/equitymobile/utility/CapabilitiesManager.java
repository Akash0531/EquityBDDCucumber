package com.equitymobile.utility;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/*
To Do:  modidfu the hard-coding of the app name to fetch from config properties
 */
public class CapabilitiesManager {
    TestUtililtiy testUtililtiy = new TestUtililtiy();


    public DesiredCapabilities desiredCapabilities() throws IOException {
        GlobalParameters globalParameters = new GlobalParameters();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        Properties propertyManager = new PropertyManager().getProperty();

        try {
            testUtililtiy.log().info("Setting the app capabilities");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,globalParameters.getPlatFormName());
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,globalParameters.getdeviceName());
            desiredCapabilities.setCapability(MobileCapabilityType.UDID,globalParameters.getUDID());
            desiredCapabilities.setCapability("noReset","true");
            //desiredCapabilities.setCapability("fullReset","false");


            //swith the other params based on the platform name of the app
            switch(globalParameters.getPlatFormName()){
                case "Android":
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, propertyManager.getProperty("androidAutomationName"));
                    desiredCapabilities.setCapability("appPackage", propertyManager.getProperty("androidAppPackage"));
                   desiredCapabilities.setCapability("appActivity", propertyManager.getProperty("androidAppActivity"));
                    //desiredCapabilities.setCapability("systemPort", globalParameters.getsystemPort());
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
                    //desiredCapabilities.setCapability("chromeDriverPort", globalParameters.getchromeDriverPort());
                    //String androidAppUrl = getClass().getResource(props.getProperty("androidAppLocation")).getFile();
                    //set the path from outside the file
                    String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "apps" + File.separator + propertyManager.getProperty("androidAppLocation");
                    testUtililtiy.log().info("appUrl is" + androidAppUrl);
                    //desiredCapabilities.setCapability("app", androidAppUrl);
                    break;
                case "iOS":
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, propertyManager.getProperty("XCUITest"));
                    //String iOSAppUrl = getClass().getResource(props.getProperty("iOSAppLocation")).getFile();
                    //modify the add-coding of the app
                    String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "apps" + File.separator + "SwagLabsMobileApp.app";
                    testUtililtiy.log().info("appUrl is" + iOSAppUrl);
                    desiredCapabilities.setCapability("bundleId", propertyManager.getProperty("iOSBundleId"));
                    desiredCapabilities.setCapability("wdaLocalPort", globalParameters.getwdaLocalPort());
                    desiredCapabilities.setCapability("webkitDebugProxyPort", globalParameters.getwebDebugWebKitDriverPort());
                    desiredCapabilities.setCapability("app", iOSAppUrl);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            testUtililtiy.log().fatal("Unable to set desired capabilities"+e.toString());
        }
        return desiredCapabilities;
    }
}
