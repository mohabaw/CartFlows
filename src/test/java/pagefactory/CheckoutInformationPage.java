package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static constants.Constants.*;

public class CheckoutInformationPage {

    @FindBy(xpath = checkoutInformationBannerTitle)
    WebElement checkout_info_banner_title;

    @FindBy(id = firstNameId)
    WebElement  txt_first_name;

    @FindBy(id = lastNameId)
    WebElement  txt_last_name;

    @FindBy(id = zipCodeId)
    WebElement  txt_zip_code;


    @FindBy(id = continueButtonId)
    WebElement btn_continue;

    WebDriver driver;


    public CheckoutInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void enterFirstName(String firstName) {
        txt_first_name.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        txt_last_name.sendKeys(lastName);
    }

    public void enterZipCode(String zipCode) {
        txt_zip_code.sendKeys(zipCode);
    }

    public void clickOnContinue() {
        btn_continue.click();
    }

    public boolean isCheckoutInformation() {

        return checkout_info_banner_title.isDisplayed();
    }

}
