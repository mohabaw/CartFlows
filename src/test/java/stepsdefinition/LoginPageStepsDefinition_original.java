/*package stepsdefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pagefactory.LoginPage;
import pagefactory.ProductsPage;
import utilities.DriverFactory;


public class LoginPageStepsDefinition_original {

    private static final Logger logger = LogManager.getLogger(LoginPageStepsDefinition_original.class);

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public LoginPageStepsDefinition_original() {
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
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        logger.info("Setting Up the driver: {}", driver);
        // logger.debug("Setting Up the driver: {}", driver);
        // logger.error("Setting Up the driver: {}", driver);
        // logger.warn("Setting Up the driver: {}", driver);
        // logger.trace("Setting Up the driver: {}", driver);
    }

    @When("user is on login page")
    public void UserIsInLoginPage() {
        if (driver == null) {
            throw new RuntimeException("WebDriver is not initialized! Ensure @Before is setting up WebDriver (custom exception message");
        }
        loginPage.navigateToLoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPage());
    }

    @And("user enters a {string} and a {string}")
    public void UserEntersUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("clicks on login button")
    public void ClicksInLoginButton() {
        loginPage.clickOnLogin();
    }

    @Then("user is navigated to the home page")
    public void UserIsInProductsPage() {
        String pageTitle = productsPage.getPageTitle();
        Assert.assertEquals(pageTitle, "Swag Labs");
        productsPage.getPageTitle();
    }
}

 */

