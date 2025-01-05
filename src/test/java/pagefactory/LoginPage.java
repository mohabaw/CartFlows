package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    @FindBy(id = "user-name")
    WebElement txt_username;

    @FindBy(id = "password")
    WebElement txt_password;

    @FindBy(id = "login-button")
    WebElement btn_login;

    WebDriver driver;
    String URL = "https://www.saucedemo.com/";

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
        boolean status = btn_login.isDisplayed();

        return status;
    }

    public void navigateToLoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(URL);
    }
}

