package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.Constants.*;


public class ProductsPage {

    @FindBy(id = productsPageCartButtonId)
    WebElement btn_cart;


    @FindBy(xpath = productsPageCartButtonBadge)
    WebElement btn_cart_badge;

    @FindBy(xpath = backBagAddToCart)
    WebElement btn_backBag_add_cart;

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addProductToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Attendre que l'élément soit visible
        WebElement btn_backBag_add_cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(backBagAddToCart)));
        btn_backBag_add_cart.click();
    }


    public void clickOnCart() {
        btn_cart.click();
    }

    public boolean isProductsPage() {

        return productsPageTitle == getPageTitle();
    }

    public boolean isCartBadge() {

        return btn_cart_badge.isDisplayed();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }







}
