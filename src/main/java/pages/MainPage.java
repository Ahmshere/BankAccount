package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MainPage extends BasePage {
    @FindBy(xpath = "//button[contains(text(), 'Customer')]")
    WebElement customerLoginButton;
    @FindBy(xpath = "//button[contains(text(), 'Manager')]")
    WebElement bankManagerLoginButton;

    public MainPage(WebDriver driver) {
        setDriver(driver);
        if (driver == null) {
            throw new IllegalArgumentException("The instance is null");
        }
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public CustomerLoginPage clickByCustomerLoginButton() {
        customerLoginButton.click();
        return new CustomerLoginPage(driver);
    }
    public ManagerLoginPage clickByBankManagerLoginButton(){
        bankManagerLoginButton.click();
        return new ManagerLoginPage(driver);
    }

    public boolean isTheButtonsPersist() {
        return isElementPersist(driver.findElement(By.xpath("//button[contains(text(), 'Customer')] | //button[contains(text(), 'Manager')]")));
    }
}
