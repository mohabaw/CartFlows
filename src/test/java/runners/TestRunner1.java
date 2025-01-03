package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.*;
import io.cucumber.testng.CucumberOptions;

//@Listeners({TestNGListeners.class})
@CucumberOptions(
        features = "src/test/resources/features", //Path of the feature files
        glue = {"stepdefinitions", "base"}, // Path of Java classes Package that contain the step definitions
        //glue = {"stepdefinitions"} since the stepdefinitions.java is in the same place than TestRunner1.java
        tags = "@GoogleSearch or @SmokeScenario", // Tags qu'on retrouve sur les scénario dans les fichiers .feature
        plugin = {"pretty", "html:target/reports/execution_report.html"} //Definition of a report file
)
public class TestRunner1 extends AbstractTestNGCucumberTests {
    // @DataProvider: permet d'exécuter les scénarios ou les fichiers .feature en parallèle.
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