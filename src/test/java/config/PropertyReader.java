package config;

import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static final String APPLICATION_FILE_PATH = "config/appsettings.properties";
    private static Properties properties;

    private PropertyReader() {
    }

    public static void loadProperties() {
        if (properties == null) {
            properties = new Properties();
            try (InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream(APPLICATION_FILE_PATH)) {
                if (input == null) {
                    throw new RuntimeException("Properties file not found in classpath: " + APPLICATION_FILE_PATH);
                }
                properties.load(input);
            } catch (Exception ex) {
                throw new RuntimeException("Error loading properties file: " + APPLICATION_FILE_PATH, ex);
            }
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            loadProperties();
        }
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found in " + APPLICATION_FILE_PATH);
        }
        return value;
    }
}
