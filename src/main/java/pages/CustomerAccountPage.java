package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class CustomerAccountPage extends BasePage{
    @FindAll(@FindBy(xpath = "//button[contains(text(),'Logout')]"))
    List<WebElement> logoutButtons;
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logoutButton;
    public CustomerAccountPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
    public boolean isTheLogoutButtonPersist(){
        return isElementPersist(driver.findElement(By.xpath("//button[contains(text(),'Logout')]")));
    }
    public MainPage clickByLogoutButton(){
        logoutButton.click();
        return new MainPage(driver);
    }

}
