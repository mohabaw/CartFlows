package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

public class TestNGListeners implements ITestListener {

    //Implements TestNG listeners (e.g., ITestListener) for logging, test reporting, retries, etc.
    // Here I use getTestName because in the casual use of the i^mplemented method, I faced
    // a problem with le logs: I have for example "Test Passed: runScenario" in success, so
    // the test name is not explicit
    @Override
    public void onTestStart(ITestResult result) {
        // Access the scenario name stored in ThreadLocal from CucumberTestListener
        String scenarioName = CucumberTestListener.currentScenarioName.get();
        System.out.println("Test started: " + (scenarioName != null ? scenarioName : result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String scenarioName = CucumberTestListener.currentScenarioName.get();
        System.out.println("Test passed: " + (scenarioName != null ? scenarioName : result.getMethod().getMethodName()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String scenarioName = CucumberTestListener.currentScenarioName.get();
        System.out.println("Test failed: " + (scenarioName != null ? scenarioName : result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String scenarioName = CucumberTestListener.currentScenarioName.get();
        System.out.println("Test skipped: " + (scenarioName != null ? scenarioName : result.getMethod().getMethodName()));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        String scenarioName = CucumberTestListener.currentScenarioName.get();
        System.out.println("Test failed but within success percentage: " + (scenarioName != null ? scenarioName : result.getMethod().getMethodName()));
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test suite finished: " + context.getName());
    }
}


