package service.person;

import entity.person.Customer;
import entity.person.Employee;
import repository.person.EmployeeRepository;
import repository.person.IEmployeeRepository;

import java.util.List;
import java.util.Random;

public class EmployeeService implements IEmployeeService {

    private IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findCode(String code) {
        return employeeRepository.findCode(code);
    }

    @Override
    public boolean add(Employee object) {
        List<Employee> employees = findAll();

        boolean check = true;
        while (check) {
            Random random = new Random();
            int number = random.nextInt(9000) + 1000;
            if (employees.isEmpty()) {
                object.setCode("NV-" + number);
            } else {
                for (Employee employee : employees){
                    int numberCode = Integer.parseInt(employee.getCode().substring(3));
                    if (numberCode != number){
                        check = false;
                        object.setCode("NV-" + number);
                    }
                }
            }

        }
        return employeeRepository.add(object);
    }

    @Override
    public void edit(Employee object) {
        employeeRepository.edit(object);
    }

    @Override
    public boolean deleteByCode(String code) {
        return employeeRepository.deleteByCode(code);
    }
}
