package service.person;

import entity.person.Customer;
import repository.person.CustomerRepository;
import repository.person.ICustomerRepository;

import java.util.List;
import java.util.Random;

public class CustomerService implements ICustomerService {

    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCode(String code) {
        return customerRepository.findCode(code);
    }

    @Override
    public boolean add(Customer object) {

        List<Customer> customerList = findAll();

        boolean check = true;
        while (check) {
            Random random = new Random();
            int number = random.nextInt(9000) + 1000;
            if (customerList.isEmpty()) {
                object.setCode("KH-" + number);
            } else {
               for (Customer customer : customerList){
                   int numberCode = Integer.parseInt(customer.getCode().substring(3));
                   if (numberCode != number){
                       check = false;
                       object.setCode("KH-" + number);
                   }
               }
            }

        }

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
