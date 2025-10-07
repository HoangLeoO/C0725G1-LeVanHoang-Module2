package repository.person;

import entity.person.Employee;
import repository.IRepository;

import java.util.List;

public interface IEmployeeRepository extends IRepository<Employee> {

    List<Employee> findFullName(String fullName);

}
