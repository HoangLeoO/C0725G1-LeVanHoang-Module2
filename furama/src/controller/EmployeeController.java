package controller;

import entity.person.Employee;
import service.EmployeeService;

import java.util.List;

public class EmployeeController {
    private static EmployeeService employeeService = new EmployeeService();

    // Lấy danh sách tất cả nhân viên
    public static List<Employee> employeeList() {
        return employeeService.findAll();
    }

    // Thêm nhân viên mới
    public static boolean addEmployee(Employee employee) {
        if (employee == null) {
            return false;
        }
        employeeService.add(employee);
        return true;
    }

    // Cập nhật thông tin nhân viên
    public static void updateEmployee(Employee employee) {
        employeeService.edit(employee);
    }

    // Xóa nhân viên theo mã
    public static boolean deleteEmployee(String code) {
        return employeeService.deleteByCode(code);
    }

    // Tìm nhân viên theo mã
    public static Employee searchByCode(String code){
        return employeeService.findCode(code);
    }
}
