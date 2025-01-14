package stepsdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pagefactory.*;

public class E2EPurchaseStepsDefinition {

// Login
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutInformationPage checkoutInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;

    private SharedStepsDefinition sharedStep;

    private int threadSleepDuration = 2000 ;
    @And("user adds Backpack to cart")
    public void addProduct() throws InterruptedException {
       sharedStep = new SharedStepsDefinition();
       productsPage = new ProductsPage(sharedStep.getDriver());
        Thread.sleep(threadSleepDuration);
        productsPage.addProductToCart();

    }


    @And("user goes to cart")
    public void goToCart() throws InterruptedException {
        productsPage.clickOnCart();
        Thread.sleep(threadSleepDuration);
    }


    @And("user click on Checkout button")
    public void goToCheckout() throws InterruptedException {
        cartPage = new CartPage(sharedStep.getDriver());
        cartPage.clickOnCheckout();
        Thread.sleep(threadSleepDuration);
    }


    @And("user enters first name {string}, last name {string}, and zip code {string}")
    public void fillClientInfo(String firstName, String lastName, String zipCode) throws InterruptedException {
        checkoutInformationPage = new CheckoutInformationPage(sharedStep.getDriver());
        checkoutInformationPage.enterFirstName(firstName);
        checkoutInformationPage.enterLastName(lastName);
        checkoutInformationPage.enterZipCode(zipCode);
        Thread.sleep(threadSleepDuration);
    }


    @And("user clicks on Continue button")
    public void goToOverview() throws InterruptedException {
        checkoutInformationPage.clickOnContinue();
        Thread.sleep(threadSleepDuration);
    }

    @And("user clicks on Finish button")
    public void goToCheckoutComplete() throws InterruptedException {
        checkoutOverviewPage = new CheckoutOverviewPage(sharedStep.getDriver());
        checkoutOverviewPage.clickOnFinish();
        Thread.sleep(threadSleepDuration);
    }

    @Then("the order is successful")
    public void isOrderSuccessful() throws InterruptedException {
        checkoutCompletePage = new CheckoutCompletePage(sharedStep.getDriver());
        Assert.assertTrue(checkoutCompletePage.isOrderOK());
        Thread.sleep(threadSleepDuration);
    }

}
