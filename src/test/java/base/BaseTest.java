package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import utilities.ConfigReader;
import utilities.DriverFactory;
import org.testng.annotations.Parameters;

public class BaseTest {

    /**
     * Contains the setup and teardown logic (e.g., WebDriver initialization, quitting, test annotations).
     */

    protected WebDriver driver;
    private DriverFactory factory;  // Declare factory

    protected String browser;

   //@BeforeMethod: : It depends if I use this method as a Before method or in the steps
   public void setUp(String browser) {
       this.browser = browser;
        factory = new DriverFactory(browser);
        factory.initializeDriver(browser); // Browser comes from suite.xml configs
        driver = factory.getDriver();
        driver.manage().window().maximize();
        System.out.println("!!!!!!!!!!!!!! Setting Up the driver: " + driver +" !!!!!!!!!!!!!!!!!!");
    }

    @AfterMethod
    public void tearDown() {
        factory.quitDriver();
        System.out.println("-------------------------- Quitting the driver ---------------------");
    }
}
