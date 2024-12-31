package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class StepDefinitions {
    /* ThreadLocal<WebDriver>:
    TestNG: During parallel execution with TestNG, each test thread will use its own WebDriver instance thanks to ThreadLocal.
    Cucumber: If multiple scenarios are executed in parallel, ThreadLocal ensures that a unique WebDriver instance is associated with each scenario. */
    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    WebDriver webDriver;

    // Google Search
    @Given("browser is open")
    public void browserIsOpen() throws InterruptedException {
        driver.set(new ChromeDriver());
        webDriver = driver.get();
       webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
       webDriver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(3000));
        webDriver.manage().window().maximize();
        webDriver.get("https://www.google.com");
        System.out.println("Inside step - browser is open");
    }

    @And("user is on google search page")
    public void userIsOnGoogleSearchPage() {
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
        driver.set(new ChromeDriver());
        webDriver = driver.get();

    }

    @When("user enters username and password")
    public void userEntersUsernameAndPassword() {

    }


    @And("clicks on login button")
    public void clicksOnLoginButton() {

    }


    @Then("user is navigated to the home page")
    public void userIsNavigatedToTheHomePage() {

    }
}

