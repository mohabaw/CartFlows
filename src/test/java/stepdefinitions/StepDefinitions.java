package stepdefinitions;


import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utilities.ConfigReader;
import utilities.DriverFactory;

import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;


public class StepDefinitions extends BaseTest {

    private WebDriver driver;


    public StepDefinitions() {
        this.driver = DriverFactory.getDriver(); // Access ThreadLocal WebDriver
    }

    // Cucumber @Before hook to initialize the driver before each scenario

    //@Before : It depends if I use this method as a Before method or in the steps
    @Given("{string} is used")
    public void initialize(String browser) {
        // Call setUp() from BaseTest to initialize the WebDriver
        super.setUp(browser);  // This will initialize the WebDriver (chrome, etc.)
        this.driver = super.driver;  // Access the WebDriver from BaseTest
    }

    // Cucumber @After hook to clean up the driver after each scenario
    @After
    public void cleanup() {
        // Call tearDown() from BaseTest to quit the driver
        super.tearDown();  // This will quit the WebDriver
    }

    // Google Search
    @Given("browser is open")
    public void browserIsOpen() throws InterruptedException {

        if (driver == null) {
            throw new RuntimeException("WebDriver is not initialized! Ensure @Before is setting up WebDriver (custom exception message");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        driver.get("https://www.google.com/");
        System.out.println("Inside step - browser is open");
    }

    @And("user is on google search page")
    public void userIsOnGoogleSearchPage() throws InterruptedException {
        System.out.println("Inside step - User is on google search page");
    }

    @When("user enters a text in search box")
    public void userEntersATextInSearchBox() {
        System.out.println("Inside step - user enters a text in search box");
    }

    @And("hits enter")
    public void hitsEnter() {
        System.out.println("Inside step - user hits enter");
    }

    @Then("user is navigated to search results")
    public void userIsNavigatedToSearchResults() {
        System.out.println("Inside step - user is navigated to search results");
    }



    // Login
    @Given("user is on login page")
    public void user_is_in_login_page() {
      //  driver.set(new ChromeDriver());
        driver.get("https://www.github.com");

    }

    @When("user enters username and password")
    public void userEntersUsernameAndPassword() {

    }

    @When("user enters a {string} and a {string}")
    public void userEntersAUsernameAndAPassword(String username, String password) {
        System.out.println("Username is: " + username + "and password is: " + password );
    }
    @And("clicks on login button")
    public void clicksOnLoginButton() {

    }


    @Then("user is navigated to the home page")
    public void userIsNavigatedToTheHomePage() {

    }
}

