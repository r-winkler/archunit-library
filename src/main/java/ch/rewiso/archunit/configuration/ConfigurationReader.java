package ch.rewiso.archunit.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {

    public static final String ARCHUNIT_PROPERTIES_FILE = "/archunit.properties";

    public Properties readProperties() {

        System.out.println("####### read proeprties #########");
        var properties = new Properties();

        try (var inputStream = getClass().getResourceAsStream(ARCHUNIT_PROPERTIES_FILE)) {
            if (inputStream != null) {
                properties.load(inputStream);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

}
