package StepDefinitions;


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
import org.testng.annotations.*;

import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;


public class StepDefinitions {
    /* ThreadLocal<WebDriver>:
        TestNG: During parallel execution with TestNG, each test thread will use its own WebDriver instance thanks to ThreadLocal.
        Cucumber: If multiple scenarios are executed in parallel, ThreadLocal ensures that a unique WebDriver instance is associated with each scenario. */
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Before
    public void setUp() {
        // Start of Headless mode option handling
        Properties properties = new Properties();
        boolean isHeadless = false;

        try (InputStream input = StepDefinitions.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                properties.load(input);
                isHeadless = Boolean.parseBoolean(properties.getProperty("headless"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ChromeOptions options = new ChromeOptions();
        if (isHeadless) {
            options.addArguments("--headless");
        }
        // End of Headless mode option handling

     //   options.addArguments("--no-sandbox", "--disable-dev-shm-usage");

        if (driver.get() == null) {
            WebDriverManager.chromedriver().setup();
            WebDriver driverInstance = new ChromeDriver(options);
            driver.set(driverInstance);
        }

    }

    // Google Search
    @Given("browser is open")
    public void browserIsOpen() throws InterruptedException {
        WebDriver webDriver = driver.get();
        if (webDriver == null) {
            throw new RuntimeException("WebDriver is not initialized! Ensure @BeforeMethod is setting up WebDriver.");
        }
       webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        webDriver.get("https://www.google.com/");
        webDriver.manage().window().maximize();
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

    @After
    public void tearDown() {
        WebDriver webDriver = driver.get();
        if (webDriver != null) {
            webDriver.quit();
            driver.remove();
        }
        System.out.println("WebDriver quit and cleaned up.");
    }

    // Login
    @Given("user is on login page")
    public void user_is_in_login_page() {
      //  driver.set(new ChromeDriver());
        WebDriver webDriver = driver.get();
        webDriver.get("https://www.github.com");

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

