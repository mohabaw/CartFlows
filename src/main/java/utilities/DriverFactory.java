package utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    /** Manages WebDriver initialization and configuration
     */
    /**
     * ThreadLocal<WebDriver>:
     * TestNG: During parallel execution with TestNG, each test thread will use its own WebDriver
     * instance thanks to ThreadLocal.
     * Cucumber: If multiple scenarios are executed in parallel, ThreadLocal ensures
     * that a unique WebDriver instance is associated with each scenario.
     */
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<WebDriver>();
    private String browser;

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public DriverFactory(String browser) {
        this.browser = browser.toLowerCase();
    }

    public void initializeDriver(String browser) {
        //if (driverThreadLocal.get() == null) {   // This line and the following are here to ensure that the driver
           // synchronized (DriverFactory.class) { // is only initialized once per thread to avoid potential conflicts
                                                    // !!!!! BUT: EXECUTION BECOMES NO LONGER PARALLEL !!!!!!!
                // Main code of initializeDriver : beginning
                if (driverThreadLocal.get() == null) {
                    WebDriver driver = createDriver(browser);
                    setDriver(driver);  // Stores driver in ThreadLocal
                    // Main code of initializeDriver : end
                }
           // }
       // }
    }

    public static WebDriver createDriver(String browser) {

        System.out.println("Create driver: " + browser);
        // Start of: Getting the chromeOptions regrading the Headless mode
        ConfigReader configReader = new ConfigReader();
        configReader.isHeadless();
        ChromeOptions chromeOptions = configReader.getChromeOptions();
        FirefoxOptions fireFoxOptions = configReader.getFireFoxOptions();
        EdgeOptions edgeOptions = configReader.getEdgeOptions();
        SafariOptions safariOptions = configReader.getSafariOptions();
        String lowerCaseBrowser = browser.toLowerCase();
        // End of: Getting the chromeOptions regrading the Headless mode
        switch (lowerCaseBrowser) {
            case "chrome":
                //set(): Sets the current thread's copy of this thread-local variable (WebDriver) to the specified value
                // WebDriverManager.chromedriver().setup(): it handles automatically the driver and its version
                WebDriverManager.chromedriver().setup();
                WebDriver chromeDriver = new ChromeDriver(chromeOptions);
                driverThreadLocal.set(chromeDriver);

                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                WebDriver firefoxDriver = new FirefoxDriver(fireFoxOptions);
                driverThreadLocal.set(firefoxDriver);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                WebDriver edgeDriver = new EdgeDriver(edgeOptions);
                driverThreadLocal.set(edgeDriver);
                break;



             // OPERA: to be resolved
            /*case "opera":
                WebDriverManager.operadriver().setup();
                operaOptions.setBinary("path/to/opera");
                WebDriver operaDriver = new ChromeDriver(operaOptions);
                driverThreadLocal.set(operaDriver);
                break;*/
            case "safari":
                WebDriverManager.safaridriver().setup();
                WebDriver safariDriver = new SafariDriver(safariOptions);
                driverThreadLocal.set(safariDriver);
                break;
            default:
                System.out.println("Do not know how to start: " + browser + ", starting chrome.");
                WebDriver chromeDriverDefault = new ChromeDriver(chromeOptions);
                driverThreadLocal.set(chromeDriverDefault);
                break;
        }
        //get(): Returns the value in the current thread's copy of this thread-local variable (WebDriver).

        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        WebDriver webDriver = getDriver();
        if (webDriver != null) {
            try {
                webDriver.quit();
                System.out.println("WebDriver quit and cleaned up.");
            } catch (Exception e) {
                System.out.println("WebDriver was already closed or unavailable.");
            } finally {
                driverThreadLocal.remove();
            }
        }
    }
}
