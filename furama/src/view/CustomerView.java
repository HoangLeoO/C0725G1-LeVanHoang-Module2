package view;

import entity.enums.CustomerType;
import entity.person.Customer;
import util.ValidatePerson;

import javax.sound.midi.Soundbank;
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

        System.out.print("Nhập mã khách hàng: ");
        String code = scanner.nextLine();

        // Nhập họ và tên
        String fullName;
        while (true) {
            System.out.print("Nhập họ và tên: ");
            fullName = scanner.nextLine();
            if (fullName.matches(ValidatePerson.FULL_NAME)) {
                break;
            }
            System.out.println("Họ tên không hợp lệ. Nhập lại!");
        }

        // Nhập ngày sinh
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

        // Nhập giới tính
        System.out.print("Nhập giới tính (Nam/Nữ): ");
        String gender = scanner.nextLine();

        // Nhập CMND/CCCD
        String idCard;
        while (true) {
            System.out.print("Nhập số CMND/CCCD: ");
            idCard = scanner.nextLine();
            if (idCard.matches(ValidatePerson.ID_CARD)) {
                break;
            }
            System.out.println("CMND/CCCD không hợp lệ. Nhập lại!");
        }

        // Nhập số điện thoại
        String phone;
        while (true) {
            System.out.print("Nhập số điện thoại: ");
            phone = scanner.nextLine();
            if (phone.matches(ValidatePerson.PHONE)) {
                break;
            }
            System.out.println("Số điện thoại không hợp lệ. Nhập lại!");
        }

        // Nhập email
        String email;
        while (true) {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();
            if (email.matches(ValidatePerson.EMAIL)) {
                break;
            }
            System.out.println("Email không hợp lệ. Nhập lại!");
        }

        // Chọn loại khách hàng
        CustomerType customerType = chooseCustomerType();

        // Nhập địa chỉ
        String address;
        while (true) {
            System.out.print("Nhập địa chỉ: ");
            address = scanner.nextLine();
            if (address.matches(ValidatePerson.ADDRESS)) {
                break;
            }
            System.out.println("Địa chỉ không hợp lệ. Nhập lại!");
        }

        // Trả về Customer đã tạo
        return new Customer(code, fullName, birthday, gender, idCard, phone, email, customerType, address);
    }

    // Form chỉnh sửa khách hàng
    public static Customer showFormEdit(Customer customer) {
        Customer customerNew = new Customer();

        System.out.println("===== CHỈNH SỬA KHÁCH HÀNG =====");

        customerNew.setCode(customer.getCode());
        System.out.print("Họ và tên (" + customer.getFullName() + "): ");
        String fullName = scanner.nextLine();
        customerNew.setFullName(fullName.isEmpty() ? customer.getFullName() : fullName);

        System.out.print("Ngày sinh (" + customer.getBirthday() + ") [dd/MM/yyyy]: ");
        String birthdayStr = scanner.nextLine();
        if (!birthdayStr.isEmpty()) {
            LocalDate birthday = LocalDate.parse(birthdayStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            customerNew.setBirthday(birthday);
        } else {
            customerNew.setBirthday(customer.getBirthday());
        }

        System.out.print("Giới tính (" + customer.getGender() + "): ");
        String gender = scanner.nextLine();
        customerNew.setGender(gender.isEmpty() ? customer.getGender() : gender);

        System.out.print("CMND/CCCD (" + customer.getIdCard() + "): ");
        String idCard = scanner.nextLine();
        customerNew.setIdCard(idCard.isEmpty() ? customer.getIdCard() : idCard);

        System.out.print("Số điện thoại (" + customer.getPhone() + "): ");
        String phone = scanner.nextLine();
        customerNew.setPhone(phone.isEmpty() ? customer.getPhone() : phone);

        System.out.print("Email (" + customer.getEmail() + "): ");
        String email = scanner.nextLine();
        customerNew.setEmail(email.isEmpty() ? customer.getEmail() : email);

        System.out.println("Loại khách hàng (" + customer.getCustomerType() + "): ");
        System.out.print("Bạn có muốn thay đổi không? (y/n): ");
        String changeType = scanner.nextLine();
        if (changeType.equalsIgnoreCase("y")) {
            customerNew.setCustomerType(chooseCustomerType());
        } else {
            customerNew.setCustomerType(customer.getCustomerType());
        }

        System.out.print("Địa chỉ (" + customer.getAddress() + "): ");
        String address = scanner.nextLine();
        customerNew.setAddress(address.isEmpty() ? customer.getAddress() : address);

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
}
