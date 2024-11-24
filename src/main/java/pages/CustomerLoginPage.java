package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerLoginPage extends BasePage{
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    public CustomerLoginPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }
    private Select getSelect() {
        WebElement selectElement = driver.findElement(By.id("userSelect"));
        return new Select(selectElement);
    }
    public CustomerLoginPage chooseYourNameUsingIndex(int index){
        getSelect().selectByIndex(index);
        return this;
    }
    public CustomerLoginPage chooseYourNameUsingText(String name){
        getSelect().selectByVisibleText(name);
        return this;
    }
    public CustomerLoginPage chooseYourNameUsingValue(String value){
        getSelect().selectByValue(value);
        return this;
    }
    public CustomerAccountPage clickLoginButton(){
        loginButton.click();
        return new CustomerAccountPage(driver);
    }


}
