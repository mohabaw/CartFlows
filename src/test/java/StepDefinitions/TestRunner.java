package StepDefinitions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/Features", //Path of the feature files
        glue = {"StepDefinitions"}, // Path of Java classes Package that contain the step definitions
        //glue = {"StepDefinitions"} since the StepDefinitions.java is in the same place than TestRunner.java
        //tags = "@GoogleSearch and @SmokeScenario", // Tags qu'on retrouve sur les scénario dans les fichiers .feature
        plugin = {"pretty", "html:target/reports/execution_report.html"} //Definition of a report file
)
public class TestRunner extends AbstractTestNGCucumberTests {
// @DataProvider: permet d'exécuter les scénarios ou les fichiers .feature en parallèle.
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
