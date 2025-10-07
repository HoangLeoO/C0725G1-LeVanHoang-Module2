package view;

import entity.enums.RentalType;
import entity.facility.Facility;
import entity.facility.House;
import entity.facility.Room;
import entity.facility.Villa;
import validate.ValidateFacility;

import java.util.List;
import java.util.Scanner;

public class FacilityView {

    private static Scanner scanner = new Scanner(System.in);

    // ================== SHOW LIST ==================
    public static void showList(List<Facility> facilities) {
        if (facilities.isEmpty()) {
            System.out.println(">>> Danh sách cơ sở vật chất trống!");
            return;
        }

        System.out.println("\n===== DANH SÁCH CƠ SỞ VẬT CHẤT =====");

        // Villa
        System.out.println("\n--- DANH SÁCH VILLA ---");
        facilities.stream()
                .filter(f -> f instanceof Villa)
                .forEach(f -> System.out.println("• " + f));

        // House
        System.out.println("\n--- DANH SÁCH HOUSE ---");
        facilities.stream()
                .filter(f -> f instanceof House)
                .forEach(f -> System.out.println("• " + f));

        // Room
        System.out.println("\n--- DANH SÁCH ROOM ---");
        facilities.stream()
                .filter(f -> f instanceof Room)
                .forEach(f -> System.out.println("• " + f));
    }
    public static void showListMaintenance(List<Facility> facilities) {
        if (facilities.isEmpty()) {
            System.out.println(">>> Danh sách cơ sở vật chất trống!");
            return;
        }

        System.out.println("\n===== DANH SÁCH CƠ SỞ VẬT CHẤT CẦN BẢO TRÌ=====");

        // Villa
        System.out.println("\n--- DANH SÁCH VILLA ---");
        facilities.stream()
                .filter(f -> f instanceof Villa)
                .forEach(f -> System.out.println("• " + f));

        // House
        System.out.println("\n--- DANH SÁCH HOUSE ---");
        facilities.stream()
                .filter(f -> f instanceof House)
                .forEach(f -> System.out.println("• " + f));

        // Room
        System.out.println("\n--- DANH SÁCH ROOM ---");
        facilities.stream()
                .filter(f -> f instanceof Room)
                .forEach(f -> System.out.println("• " + f));
    }


    // ================== MENU ADD ==================
    public static Facility showAdd() {
        System.out.println("\n===== THÊM MỚI CƠ SỞ VẬT CHẤT =====");
        System.out.println("1. Thêm Villa");
        System.out.println("2. Thêm House");
        System.out.println("3. Thêm Room");
        System.out.println("4. Quay lại");
        System.out.print("Chọn loại muốn thêm (1-3): ");

        String choice = scanner.nextLine();
        return switch (choice) {
            case "1" -> showFormVilla();
            case "2" -> showFormHouse();
            case "3" -> showFormRoom();
            default -> null;
        };
    }

    // ================== FORM VILLA ==================
    public static Villa showFormVilla() {
        System.out.println("\n===== THÊM MỚI VILLA =====");
        String serviceName = inputServiceName();
        double area = inputArea("diện tích sử dụng (>30)");
        double price = inputPrice();
        int maxPeople = inputNumberPeople();
        RentalType rentalType = inputRentalType();
        String standardRoom = inputStandardRoom();
        double poolArea = inputArea("diện tích hồ bơi (>30)");
        int numberOfFloors = inputNumberFloors();

        return new Villa(null, serviceName, area, price, maxPeople,
                rentalType, standardRoom, poolArea, numberOfFloors);
    }

    // ================== FORM HOUSE ==================
    public static House showFormHouse() {
        System.out.println("\n===== THÊM MỚI HOUSE =====");
        String serviceName = inputServiceName();
        double area = inputArea("diện tích sử dụng (>30)");
        double price = inputPrice();
        int maxPeople = inputNumberPeople();
        RentalType rentalType = inputRentalType();
        String standardRoom = inputStandardRoom();
        int numberOfFloors = inputNumberFloors();

        return new House(null, serviceName, area, price, maxPeople,
                rentalType, standardRoom, numberOfFloors);
    }

    // ================== FORM ROOM ==================
    public static Room showFormRoom() {
        System.out.println("\n===== THÊM MỚI ROOM =====");
        String serviceName = inputServiceName();
        double area = inputArea("diện tích sử dụng (>30)");
        double price = inputPrice();
        int maxPeople = inputNumberPeople();
        RentalType rentalType = inputRentalType();
        System.out.print("Nhập dịch vụ miễn phí đi kèm: ");
        String freeServiceIncluded = scanner.nextLine();

        return new Room(null, serviceName, area, price, maxPeople,
                rentalType, freeServiceIncluded);
    }

    // ================== INPUT METHODS ==================
    private static String inputServiceName() {
        String name;
        do {
            System.out.print("Nhập tên dịch vụ (Viết hoa chữ cái đầu): ");
            name = scanner.nextLine();
            if (!ValidateFacility.isValidServiceName(name)) {
                System.out.println(">>> Tên dịch vụ không hợp lệ!");
            }
        } while (!ValidateFacility.isValidServiceName(name));
        return name;
    }

    private static double inputArea(String msg) {
        String areaStr;
        do {
            System.out.print("Nhập " + msg + ": ");
            areaStr = scanner.nextLine();
            if (!ValidateFacility.isValidArea(areaStr)) {
                System.out.println(">>> Giá trị không hợp lệ (phải là số thực > 30)!");
            }
        } while (!ValidateFacility.isValidArea(areaStr));
        return Double.parseDouble(areaStr);
    }

    private static double inputPrice() {
        String priceStr;
        do {
            System.out.print("Nhập chi phí thuê (>0): ");
            priceStr = scanner.nextLine();
            if (!ValidateFacility.isValidPrice(priceStr)) {
                System.out.println(">>> Chi phí không hợp lệ!");
            }
        } while (!ValidateFacility.isValidPrice(priceStr));
        return Double.parseDouble(priceStr);
    }

    private static int inputNumberPeople() {
        String numberStr;
        int value;
        do {
            System.out.print("Nhập số người tối đa (1 - 20): ");
            numberStr = scanner.nextLine();
            if (!ValidateFacility.isValidNumberPeople(numberStr)) {
                System.out.println(">>> Số người không hợp lệ!");
                continue;
            }
            value = Integer.parseInt(numberStr);
            if (value <= 0 || value > 20) {
                System.out.println(">>> Số người phải từ 1 đến 20!");
                continue;
            }
            return value;
        } while (true);
    }

    private static int inputNumberFloors() {
        String numberStr;
        do {
            System.out.print("Nhập số tầng (>0): ");
            numberStr = scanner.nextLine();
            if (!ValidateFacility.isValidNumberFloors(numberStr)) {
                System.out.println(">>> Số tầng không hợp lệ!");
            }
        } while (!ValidateFacility.isValidNumberFloors(numberStr));
        return Integer.parseInt(numberStr);
    }

    private static RentalType inputRentalType() {
        RentalType rentalType = null;
        do {
            System.out.println("Chọn loại thuê: 1.Ngày  2.Tháng  3.Năm  4.Giờ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> rentalType = RentalType.DAY;
                case "2" -> rentalType = RentalType.MONTH;
                case "3" -> rentalType = RentalType.YEAR;
                case "4" -> rentalType = RentalType.HOUR;
                default -> System.out.println(">>> Lựa chọn không hợp lệ!");
            }
        } while (rentalType == null);
        return rentalType;
    }

    private static String inputStandardRoom() {
        String choice;
        do {
            System.out.println("Chọn tiêu chuẩn phòng:");
            System.out.println("1. VIP");
            System.out.println("2. Business");
            System.out.println("3. Normal");
            System.out.print("Lựa chọn: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1": return "VIP";
                case "2": return "Business";
                case "3": return "Normal";
                default: System.out.println(">>> Lựa chọn không hợp lệ!");
            }
        } while (true);
    }
}
