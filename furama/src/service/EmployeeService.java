package service;

import entity.person.Employee;
import repository.Person.EmployeeRepository;
import repository.Person.IEmployeeRepository;

import java.util.List;

public class EmployeeService implements IEmployeeService{

    private IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findFullName(String fullName) {
        return employeeRepository.findFullName(fullName);
    }

    @Override
    public Employee findCode(String code) {
        return employeeRepository.findCode(code);
    }

    @Override
    public boolean add(Employee object) {
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
