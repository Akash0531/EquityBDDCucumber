package com.equitymobile.utility;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import java.io.File;

public class GlobalParameters {
    private static ThreadLocal<String> platFormName =new ThreadLocal<String>();
    private static ThreadLocal<String> UDID =new ThreadLocal<String>();
    private static ThreadLocal<String> deviceName =new ThreadLocal<String>();
    private static ThreadLocal<String> systemPort =new ThreadLocal<String>();
    private static ThreadLocal<String> chromeDriverPort =new ThreadLocal<String>();
    private static ThreadLocal<String> wdaLocalPort =new ThreadLocal<String>();
    private static ThreadLocal<String> webDebugWebKitDriverPort =new ThreadLocal<String>();

//getter and setter methods
    public void setPlatFormName(String platFormName1){
        platFormName.set(platFormName1);
    }

    public String getPlatFormName(){
        return platFormName.get();
    }
    public void setUDID(String UUID1){
        UDID.set(UUID1);
    }

    public String getUDID(){
        return UDID.get();
    }
    public void setDeviceName(String deviceName1){
        deviceName.set(deviceName1);
    }

    public String getdeviceName(){
        return deviceName.get();
    }
    public void setsystemPort(String systemPort1){
        systemPort.set(systemPort1);
    }

    public String getsystemPort(){
        return systemPort.get();
    }
    public void setChromeDriverPort(String chromeDriverPort1){
        chromeDriverPort.set(chromeDriverPort1);
    }

    public String getchromeDriverPort(){
        return chromeDriverPort.get();
    }
    public void setWdaLocalPort(String wdaLocalPort1){
        wdaLocalPort.set(wdaLocalPort1);
    }

    public String getwdaLocalPort(){
        return wdaLocalPort.get();
    }
    public void setWebDebugWebKitDriverPort(String webDebugWebKitDriverPort1){
        webDebugWebKitDriverPort.set(webDebugWebKitDriverPort1);
    }

    public String getwebDebugWebKitDriverPort(){
        return webDebugWebKitDriverPort.get();
    }
    //initialize default properties
    public void initializeSystemProperties(){

        GlobalParameters globalParameters = new GlobalParameters();
        globalParameters.setPlatFormName(System.getProperty("platFormName","Android"));
        globalParameters.setDeviceName(System.getProperty("deviceName","Pixel_4_API_29"));
        globalParameters.setUDID(System.getProperty("UDID","emulator-5554"));
        //switch for either android or ios
        switch (globalParameters.getPlatFormName()){
            case "Android":
                globalParameters.setChromeDriverPort(System.getProperty("chromeDriverPort","10000"));
                globalParameters.setsystemPort(System.getProperty("systemPort","12000"));
                break;
            case "ios":
                globalParameters.setWebDebugWebKitDriverPort(System.getProperty("webDebugWebKitDriverPort","11000"));
                globalParameters.setWebDebugWebKitDriverPort(System.getProperty("wdaLocalPort","13000"));

                break;
            default:
                throw new IllegalStateException("Invalid Platform Name");
        }

    }

}


