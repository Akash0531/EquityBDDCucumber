package com.equitymobile.runner;

import com.equitymobile.utility.DriverManager;
import com.equitymobile.utility.GlobalParameters;
import com.equitymobile.utility.ServerManager;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.*;

public class BaseRunnerClass {

    //create thread for the test cucumber

    private static final ThreadLocal<TestNGCucumberRunner> testNGCucumberRunner = new ThreadLocal<>();
    //create setter and getter method for the cucumber thread
    public static TestNGCucumberRunner getTestNGCucumberRunner(){
        return testNGCucumberRunner.get();
    }

    //set thread
    public static void setTestNGCucumberRunner(TestNGCucumberRunner testNGCucumberRunner1){
        testNGCucumberRunner.set(testNGCucumberRunner1);
    }
    @Parameters({"platformName","deviceName","systemPort","chromeDriverPort"})
    @BeforeClass(alwaysRun = true)
    public void setUpClass(String platformName,String deviceName,@Optional("Android") String systemPort
            ,@Optional("Android") String chromeDriverPort){
        //set the global parameters
        GlobalParameters globalParameters = new GlobalParameters();
        globalParameters.setPlatFormName(platformName);
        globalParameters.setDeviceName(deviceName);
        // globalParameters.setUDID(udid);

        ThreadContext.put("ROUTINEKEY",platformName+"_"+deviceName);

        switch (platformName){
            case "Android":
                globalParameters.setsystemPort(systemPort);
                globalParameters.setChromeDriverPort(chromeDriverPort);
                break;
            case "ios":
                break;
        }

        //create logs

        //start the server
//        ServerManager appiumServerManager = new ServerManager();
//        DriverManager driverManager = new DriverManager();
//        appiumServerManager.startAppiumServer();
//        driverManager.getDriverInitialize();
        setTestNGCucumberRunner(new TestNGCucumberRunner(this.getClass()));
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {
        getTestNGCucumberRunner().runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return getTestNGCucumberRunner().provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
//        DriverManager driverManager = new DriverManager();
//        ServerManager appiumServerManager = new ServerManager();
//        if(driverManager.getDriver() !=null){
//            driverManager.getDriver().quit();
//            driverManager.setAppiumDriverThreadLocal(null);
//        }
//        if (appiumServerManager !=null){ appiumServerManager.getServer().stop();}
//        if (getTestNGCucumberRunner() !=null) {
//
//            getTestNGCucumberRunner().finish();
//        }
    }
}
