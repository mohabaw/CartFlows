package stepsdefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pagefactory.LoginPage;
import pagefactory.ProductsPage;



public class LoginPageStepsDefinition {

    private LoginPage loginPage;
    private ProductsPage productsPage;
    private SharedStepsDefinition sharedStep;



    @And("user is on login page")
    public void UserIsInLoginPage() {
        sharedStep = new SharedStepsDefinition();
        loginPage = new LoginPage(sharedStep.getDriver());
        Assert.assertTrue(loginPage.isLoginPage());
    }

    @Then("user is navigated to products page")
    public void UserIsInProductsPage() {
        productsPage = new ProductsPage(sharedStep.getDriver());
        String pageTitle = productsPage.getPageTitle();
        Assert.assertEquals(pageTitle, "Swag Labs");
        productsPage.getPageTitle();
    }
}

