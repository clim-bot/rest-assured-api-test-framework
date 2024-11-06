package chris.lim.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class to load configuration properties based on the environment.
 */
public class ConfigLoader {
    private static Properties properties = new Properties();

    static {
        String environment = System.getProperty("env", "dev"); // Default to "dev" if not set
        String configFileName = "config-" + environment + ".properties";
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(configFileName)) {
            if (input == null) {
                throw new RuntimeException("Configuration file not found: " + configFileName);
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load configuration file: " + configFileName, ex);
        }
    }

    /**
     * Gets a property value by key.
     *
     * @param key the property key
     * @return the property value
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
