package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream input = new FileInputStream("src/test/resources/application.properties");
            properties.load(input);
            input.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
