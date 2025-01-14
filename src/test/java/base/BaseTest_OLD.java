package base;

import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

import java.net.MalformedURLException;

public class BaseTest_OLD {

    /**
     *  THIS CLASS IS NOT USED FOR THE MOMENT
     */

    protected WebDriver driver;
    private DriverFactory factory;  // Declare factory

    protected String browser;

   //@BeforeMethod: : It depends if I use this method as a Before method or in the steps
   public void setUp(String browser) throws MalformedURLException {
       this.browser = browser;
        factory = new DriverFactory(browser);
        factory.initializeDriver(browser); // Browser comes from suite.xml configs
        driver = factory.getDriver();
        driver.manage().window().maximize();
        System.out.println("!!!!!!!!!!!!!! Setting Up the driver: " + driver +" !!!!!!!!!!!!!!!!!!");
    }

}
