    package com.equitymobile.utility;

    import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

    public class ServerManager {
    private static ThreadLocal<AppiumDriverLocalService> appiumServer = new ThreadLocal<>();
    TestUtililtiy utilityObject = new TestUtililtiy();

        //get the current instance of the thread of the server
        public AppiumDriverLocalService getServer(){
            return appiumServer.get();
        }

        public void startAppiumServer(){
            utilityObject.log().info("Starting appium server");
          AppiumDriverLocalService  appiumServer = macStartAppium();
          appiumServer.start();
          if (appiumServer==null|!appiumServer.isRunning()){
              utilityObject.log().fatal("Appium server is not started:*******Abort******");
              throw new AppiumServerHasNotBeenStartedLocallyException("Appium server is not started:*******Abort******");
          }
          //appiumServer.clearOutPutStreams();//clear the console logs
            this.appiumServer.set(appiumServer);//set the thread server to the local server instance
            utilityObject.log().info("Appium server started");
        }
        //why this line of code
        public AppiumDriverLocalService getDefaultDriverLocalService(){
            return AppiumDriverLocalService.buildDefaultService();
        }
            //start appium on windows
        public AppiumDriverLocalService WindowsGetAppiumService() {
            GlobalParameters params = new GlobalParameters();
            return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                    .usingAnyFreePort()
                    .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                    .withLogFile(new File(params.getPlatFormName() + "_"
                            + params.getdeviceName() + File.separator + "Server.log")));
        }
        //start appium on mac

        public AppiumDriverLocalService macStartAppium(){
            GlobalParameters globalParameters = new GlobalParameters();

            return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                    .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                    .withAppiumJS(new File("C:\\Users\\Akash\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
                    .withIPAddress("0.0.0.0").usingPort(4723).
                            withLogFile(new File(globalParameters.getPlatFormName() + "_"
                                    + globalParameters.getdeviceName() + File.separator + "Server.log")));
        }
    }
