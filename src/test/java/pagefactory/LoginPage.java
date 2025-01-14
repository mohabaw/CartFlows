package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static constants.Constants.*;

public class LoginPage {

    @FindBy(id = userNameFieldId)
    WebElement txt_username;

    @FindBy(id = passwordFieldId)
    WebElement txt_password;

    @FindBy(id = loginButtonId)
    WebElement btn_login;

    WebDriver driver;


    public LoginPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        txt_username.sendKeys(username);
    }

    public void enterPassword(String password) {
        txt_password.sendKeys(password);
    }

    public void clickOnLogin() {
        btn_login.click();
    }

    public boolean isLoginPage() {

        return btn_login.isDisplayed();
    }

    public void navigateToLoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(sauceDemoURL);
    }
}

