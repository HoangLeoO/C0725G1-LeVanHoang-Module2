package view;

import entity.enums.CustomerType;
import entity.person.Customer;
import validate.ValidatePerson;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private static Scanner scanner = new Scanner(System.in);

    // Hiển thị danh sách khách hàng
    public static void showListCustomer(List<Customer> customerList) {
        if (customerList == null || customerList.isEmpty()) {
            System.out.println("Danh sách khách hàng trống!");
            return;
        }

        System.out.println("=============================================================================================================================");
        System.out.printf("%-10s %-20s %-12s %-10s %-15s %-15s %-25s %-15s %-20s\n",
                "Mã KH", "Họ và tên", "Ngày sinh", "Giới tính", "CMND/CCCD", "SĐT", "Email", "Loại KH", "Địa chỉ");
        System.out.println("=============================================================================================================================");

        for (Customer c : customerList) {
            System.out.printf("%-10s %-20s %-12s %-10s %-15s %-15s %-25s %-15s %-20s\n",
                    c.getCode(),
                    c.getFullName(),
                    c.getBirthday(),
                    c.getGender(),
                    c.getIdCard(),
                    c.getPhone(),
                    c.getEmail(),
                    c.getCustomerType(),
                    c.getAddress());
        }
        System.out.println("=============================================================================================================================");
    }

    // Form thêm khách hàng mới
    public static Customer showFormAdd() {
        System.out.println("===== THÊM KHÁCH HÀNG MỚI =====");

        // Mã khách hàng
        String code;
        while (true) {
            System.out.print("Nhập mã khách hàng: ");
            code = scanner.nextLine();
            if (!code.isEmpty()) break;
            System.out.println("Mã khách hàng không được để trống!");
        }

        // Họ và tên
        String fullName;
        while (true) {
            System.out.print("Nhập họ và tên: ");
            fullName = scanner.nextLine();
            if (ValidatePerson.checkFullName(fullName)) break;
            System.out.println("Họ tên không hợp lệ (ít nhất 2 từ, mỗi từ bắt đầu bằng chữ hoa)!");
        }

        // Ngày sinh
        LocalDate birthday;
        while (true) {
            System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
            String birthdayStr = scanner.nextLine();
            try {
                birthday = LocalDate.parse(birthdayStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Ngày sinh không hợp lệ. Nhập lại!");
            }
        }

        // Giới tính
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

        // Loại khách hàng
        CustomerType customerType = chooseCustomerType();

        // Địa chỉ
        String address;
        while (true) {
            System.out.print("Nhập địa chỉ: ");
            address = scanner.nextLine();
            if (ValidatePerson.checkAddress(address)) break;
            System.out.println("Địa chỉ không hợp lệ (ít nhất 3 ký tự).");
        }

        return new Customer(code, fullName, birthday, gender, idCard, phone, email, customerType, address);
    }

    public static Customer showFormEdit(Customer customer) {
        Customer customerNew = new Customer();
        customerNew.setCode(customer.getCode());

        // Họ và tên
        while (true) {
            System.out.print("Họ và tên (" + customer.getFullName() + "): ");
            String fullName = scanner.nextLine();
            if (fullName.isEmpty()) {
                customerNew.setFullName(customer.getFullName());
                break;
            } else if (ValidatePerson.checkFullName(fullName)) {
                customerNew.setFullName(fullName);
                break;
            } else {
                System.out.println("Họ tên không hợp lệ (ít nhất 2 từ, mỗi từ bắt đầu bằng chữ hoa)!");
            }
        }

        // Ngày sinh
        while (true) {
            System.out.print("Ngày sinh (" + customer.getBirthday() + ") [dd/MM/yyyy]: ");
            String birthdayStr = scanner.nextLine();
            if (birthdayStr.isEmpty()) {
                customerNew.setBirthday(customer.getBirthday());
                break;
            }
            try {
                LocalDate birthday = LocalDate.parse(birthdayStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                customerNew.setBirthday(birthday);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Ngày sinh không hợp lệ. Nhập lại!");
            }
        }

        // Giới tính
        // Giới tính
        System.out.println("Giới tính (" + customer.getGender() + "): ");
        String gender = chooseGender(customer.getGender());
        customerNew.setGender(gender);

        // CMND/CCCD
        while (true) {
            System.out.print("CMND/CCCD (" + customer.getIdCard() + "): ");
            String idCard = scanner.nextLine();
            if (idCard.isEmpty()) {
                customerNew.setIdCard(customer.getIdCard());
                break;
            } else if (ValidatePerson.checkIdCard(idCard)) {
                customerNew.setIdCard(idCard);
                break;
            } else {
                System.out.println("CMND/CCCD phải là 9 hoặc 12 chữ số.");
            }
        }

        // Số điện thoại
        while (true) {
            System.out.print("Số điện thoại (" + customer.getPhone() + "): ");
            String phone = scanner.nextLine();
            if (phone.isEmpty()) {
                customerNew.setPhone(customer.getPhone());
                break;
            } else if (ValidatePerson.checkPhone(phone)) {
                customerNew.setPhone(phone);
                break;
            } else {
                System.out.println("Số điện thoại không hợp lệ (bắt đầu bằng 0, 10-11 chữ số).");
            }
        }

        // Email
        while (true) {
            System.out.print("Email (" + customer.getEmail() + "): ");
            String email = scanner.nextLine();
            if (email.isEmpty()) {
                customerNew.setEmail(customer.getEmail());
                break;
            } else if (ValidatePerson.checkEmail(email)) {
                customerNew.setEmail(email);
                break;
            } else {
                System.out.println("Email không hợp lệ.");
            }
        }

        // Loại khách hàng
        System.out.println("Loại khách hàng (" + customer.getCustomerType() + "): ");
        System.out.print("Bạn có muốn thay đổi không? (y/n): ");
        String changeType = scanner.nextLine();
        if (changeType.equalsIgnoreCase("y")) {
            customerNew.setCustomerType(chooseCustomerType());
        } else {
            customerNew.setCustomerType(customer.getCustomerType());
        }

        // Địa chỉ
        while (true) {
            System.out.print("Địa chỉ (" + customer.getAddress() + "): ");
            String address = scanner.nextLine();
            if (address.isEmpty()) {
                customerNew.setAddress(customer.getAddress());
                break;
            } else if (ValidatePerson.checkAddress(address)) {
                customerNew.setAddress(address);
                break;
            } else {
                System.out.println("Địa chỉ không hợp lệ (ít nhất 3 ký tự).");
            }
        }

        return customerNew;
    }


    // Chọn loại khách hàng
    private static CustomerType chooseCustomerType() {
        while (true) {
            System.out.println("1. DIAMOND");
            System.out.println("2. PLATINUM");
            System.out.println("3. GOLD");
            System.out.println("4. SILVER");
            System.out.println("5. MEMBER");
            System.out.print("Lựa chọn của bạn: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    return CustomerType.DIAMOND;
                }
                case "2" -> {
                    return CustomerType.PLATINUM;
                }
                case "3" -> {
                    return CustomerType.GOLD;
                }
                case "4" -> {
                    return CustomerType.SILVER;
                }
                case "5" -> {
                    return CustomerType.MEMBER;
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
