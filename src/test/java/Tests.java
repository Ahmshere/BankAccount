import config.BaseTest;
import enums.Operations;
import helpers.CustomerGenerator;
import helpers.NameAndLastNameGenerator;
import helpers.PostCodeGenerator;
import models.Customer;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerLoginPage;
import pages.MainPage;
import pages.ManagerLoginPage;

public class Tests extends BaseTest {
    @Test
    public void successfulLogin() {
        MainPage mainPage = new MainPage(getDriver());
        CustomerLoginPage customerLoginPage = mainPage.clickByCustomerLoginButton();
        CustomerAccountPage customerAccountPage = customerLoginPage.chooseYourNameUsingIndex(3).clickLoginButton();
        Assert.assertTrue(customerAccountPage.isTheLogoutButtonPersist());
    }

    @Test
    public void addNewCustomer() throws InterruptedException {
        MainPage mainPage = new MainPage(getDriver());
        Customer customer =
                CustomerGenerator
                        .createCustomer(NameAndLastNameGenerator.generateName(),
                                NameAndLastNameGenerator.generateLastName(), PostCodeGenerator.generatePostCode());
       ManagerLoginPage managerLoginPage = mainPage.clickByBankManagerLoginButton();
        managerLoginPage.chooseOperation(Operations.ADD_CUSTOMER)
                .fillTheForm(customer);
       Assert.assertTrue(managerLoginPage.checkAlert().contains("Customer added successfully"));

    }
}
