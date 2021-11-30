package com.equitymobile.runner;

import com.equitymobile.utility.DriverManager;
import com.equitymobile.utility.GlobalParameters;
import com.equitymobile.utility.ServerManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.ThreadContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(   plugin = {"pretty"
        , "html:target/cucumber-html-reports"
        , "summary","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
            }
        ,snippets = CAMELCASE
        //,dryRun=true
        ,monochrome=true
        ,features = {"src/test/resources"}
        ,glue = {"com.equitymobile.stepdef"}
         ,tags = "@Logs"
)
public class EquityMobileRunnerTest extends BaseRunnerClass {

    @BeforeClass
    public static void initialize() throws Exception {
        DriverManager driverManager = new DriverManager();
        GlobalParameters globalParameters = new GlobalParameters();
        globalParameters.initializeSystemProperties();

        //create logs
        ThreadContext.put("ROUTINEKEY",globalParameters.getPlatFormName()+"_"+globalParameters.getdeviceName());
        //start the server
        ServerManager appiumServerManager = new ServerManager();
        appiumServerManager.startAppiumServer();
        driverManager.getDriverInitialize();
    }
    @AfterClass
    public static void teardown(){
        DriverManager driverManager = new DriverManager();
        ServerManager appiumServerManager = new ServerManager();
        if(driverManager.getDriver() !=null){
            driverManager.getDriver().quit();
            driverManager.setAppiumDriverThreadLocal(null);
        }
        if (appiumServerManager !=null){ appiumServerManager.getServer().stop();}
    }

}
