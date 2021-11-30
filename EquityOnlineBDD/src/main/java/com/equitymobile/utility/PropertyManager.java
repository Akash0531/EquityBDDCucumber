package com.equitymobile.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    TestUtililtiy testUtililtiy = new TestUtililtiy();
    public static Properties manageProperty = new Properties();

    public Properties getProperty() throws IOException {
        InputStream inputStream = null;
        String propertyFileName ="config.properties";
        if (manageProperty.isEmpty()){
            try {
                testUtililtiy.log().info("Loading config properties  file");
                inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);
                manageProperty.load(inputStream);

            }catch (IOException ioException){
                ioException.printStackTrace();
                testUtililtiy.log().fatal("Failed to load config properties"+ioException.toString());
            }finally {
                if (inputStream !=null){ inputStream.close();}
            }
        }
        return manageProperty;
    }

}
