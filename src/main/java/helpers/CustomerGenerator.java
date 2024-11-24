package helpers;

import models.Customer;

public class CustomerGenerator {

    public static Customer createCustomer(String name, String lastName, String pCode) {
        Customer customer = new Customer(name, lastName, pCode);
        return customer;

    }
}
