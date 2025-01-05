package stepdefinitions;


import base.BaseTest_OLD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.DriverFactory;

import java.time.Duration;


public class StepDefinitions extends BaseTest_OLD {

    private WebDriver driver;


    public StepDefinitions() {
        this.driver = DriverFactory.getDriver(); // Access ThreadLocal WebDriver
    }

    // Cucumber @Before hook to initialize the driver before each scenario



    // Cucumber @After hook to clean up the driver after each scenario


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


    @When("user enters username and password")
    public void userEntersUsernameAndPassword() {

    }








}

