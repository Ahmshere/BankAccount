package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    public void setDriver(WebDriver driver){
        this.driver=driver;
    }
    public WebElement waitForAnElementToBeClickable(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public boolean isElementPersist(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException | NullPointerException exception) {
            return false;
        }
    }

}
