package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    WebDriver driver;


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void isHomePage() {
        driver.getTitle();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
