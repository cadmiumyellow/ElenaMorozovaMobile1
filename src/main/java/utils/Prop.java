package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Prop {
    public String getPropertyValue(String propertyName) {
        final String pathToProperties = "src/test/resources/testData.properties";
        String propertyValue = "";
        Properties properties = new Properties();

        try (InputStream inputStream = new FileInputStream(pathToProperties)) {
            properties.load(inputStream);
            propertyValue = properties.getProperty(propertyName);
        } catch (IOException e) {

        }
        return propertyValue;
    }
}
