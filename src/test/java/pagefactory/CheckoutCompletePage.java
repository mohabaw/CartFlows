package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static constants.Constants.*;


public class CheckoutCompletePage {

    @FindBy(xpath = thanksMessage)
    WebElement thanks_message;

    WebDriver driver;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isOrderOK() {

        return thanks_message.isDisplayed();
    }

}
