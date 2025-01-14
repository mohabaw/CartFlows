package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.DriverFactory;


// Reads from TestNGSuite.xml file
//mvn clean test -Dtest=TestRunnerForTestNGSuite

//@Listeners({TestNGListeners.class})
@CucumberOptions(
        features = "src/test/resources/features", //Path of the feature files
        glue = {"stepsdefinition", "hooks","base"}, // Path of Java classes Package that contain the step definitions
        //glue = {"stepsdefinition"} since the stepsdefinition.java is in the same place than TestRunner1.java
        tags = "@ReadFromTestNGSuite", // Tags in the .feature files
        plugin = {"pretty", "html:target/reports/execution_report_TestRunnerForTestNGSuite.html"} //Definition of a report file
)


public class TestRunnerForTestNGSuite extends AbstractTestNGCucumberTests {
    // @DataProvider: allows to execute scenarios or .feature files in parallel
    /*@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }*/

   // Retrieving parameters from testNGSuites.xml (if run from testNGSuite.xml)
  /*  @BeforeClass(alwaysRun = true)
    @Parameters("Browser")
    public void setup(String browser) {
        System.setProperty("Browser", browser); // Met le paramètre dans les propriétés système
    }*/



   @BeforeClass(alwaysRun = true)
   @Parameters("Browser")
   public void setup(String browser) {
       System.setProperty("Browser", browser); // Store browser in system properties
       System.out.println("BROWSER FROM RUNNER IS: " + browser);
       DriverFactory driverFactory = new DriverFactory(browser); // Pass it directly to the factory
       driverFactory.initializeDriver(browser);
       WebDriver driver = DriverFactory.getDriver();
       driver.manage().window().maximize();
   }

    // To be used with listeners instead of the testNG .xml file
   /* public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.setTestClasses(new Class[]{TestNGListeners.class}); // Set the test class to CucumberTestRunner
        TestListenerAdapter tla = new TestListenerAdapter();
        testNG.addListener(tla);
        testNG.run();
    }*/
}