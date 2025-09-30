package repository.Person;

import entity.person.Employee;
import util.ReadAndWriterFile;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String PATH_FILE = "src/data/employee.csv";

    @Override
    public List<Employee> findAll() {
        List<String> stringList = ReadAndWriterFile.readFile(PATH_FILE);
        List<Employee> employeeList = new ArrayList<>();
        for (String string : stringList) {
            employeeList.add(Employee.fromCSV(string));
        }
        return employeeList;
    }

    @Override
    public List<Employee> findFullName(String fullName) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : findAll()) {
            if (employee.getFullName().equalsIgnoreCase(fullName)) {
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public Employee findCode(String code) {
        for (Employee employee : findAll()) {
            if (employee.getCode().equals(code)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public boolean add(Employee object) {
        if (object == null) return false;

        if (findCode(object.getCode()) != null) {
            return false;
        }

        List<String> stringList = new ArrayList<>();
        stringList.add(object.toCSV());
        ReadAndWriterFile.writerFile(PATH_FILE, stringList, true);
        return true;
    }

    @Override
    public void edit(Employee object) {
        List<Employee> employeeList = findAll();
        boolean updated = false;

        for (Employee employee : employeeList) {
            if (employee.getCode().equals(object.getCode())) {
                employee.updateFrom(object);
                updated = true;
                break;
            }
        }

        if (updated) {
            List<String> stringList = new ArrayList<>();
            for (Employee employee : employeeList) {
                stringList.add(employee.toCSV());
            }
            ReadAndWriterFile.writerFile(PATH_FILE, stringList);
        }
    }

    @Override
    public boolean deleteByCode(String code) {
        if (code == null) return false;

        List<Employee> employeeList = findAll();
        boolean removed = employeeList.removeIf(e -> e.getCode().equals(code));

        if (removed) {
            List<String> stringList = new ArrayList<>();
            for (Employee employee : employeeList) {
                stringList.add(employee.toCSV());
            }
            ReadAndWriterFile.writerFile(PATH_FILE, stringList);
        }
        return removed;
    }
}
