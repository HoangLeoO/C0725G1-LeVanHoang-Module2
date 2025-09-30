package repository.Person;

import entity.person.Employee;
import repository.IService;

import java.util.List;

public interface IEmployeeRepository extends IService<Employee> {

    List<Employee> findFullName(String fullName);

}
