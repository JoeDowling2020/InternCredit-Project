package utilities;
import java.io.*;
import java.util.*;

/**
 * The interface Properties loader.
 */
public interface PropertiesLoader {

    /**
     * Load properties properties.
     *
     * @return the properties
     */
    default Properties loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/database.properties"));
        } catch (IOException ioe) {
            System.out.println("Database.loadProperties()...Cannot load the properties file");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Database.loadProperties()..." + e);
            e.printStackTrace();
        }
        return properties;
    }
}