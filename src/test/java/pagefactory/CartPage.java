package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static constants.Constants.*;

public class CartPage {


    @FindBy(id = checkoutButtonId)
    WebElement btn_checkout;


    @FindBy(xpath = cartBannerTitle)
    WebElement cart_banner_title;


    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickOnCheckout() {
        btn_checkout.click();
    }

    public boolean isCartPage() {

        return cart_banner_title.isDisplayed();
    }




}
