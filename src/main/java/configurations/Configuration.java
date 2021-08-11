package configurations;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    public static String BASE_URI;
    public static String ACCESS_TOKEN;
    public static String DB_URL;
    public static String DB_USERNAME;
    public static String DB_PASSWORD;

    static {
        try {
            Properties prop = new Properties();
            InputStream inputStream = Configuration.class.getClassLoader().getResourceAsStream("configuration.properties");
            prop.load(inputStream);
            BASE_URI = System.getProperty("base.uri", prop.getProperty("base.uri"));
            ACCESS_TOKEN = System.getProperty("api.access.token", prop.getProperty("api.access.token"));

            DB_URL = System.getProperty("db.url", prop.getProperty("db.url"));
            DB_USERNAME = System.getProperty("db.username", prop.getProperty("db.username"));
            DB_PASSWORD = System.getProperty("db.password", prop.getProperty("db.password"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
