package utilities;


import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {


    /**
     * Part 1:  Reads properties from the config.properties file. Here it's mainly the headless option for
     */
    private ChromeOptions chromeOptions = new ChromeOptions();
    private FirefoxOptions fireFoxOptions = new FirefoxOptions();
    private EdgeOptions edgeOptions = new EdgeOptions();

    public ChromeOptions getChromeOptions() {
        return chromeOptions;
    }

    public FirefoxOptions getFireFoxOptions() {
        return fireFoxOptions;
    }

    public EdgeOptions getEdgeOptions() {
        return edgeOptions;
    }


    public void isHeadless() {
        Properties properties = new Properties();
        boolean isHeadless = false;
        try (
                InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                properties.load(input);
                isHeadless = Boolean.parseBoolean(properties.getProperty("headless"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isHeadless) {
            chromeOptions.addArguments("--headless");
            fireFoxOptions.addArguments("--headless");
            edgeOptions.addArguments("--headless");
        }

    }

    /**
     * Part 2: Handles the browser parameter management between testNG and Cucumber
     */
    private static String browser;

    public static String getBrowser() {
        return browser;
    }

    public static void setBrowser(String browserValue) {
        browser = browserValue;
    }

}
