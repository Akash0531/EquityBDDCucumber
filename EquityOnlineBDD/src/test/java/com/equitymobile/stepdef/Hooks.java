package com.equitymobile.stepdef;

import com.equitymobile.pages.BasePage;
import com.equitymobile.utility.DriverManager;
import com.equitymobile.utility.GlobalParameters;
import com.equitymobile.utility.ServerManager;

import com.equitymobile.utility.VideoManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Hooks {

    @Before
    public void initialize() throws Exception {
       DriverManager driverManager = new DriverManager();
//    //initialize the global params
       GlobalParameters globalParameters = new GlobalParameters();
       globalParameters.initializeSystemProperties();
//
//        //create logs
//        ThreadContext.put("ROUTINEKEY",globalParameters.getPlatFormName()+"_"+globalParameters.getdeviceName());
//        //start the server
          ServerManager appiumServerManager = new ServerManager();
         appiumServerManager.startAppiumServer();
         driverManager.getDriverInitialize();
      // new VideoManager().startRecording();


    }
    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        File screenshot = ((TakesScreenshot) new DriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
        if(scenario.isFailed()) {
            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
            scenario.attach(fileContent, "image/png", "screenshot");
        }
    }

        @After
    public void tearDown(Scenario scenario) throws IOException {
        DriverManager driverManager = new DriverManager();
//        if(scenario.isFailed()){
//            //attach a screenshot
//            byte [] screenshot = driverManager.getDriver().getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot,"image/png",scenario.getName());
//        }
//        new VideoManager().stopRecording(scenario.getName());
         ServerManager appiumServerManager = new ServerManager();
         if(driverManager.getDriver() !=null){
              driverManager.getDriver().quit();
              driverManager.setAppiumDriverThreadLocal(null);
         }
         if (appiumServerManager !=null){ appiumServerManager.getServer().stop();}
    }
        @AfterAll
        public void appResetState() {
        	new DriverManager().getDriver().resetApp();
        }
}
