package runners;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

// Runs 2 features in parallel, without using parameters
// mvn clean test -Dtest=TestRunner2

//@Listeners({TestNGListeners.class})
@CucumberOptions(
        features = "src/test/resources/features", //Path of the feature files
        glue = {"stepsdefinition", "hooks","base"}, // Path of Java classes Package that contain the step definitions
        //glue = {"stepsdefinition"} since the stepsdefinition.java is in the same place than TestRunner1.java

       tags = "@E2E or @MultibrowserLogin ", // Tags in the .feature files

        plugin = {"pretty", "html:target/reports/execution_report_testRunner2.html"} //Definition of a report file
)


public class TestRunner2 extends AbstractTestNGCucumberTests {
    // @DataProvider: allows to execute scenarios or .feature files in parallel
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
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