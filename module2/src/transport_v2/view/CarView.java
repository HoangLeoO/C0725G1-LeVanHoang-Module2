package transport_v2.view;


import transport_v2.entity.Car;
import transport_v2.entity.Transport;

import java.util.Scanner;

public class CarView {
    static Scanner scanner = new Scanner(System.in);

    public static void showAllCar(Car[] cars) {
        boolean found = false;

        System.out.println("===============================================================");
        System.out.printf("| %-10s | %-15s | %-6s | %-15s | %-5s | %-10s |%n",
                "Biển số", "Hãng SX", "Năm", "Chủ sở hữu", "Chỗ", "Kiểu xe");
        System.out.println("---------------------------------------------------------------");

        for (Car car : cars) {
            if (car != null) {
                System.out.printf("| %-10s | %-15s | %-6d | %-15s | %-5d | %-10s |%n",
                        car.getLicensePlate(),
                        car.getManufacturer(),
                        car.getYearOfManufacture(),
                        car.getOwner(),
                        car.getNumberOfSeats(),
                        car.getVehicleType());
                found = true;
            }
        }

        if (!found) {
            System.out.println("|                  Không có dữ liệu xe ô tô                  |");
        }

        System.out.println("===============================================================");
    }


    public static Transport addCar() {
        Car car = new Car();

        System.out.println("----- THÊM MỚI Ô TÔ -----");
        System.out.print("Nhập biển số xe: ");
        car.setLicensePlate(scanner.nextLine());

        System.out.print("Nhập hãng sản xuất: ");
        car.setManufacturer(scanner.nextLine());

        System.out.print("Nhập năm sản xuất: ");
        car.setYearOfManufacture(Integer.parseInt(scanner.nextLine()));

        System.out.print("Nhập chủ sở hữu: ");
        car.setOwner(scanner.nextLine());

        System.out.print("Nhập số chỗ ngồi: ");
        car.setNumberOfSeats(Integer.parseInt(scanner.nextLine()));

        System.out.print("Nhập kiểu xe: ");
        car.setVehicleType(scanner.nextLine());

        System.out.println("=> Thêm mới thành công!");
        System.out.println("---------2----------------");

        return car;
    }

    public static Car editCar(Car car) {
        Car carEdit = new Car();
        carEdit.setLicensePlate(car.getLicensePlate()); // giữ nguyên biển số

        System.out.println("----- CẬP NHẬT Ô TÔ -----");
        System.out.println("Biển số: " + car.getLicensePlate());

        System.out.print("Hãng sản xuất (" + car.getManufacturer() + "): ");
        String manufacturer = scanner.nextLine();
        carEdit.setManufacturer(manufacturer.isEmpty() ? car.getManufacturer() : manufacturer);

        System.out.print("Năm sản xuất (" + car.getYearOfManufacture() + "): ");
        String yearInput = scanner.nextLine();
        carEdit.setYearOfManufacture(yearInput.isEmpty() ? car.getYearOfManufacture() : Integer.parseInt(yearInput));

        System.out.print("Chủ sở hữu (" + car.getOwner() + "): ");
        String owner = scanner.nextLine();
        carEdit.setOwner(owner.isEmpty() ? car.getOwner() : owner);

        System.out.print("Số chỗ ngồi (" + car.getNumberOfSeats() + "): ");
        String seatsInput = scanner.nextLine();
        carEdit.setNumberOfSeats(seatsInput.isEmpty() ? car.getNumberOfSeats() : Integer.parseInt(seatsInput));

        System.out.print("Kiểu xe (" + car.getVehicleType() + "): ");
        String type = scanner.nextLine();
        carEdit.setVehicleType(type.isEmpty() ? car.getVehicleType() : type);

        System.out.println("=> Cập nhật thành công!");
        System.out.println("-------------------------");

        return carEdit;
    }
}
