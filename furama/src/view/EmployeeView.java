package view;

import entity.enums.EducationLevel;
import entity.enums.Position;
import entity.person.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class EmployeeView {
    private static Scanner scanner = new Scanner(System.in);

    // Hiển thị danh sách nhân viên
    public static void showListEmployee(List<Employee> employeeList) {
        if (employeeList == null || employeeList.isEmpty()) {
            System.out.println("Danh sách nhân viên trống!");
            return;
        }

        System.out.println("===========================================================================================================================");
        System.out.printf("%-10s %-20s %-12s %-10s %-15s %-15s %-25s %-15s %-15s %-12s\n",
                "Mã NV", "Họ và tên", "Ngày sinh", "Giới tính", "CMND/CCCD", "SĐT", "Email", "Trình độ", "Chức vụ", "Lương");
        System.out.println("===========================================================================================================================");

        for (Employee e : employeeList) {
            System.out.printf("%-10s %-20s %-12s %-10s %-15s %-15s %-25s %-15s %-15s %-12.2f\n",
                    e.getCode(),
                    e.getFullName(),
                    e.getBirthday(),
                    e.getGender(),
                    e.getIdCard(),
                    e.getPhone(),
                    e.getEmail(),
                    e.getLevel(),
                    e.getPosition(),
                    e.getSalary());
        }
        System.out.println("===========================================================================================================================");
    }

    // Form thêm nhân viên mới
    public static Employee showFormAdd() {
        System.out.println("===== THÊM NHÂN VIÊN MỚI =====");

        System.out.print("Nhập mã nhân viên: ");
        String code = scanner.nextLine();

        System.out.print("Nhập họ và tên: ");
        String fullName = scanner.nextLine();

        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        String birthdayStr = scanner.nextLine();
        LocalDate birthday = LocalDate.parse(birthdayStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Nhập giới tính: ");
        String gender = scanner.nextLine();

        System.out.print("Nhập số CMND/CCCD: ");
        String idCard = scanner.nextLine();

        System.out.print("Nhập số điện thoại: ");
        String phone = scanner.nextLine();

        System.out.print("Nhập email: ");
        String email = scanner.nextLine();

        System.out.println("Chọn trình độ học vấn: ");
        EducationLevel level = chooseEducationLevel();

        System.out.println("Chọn chức vụ: ");
        Position position = choosePosition();

        System.out.print("Nhập lương: ");
        double salary = Double.parseDouble(scanner.nextLine());

        return new Employee(code, fullName, birthday, gender, idCard, phone, email, level, position, salary);
    }

    // Form chỉnh sửa nhân viên
    public static Employee showFormEdit(Employee employee) {
        Employee employeeNew = new Employee();

        System.out.println("===== CHỈNH SỬA NHÂN VIÊN =====");

        employeeNew.setCode(employee.getCode());

        System.out.print("Họ và tên (" + employee.getFullName() + "): ");
        String fullName = scanner.nextLine();
        employeeNew.setFullName(fullName.isEmpty() ? employee.getFullName() : fullName);

        System.out.print("Ngày sinh (" + employee.getBirthday() + ") [dd/MM/yyyy]: ");
        String birthdayStr = scanner.nextLine();
        if (!birthdayStr.isEmpty()) {
            LocalDate birthday = LocalDate.parse(birthdayStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            employeeNew.setBirthday(birthday);
        } else {
            employeeNew.setBirthday(employee.getBirthday());
        }

        System.out.print("Giới tính (" + employee.getGender() + "): ");
        String gender = scanner.nextLine();
        employeeNew.setGender(gender.isEmpty() ? employee.getGender() : gender);

        System.out.print("CMND/CCCD (" + employee.getIdCard() + "): ");
        String idCard = scanner.nextLine();
        employeeNew.setIdCard(idCard.isEmpty() ? employee.getIdCard() : idCard);

        System.out.print("Số điện thoại (" + employee.getPhone() + "): ");
        String phone = scanner.nextLine();
        employeeNew.setPhone(phone.isEmpty() ? employee.getPhone() : phone);

        System.out.print("Email (" + employee.getEmail() + "): ");
        String email = scanner.nextLine();
        employeeNew.setEmail(email.isEmpty() ? employee.getEmail() : email);

        System.out.println("Trình độ học vấn (" + employee.getLevel().getDisplayName() + "): ");
        System.out.print("Bạn có muốn thay đổi không? (y/n): ");
        String changeLevel = scanner.nextLine();
        if (changeLevel.equalsIgnoreCase("y")) {
            employeeNew.setLevel(chooseEducationLevel());
        } else {
            employeeNew.setLevel(employee.getLevel());
        }

        System.out.println("Chức vụ (" + employee.getPosition().getDisplayName() + "): ");
        System.out.print("Bạn có muốn thay đổi không? (y/n): ");
        String changePos = scanner.nextLine();
        if (changePos.equalsIgnoreCase("y")) {
            employeeNew.setPosition(choosePosition());
        } else {
            employeeNew.setPosition(employee.getPosition());
        }

        System.out.print("Lương (" + employee.getSalary() + "): ");
        String salaryStr = scanner.nextLine();
        employeeNew.setSalary(salaryStr.isEmpty() ? employee.getSalary() : Double.parseDouble(salaryStr));

        return employeeNew;
    }

    private static EducationLevel chooseEducationLevel() {
        while (true) {
            System.out.println("1. " + EducationLevel.INTERMEDIATE.getDisplayName());
            System.out.println("2. " + EducationLevel.COLLEGE.getDisplayName());
            System.out.println("3. " + EducationLevel.UNIVERSITY.getDisplayName());
            System.out.println("4. " + EducationLevel.POSTGRADUATE.getDisplayName());
            System.out.print("Lựa chọn của bạn: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    return EducationLevel.INTERMEDIATE;
                }
                case "2" -> {
                    return EducationLevel.COLLEGE;
                }
                case "3" -> {
                    return EducationLevel.UNIVERSITY;
                }
                case "4" -> {
                    return EducationLevel.POSTGRADUATE;
                }
                default -> System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại!");
            }
        }
    }

    private static Position choosePosition() {
        while (true) {
            System.out.println("1. " + Position.RECEPTIONIST.getDisplayName());
            System.out.println("2. " + Position.WAITER.getDisplayName());
            System.out.println("3. " + Position.SPECIALIST.getDisplayName());
            System.out.println("4. " + Position.SUPERVISOR.getDisplayName());
            System.out.println("5. " + Position.MANAGER.getDisplayName());
            System.out.println("6. " + Position.DIRECTOR.getDisplayName());
            System.out.print("Lựa chọn của bạn: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    return Position.RECEPTIONIST;
                }
                case "2" -> {
                    return Position.WAITER;
                }
                case "3" -> {
                    return Position.SPECIALIST;
                }
                case "4" -> {
                    return Position.SUPERVISOR;
                }
                case "5" -> {
                    return Position.MANAGER;
                }
                case "6" -> {
                    return Position.DIRECTOR;
                }
                default -> System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại!");
            }
        }
    }
}
