package pages;

import enums.Operations;
import models.Customer;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ManagerLoginPage extends BasePage {
    @FindBy(xpath = "//input[@ng-model='fName']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@ng-model='lName']")
    WebElement lastNameField;
    @FindBy(xpath = "//input[@ng-model='postCd']")
    WebElement postCodeField;

    public ManagerLoginPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public ManagerLoginPage chooseOperation(Operations operation) {
        WebElement menuItem = driver.findElement(By.xpath("//button[@ng-class='" + operation.getValue() + "']"));
        menuItem.click();
        return this;
    }

    public ManagerLoginPage fillTheForm(Customer customer) {

        firstNameField.sendKeys(customer.getName());
        lastNameField.sendKeys(customer.getLastName());
        postCodeField.sendKeys(customer.getPostalCode());

       return this;
    }

    public void clickAddCustomer() {
        WebElement addButton = driver.findElement(By.xpath("//button[@type='submit']"));
        addButton.click();
    }

    public String checkAlert() {
        clickAddCustomer();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();

        return alertText;
    }
}
