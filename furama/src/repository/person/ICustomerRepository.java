package repository.person;

import entity.person.Customer;
import repository.IRepository;

import java.util.List;

public interface ICustomerRepository extends IRepository<Customer> {
    List<Customer> findFullName(String fullName);
}
