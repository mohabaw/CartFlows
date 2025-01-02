package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import listeners.CucumberTestListener;
import listeners.TestNGListeners;
import org.testng.IInvokedMethodListener;
import org.testng.IInvokedMethod;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.*;
import io.cucumber.testng.CucumberOptions;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import utilities.ConfigReader;

import java.util.Collections;

@Listeners({TestNGListeners.class})
@CucumberOptions(
        features = "src/test/resources/features", //Path of the feature files
        glue = {"stepdefinitions", "base"}, // Path of Java classes Package that contain the step definitions
        //glue = {"stepdefinitions"} since the stepdefinitions.java is in the same place than TestRunner.java
        tags = "@GoogleSearch or @SmokeScenario", // Tags qu'on retrouve sur les scénario dans les fichiers .feature
        plugin = {"pretty", "html:target/reports/execution_report.html"} //Definition of a report file
)
public class TestRunner extends AbstractTestNGCucumberTests {
    // @DataProvider: permet d'exécuter les scénarios ou les fichiers .feature en parallèle.
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.setTestClasses(new Class[]{TestNGListeners.class}); // Set the test class to CucumberTestRunner
        TestListenerAdapter tla = new TestListenerAdapter();
        testNG.addListener(tla);
        testNG.run();
    }
}