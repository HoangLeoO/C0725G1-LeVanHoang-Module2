package view;

import entity.enums.EducationLevel;
import entity.enums.Position;
import entity.person.Employee;
import validate.ValidatePerson;

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

        // Mã nhân viên (có thể check không rỗng)
        String code;
        while (true) {
            System.out.print("Nhập mã nhân viên: ");
            code = scanner.nextLine();
            if (!code.isEmpty()) break;
            System.out.println("Mã nhân viên không được để trống!");
        }

        // Họ và tên
        String fullName;
        while (true) {
            System.out.print("Nhập họ và tên: ");
            fullName = scanner.nextLine();
            if (ValidatePerson.checkFullName(fullName)) break;
            System.out.println("Họ và tên không hợp lệ (ít nhất 2 từ, mỗi từ bắt đầu bằng chữ hoa)!");
        }

        // Ngày sinh
        LocalDate birthday;
        while (true) {
            try {
                System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
                birthday = LocalDate.parse(scanner.nextLine(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (Exception e) {
                System.out.println("Ngày sinh không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.");
            }
        }

        // Giới tính (có thể check chỉ nhận Male/Female)
       String gender = chooseGender(null);

        // CMND/CCCD
        String idCard;
        while (true) {
            System.out.print("Nhập số CMND/CCCD: ");
            idCard = scanner.nextLine();
            if (ValidatePerson.checkIdCard(idCard)) break;
            System.out.println("CMND/CCCD phải là 9 hoặc 12 chữ số.");
        }

        // Số điện thoại
        String phone;
        while (true) {
            System.out.print("Nhập số điện thoại: ");
            phone = scanner.nextLine();
            if (ValidatePerson.checkPhone(phone)) break;
            System.out.println("Số điện thoại không hợp lệ (bắt đầu bằng 0, 10-11 chữ số).");
        }

        // Email
        String email;
        while (true) {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();
            if (ValidatePerson.checkEmail(email)) break;
            System.out.println("Email không hợp lệ.");
        }

        // Trình độ học vấn
        System.out.println("Chọn trình độ học vấn: ");
        EducationLevel level = chooseEducationLevel();

        // Chức vụ
        System.out.println("Chọn chức vụ: ");
        Position position = choosePosition();

        // Lương
        double salary;
        while (true) {
            try {
                System.out.print("Nhập lương: ");
                String salaryStr = scanner.nextLine();
                if (ValidatePerson.checkSalary(salaryStr)) {
                    salary = Double.parseDouble(salaryStr);
                    break;
                } else {
                    System.out.println("Lương không hợp lệ (số thực, tối đa 2 chữ số thập phân).");
                }
            } catch (Exception e) {
                System.out.println("Lương không hợp lệ.");
            }
        }

        return new Employee(code, fullName, birthday, gender, idCard, phone, email, level, position, salary);
    }


    // Form chỉnh sửa nhân viên
    public static Employee showFormEdit(Employee employee) {
        Employee employeeNew = new Employee();
        employeeNew.setCode(employee.getCode()); // Mã nhân viên giữ nguyên

        System.out.println("===== CHỈNH SỬA NHÂN VIÊN =====");

        // Họ và tên
        while (true) {
            System.out.print("Họ và tên (" + employee.getFullName() + "): ");
            String fullName = scanner.nextLine();
            if (fullName.isEmpty()) {
                employeeNew.setFullName(employee.getFullName());
                break;
            } else if (ValidatePerson.checkFullName(fullName)) {
                employeeNew.setFullName(fullName);
                break;
            } else {
                System.out.println("Họ và tên không hợp lệ (ít nhất 2 từ, mỗi từ bắt đầu bằng chữ hoa)!");
            }
        }

        // Ngày sinh
        while (true) {
            System.out.print("Ngày sinh (" + employee.getBirthday() + ") [dd/MM/yyyy]: ");
            String birthdayStr = scanner.nextLine();
            if (birthdayStr.isEmpty()) {
                employeeNew.setBirthday(employee.getBirthday());
                break;
            }
            try {
                LocalDate birthday = LocalDate.parse(birthdayStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                employeeNew.setBirthday(birthday);
                break;
            } catch (Exception e) {
                System.out.println("Ngày sinh không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.");
            }
        }

        // Giới tính
        System.out.println("Giới tính (" + employee.getGender() + "): ");
        String gender = chooseGender(employee.getGender());
        employeeNew.setGender(gender);

        // CMND/CCCD
        while (true) {
            System.out.print("CMND/CCCD (" + employee.getIdCard() + "): ");
            String idCard = scanner.nextLine();
            if (idCard.isEmpty()) {
                employeeNew.setIdCard(employee.getIdCard());
                break;
            } else if (ValidatePerson.checkIdCard(idCard)) {
                employeeNew.setIdCard(idCard);
                break;
            } else {
                System.out.println("CMND/CCCD phải là 9 hoặc 12 chữ số.");
            }
        }

        // Số điện thoại
        while (true) {
            System.out.print("Số điện thoại (" + employee.getPhone() + "): ");
            String phone = scanner.nextLine();
            if (phone.isEmpty()) {
                employeeNew.setPhone(employee.getPhone());
                break;
            } else if (ValidatePerson.checkPhone(phone)) {
                employeeNew.setPhone(phone);
                break;
            } else {
                System.out.println("Số điện thoại không hợp lệ (bắt đầu bằng 0, 10-11 chữ số).");
            }
        }

        // Email
        while (true) {
            System.out.print("Email (" + employee.getEmail() + "): ");
            String email = scanner.nextLine();
            if (email.isEmpty()) {
                employeeNew.setEmail(employee.getEmail());
                break;
            } else if (ValidatePerson.checkEmail(email)) {
                employeeNew.setEmail(email);
                break;
            } else {
                System.out.println("Email không hợp lệ.");
            }
        }

        // Trình độ học vấn
        System.out.println("Trình độ học vấn (" + employee.getLevel().getDisplayName() + "): ");
        System.out.print("Bạn có muốn thay đổi không? (y/n): ");
        String changeLevel = scanner.nextLine();
        if (changeLevel.equalsIgnoreCase("y")) {
            employeeNew.setLevel(chooseEducationLevel());
        } else {
            employeeNew.setLevel(employee.getLevel());
        }

        // Chức vụ
        System.out.println("Chức vụ (" + employee.getPosition().getDisplayName() + "): ");
        System.out.print("Bạn có muốn thay đổi không? (y/n): ");
        String changePos = scanner.nextLine();
        if (changePos.equalsIgnoreCase("y")) {
            employeeNew.setPosition(choosePosition());
        } else {
            employeeNew.setPosition(employee.getPosition());
        }

        // Lương
        while (true) {
            System.out.print("Lương (" + employee.getSalary() + "): ");
            String salaryStr = scanner.nextLine();
            if (salaryStr.isEmpty()) {
                employeeNew.setSalary(employee.getSalary());
                break;
            }
            if (ValidatePerson.checkSalary(salaryStr)) {
                employeeNew.setSalary(Double.parseDouble(salaryStr));
                break;
            } else {
                System.out.println("Lương không hợp lệ (số thực, tối đa 2 chữ số thập phân).");
            }
        }

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
            System.out.println("1. " + Position.RECEPTIONIST);
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
    private static String chooseGender(String currentGender) {
        while (true) {
            if (currentGender == null) {
                // Add mới
                System.out.print("Chọn giới tính (1. Nam, 2. Nữ): ");
            } else {
                // Edit, hiển thị giá trị cũ
                System.out.print("Chọn giới tính (1. Nam, 2. Nữ): ");
            }

            String input = scanner.nextLine();
            if (input.isEmpty() && currentGender != null) {
                return currentGender; // giữ nguyên giá trị cũ
            }

            switch (input) {
                case "1", "Nam", "nam" -> { return "Nam"; }
                case "2", "Nữ", "nữ" -> { return "Nữ"; }
                default -> System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại!");
            }
        }
    }

}
