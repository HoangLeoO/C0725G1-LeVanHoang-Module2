package service;

import entity.person.Customer;
import repository.Person.CustomerRepository;
import repository.Person.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService{

    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findFullName(String fullName) {
        return customerRepository.findFullName(fullName);
    }

    @Override
    public Customer findCode(String code) {
        return customerRepository.findCode(code);
    }

    @Override
    public boolean add(Customer object) {
        return customerRepository.add(object);
    }

    @Override
    public void edit(Customer object) {
        customerRepository.edit(object);
    }

    @Override
    public boolean deleteByCode(String code) {
        return customerRepository.deleteByCode(code);
    }
}
