package stepsdefinition;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pagefactory.LoginPage;
import utilities.DriverFactory;

public class SharedStepsDefinition {



    private LoginPage loginPage;
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(SharedStepsDefinition.class);

    public WebDriver getDriver() {
        return driver;
    }

    public SharedStepsDefinition() {
        this.driver = DriverFactory.getDriver(); // Access ThreadLocal WebDriver
    }


    // Cucumber @Before hook to initialize the driver before each scenario
    //@Before : It depends if I use this method as a Before method or in the steps
    @Given("{string} is used")
    public void initialize(String localBrowser) {

        String browser = System.getProperty("Browser", localBrowser); // In cas we run from Jenkins or from
        // command line, the selected browser will be used. Else, it's the browser set in feature file (localBrowser)
        // will be used. Use with ForTestNGSuite.feature for example, cmd line
        // mvn clean test -Dtest=TestRunnerForTestNGSuite -DBrowser=Edge
        System.out.println("THE USED BROWSER IS : " + browser);
        DriverFactory factory = new DriverFactory(browser);
        factory.initializeDriver(browser);
        driver = factory.getDriver();
        driver.manage().window().maximize();


        logger.info("Setting Up the driver: {}", driver);
        // logger.debug("Setting Up the driver: {}", driver);
        // logger.error("Setting Up the driver: {}", driver);
        // logger.warn("Setting Up the driver: {}", driver);
        // logger.trace("Setting Up the driver: {}", driver);
    }


    @Given("parameterized browser is used")
    public void parameterizedBrowser (){
        String browser = System.getProperty("Browser");
        System.out.println("THE USED BROWSER IS : " + browser);
        DriverFactory factory = new DriverFactory(browser);
        factory.initializeDriver(browser);
        driver = factory.getDriver();
        driver.manage().window().maximize();
    }

    @And("user navigates to SAUCE_DEMO website")
    public void UserNavigatesToWebsite (){
        this.driver = DriverFactory.getDriver();
        if (driver == null) {
            throw new RuntimeException("WebDriver is not initialized! Ensure @Before is setting up WebDriver (custom exception message");
        }
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage(driver);
    }

    @And("user enters {string} and {string}")
    public void UserEntersUsernameAndPassword(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("user clicks on login button")
    public void ClicksInLoginButton() {
        loginPage.clickOnLogin();
    }
}
