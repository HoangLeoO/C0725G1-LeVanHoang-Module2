package controller;

import entity.Contract;
import entity.person.Customer;
import entity.person.Employee;
import view.*;

import java.util.Scanner;

public class FuramaController {

    private static Scanner scanner = new Scanner(System.in);

    public static void menuFurama() {
        boolean running = true;
        while (running) {
            System.out.println("===== QUẢN LÝ FURAMA RESORT =====");
            System.out.println("1. Quản lý nhân viên");
            System.out.println("2. Quản lý khách hàng");
            System.out.println("3. Quản lý cơ sở vật chất");
            System.out.println("4. Quản lý đặt chỗ");
            System.out.println("5. Quản lý khuyến mãi");
            System.out.println("6. Thoát");
            System.out.println("=================================");
            System.out.print("Vui lòng chọn chức năng: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> showMenuEmployee();
                case "2" -> showMenuCustomer();
                case "3" -> showMenuFacility();
                case "4" -> showMenuBooking();
                case "5" -> showMenuPromotion();
                case "6" -> {
                    System.out.println("Thoát chương trình!");
                    running = false;
                }
                default -> System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }

    public static void showMenuEmployee() {
        boolean back = false;
        while (!back) {
            System.out.println("===== QUẢN LÝ NHÂN VIÊN =====");
            System.out.println("1. Hiển thị danh sách nhân viên");
            System.out.println("2. Thêm nhân viên mới");
            System.out.println("3. Chỉnh sửa nhân viên");
            System.out.println("4. Quay lại menu chính");
            System.out.println("================================");
            System.out.print("Lựa chọn của bạn: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> EmployeeView.showListEmployee(EmployeeController.employeeList());
                case "2" -> {
                    Employee employee = EmployeeView.showFormAdd();
                    if (EmployeeController.addEmployee(employee)) {
                        System.out.println("Thêm nhân viên thành công!");
                    }
                }
                case "3" -> {
                    System.out.print("Nhập mã nhân viên cần chỉnh sửa: ");
                    String code = scanner.nextLine();
                    Employee employee = EmployeeController.searchByCode(code);
                    if (employee != null) {
                        EmployeeController.updateEmployee(EmployeeView.showFormEdit(employee));
                        System.out.println("Cập nhật nhân viên thành công!");
                    } else {
                        System.out.println("Không tìm thấy nhân viên với mã: " + code);
                    }
                }
                case "4" -> back = true; // quay lại menu chính
                default -> System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại!");
            }
        }
    }


    public static void showMenuCustomer() {
        boolean back = false;
        while (!back) {
            System.out.println("===== QUẢN LÝ KHÁCH HÀNG =====");
            System.out.println("1. Hiển thị danh sách khách hàng");
            System.out.println("2. Thêm khách hàng mới");
            System.out.println("3. Chỉnh sửa khách hàng");
            System.out.println("4. Quay lại menu chính");
            System.out.println("================================");
            System.out.print("Vui lòng chọn chức năng: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> CustomerView.showListCustomer(CustomerController.customerList());
                case "2" -> {
                    if (CustomerController.addCustomer(CustomerView.showFormAdd())) {
                        System.out.println("Thêm khách hàng thành công!");
                    }
                }
                case "3" -> {
                    System.out.print("Nhập mã khách hàng cần chỉnh sửa: ");
                    String code = scanner.nextLine();
                    Customer customer = CustomerController.searchByCode(code);
                    if (customer != null) {
                        CustomerController.updateCustomer(CustomerView.showFormEdit(customer));
                        System.out.println("Cập nhật khách hàng thành công!");
                    } else {
                        System.out.println("Không tìm thấy khách hàng với mã: " + code);
                    }

                }
                case "4" -> back = true;
                default -> System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }

    public static void showMenuFacility() {
        boolean back = false;
        while (!back) {
            System.out.println("===== QUẢN LÝ CƠ SỞ VẬT CHẤT =====");
            System.out.println("1. Hiển thị danh sách cơ sở vật chất");
            System.out.println("2. Thêm cơ sở vật chất mới");
            System.out.println("3. Hiển thị danh sách cơ sở vật chất cần bảo trì");
            System.out.println("4. Quay lại menu chính");
            System.out.println("=================================");
            System.out.print("Vui lòng chọn chức năng: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> FacilityView.showList(FacilityController.showAll());
                case "2" -> {
                    System.out.println(FacilityController.add(FacilityView.showAdd()) ? "Thêm thành công!" : "Thêm không thành công!");
                }
                case "3" -> FacilityView.showListMaintenance(FacilityController.showMaintenanceList());
                case "4" -> back = true;
                default -> System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }

    public static void showMenuBooking() {
        boolean back = false;
        while (!back) {
            System.out.println("===== QUẢN LÝ ĐẶT CHỖ =====");
            System.out.println("1. Thêm đặt chỗ mới");
            System.out.println("2. Hiển thị danh sách đặt chỗ");
            System.out.println("3. Tạo hợp đồng mới");
            System.out.println("4. Hiển thị danh sách hợp đồng");
            System.out.println("5. Chỉnh sửa hợp đồng");
            System.out.println("6. Quay lại menu chính");
            System.out.println("================================");
            System.out.print("Vui lòng chọn chức năng: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    CustomerView.showListCustomer(CustomerController.customerList());
                    BookingController.addBooking(BookingView.showAdd());
                }
                case "2" -> {

                    BookingView.showList(BookingController.showAll());
                }
                case "3" -> ContractController.add(ContractView.showAdd(BookingController.getFirstAndRemoveBooking()));
                case "4" -> ContractView.showList(ContractController.showList());
                case "5" -> {
                    System.out.println(">>> Nhập mã hợp đồng chỉnh sửa");
                    Contract contract = ContractController.getContract(scanner.nextLine());
                    if (contract != null) {
                        ContractController.editContract(ContractView.showEdit(contract));
                    } else {
                        System.out.println(" Không tìm thấy hợp đồng!");
                    }

                }
                case "6" -> back = true;
                default -> System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }

    public static void showMenuPromotion() {
        boolean back = false;
        while (!back) {
            System.out.println("===== QUẢN LÝ KHUYẾN MÃI =====");
            System.out.println("1. Hiển thị danh sách khách hàng sử dụng dịch vụ");
            System.out.println("2. Hiển thị danh sách khách hàng nhận voucher");
            System.out.println("3. Quay lại menu chính");
            System.out.println("==================================");
            System.out.print("Vui lòng chọn chức năng: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> System.out.println(">>> Hiển thị danh sách khách hàng sử dụng dịch vụ");
                case "2" -> System.out.println(">>> Hiển thị danh sách khách hàng nhận voucher");
                case "3" -> back = true;
                default -> System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }
}
