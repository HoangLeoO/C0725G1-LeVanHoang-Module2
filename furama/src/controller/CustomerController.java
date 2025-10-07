package controller;

import entity.person.Customer;
import service.person.CustomerService;

import java.util.List;

public class CustomerController {
    private static CustomerService customerService = new CustomerService();

    public static List<Customer> customerList() {
        return customerService.findAll();
    }

    public static boolean addCustomer(Customer customer) {
        if (customer == null) {
            return false;
        }
        customerService.add(customer);
        return true;
    }

    public static void updateCustomer(Customer customer) {
        customerService.edit(customer);
    }

    public static boolean deleteCustomer(String code) {
        return customerService.deleteByCode(code);
    }

    public static Customer searchByCode(String code){
        return customerService.findCode(code);
    }
}
