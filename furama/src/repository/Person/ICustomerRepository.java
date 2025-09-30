package repository.Person;

import entity.person.Customer;
import repository.IService;

import java.util.List;

public interface ICustomerRepository extends IService<Customer> {
    List<Customer> findFullName(String fullName);
}
