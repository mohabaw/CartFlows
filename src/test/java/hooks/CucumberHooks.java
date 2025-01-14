package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

import java.io.File;
import java.io.IOException;


public class CucumberHooks {
    private WebDriver driver;

    public CucumberHooks() {
        this.driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
        System.out.println("-------------------------- Quitting the driver ---------------------");
    }

    /**
     * Taking screen shots in every step of Gherkin, and cleaning up the folder each new test run
     */

    private static final String SCREENSHOT_FOLDER = "target/screenshots"; // Folder for storing screenshots

  /*  // Clean up the screenshot folder before each test run
    @Before
    public void cleanScreenshotFolder() {
        try {
            FileUtils.cleanDirectory(new File(SCREENSHOT_FOLDER));
            System.out.println("Screenshots folder cleaned.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterStep
    public void takeScreenshotAfterStep(Scenario scenario) {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            String stepName = scenario.getName().replaceAll(" ", "_");

            String exampleData = getExampleData(scenario);
            String fileName = "target/screenshots/" + stepName
                    + (exampleData.isEmpty() ? "" : "_" + exampleData.replaceAll("[\\[\\]]", "").replaceAll(", ", "_")) + ".png";

            try {
                FileUtils.writeByteArrayToFile(new File(fileName), screenshot);
                scenario.attach(screenshot, "image/png", "Screenshot: " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("WebDriver is not initialized, skipping screenshot.");
        }
    }

    private String getExampleData(Scenario scenario) {
        // Extract the example data (if any) from the scenario
        return scenario.getSourceTagNames().stream()
                .filter(tag -> tag.startsWith("@example"))
                .findFirst()
                .orElse("");
    }*/
}

