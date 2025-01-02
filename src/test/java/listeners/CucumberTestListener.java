package listeners;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberTestListener {
    // Static variable to hold the current scenario name

    public static ThreadLocal<String> currentScenarioName = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario) {
        // Store the scenario name before each scenario starts
        currentScenarioName.set(scenario.getName());
    }

    @After
    public void afterScenario() {
        // Reset the scenario name after each scenario ends
        currentScenarioName.remove();
    }
}
