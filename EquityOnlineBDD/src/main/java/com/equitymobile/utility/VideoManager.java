package com.equitymobile.utility;

import io.appium.java_client.screenrecording.CanRecordScreen;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class VideoManager {

    TestUtililtiy utililtiy = new TestUtililtiy();
    public void startRecording(){
        ((CanRecordScreen) new DriverManager().getDriver()).startRecordingScreen();
    }

    public void stopRecording(String scenarioName) throws IOException {
        GlobalParameters params = new GlobalParameters();
        String media = ((CanRecordScreen) new DriverManager().getDriver()).stopRecordingScreen();
        String dirPath = params.getPlatFormName() + "_"
                + params.getdeviceName() + File.separator +"Videos";

        File videoDir = new File(dirPath);

        synchronized(videoDir){
            if(!videoDir.exists()) {
                videoDir.mkdirs();
            }
        }
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(videoDir + File.separator + scenarioName + ".mp4");
            stream.write(Base64.decodeBase64(media));
            stream.close();
            utililtiy.log().info("video path: " + videoDir + File.separator + scenarioName + ".mp4");
        } catch (Exception e) {
            utililtiy.log().error("error during video capture" + e.toString());
        } finally {
            if(stream != null) {
                stream.close();
            }
        }
    }
}
