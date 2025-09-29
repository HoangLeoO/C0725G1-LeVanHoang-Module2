package transport.controller;

import transport.entity.Car;
import transport.entity.Motorbike;
import transport.entity.Truck;
import transport.view.CarView;
import transport.view.MotorbikeView;
import transport.view.TransportView;
import transport.view.TruckView;

import java.util.Scanner;

public class TransportController {
    static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        boolean running = true;

        while (running) {
            System.out.println("===== CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG =====");
            System.out.println("1. Thêm mới phương tiện");
            System.out.println("2. Hiển thị danh sách phương tiện");
            System.out.println("3. Xóa phương tiện");
            System.out.println("4. Thay đổi thông tin phương tiện");
            System.out.println("5. Tìm kiếm thông tin phương tiện");
            System.out.println("6. Thoát");
            System.out.print("=> Mời chọn chức năng: ");

            String choice = scanner.nextLine().trim(); // đọc String

            switch (choice) {
                case "1" -> showAddMenu();
                case "2" -> showDisplayMenu();
                case "3" -> showDeleteMenu();
                case "4" -> showEditMenu();
                case "5" -> showSearchMenu();
                case "6" -> {
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    running = false;
                }
                default -> System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }

    private static void showAddMenu() {
        System.out.println("----- THÊM MỚI PHƯƠNG TIỆN -----");
        System.out.println("1. Thêm ô tô");
        System.out.println("2. Thêm xe máy");
        System.out.println("3. Thêm xe tải");
        System.out.println("4. Quay lại");
        System.out.print("=> Mời chọn: ");

        String choice = scanner.nextLine().trim();
        switch (choice) {
            case "1" -> CarController.addCar();
            case "2" -> MotorbikeController.addMotorbike();
            case "3" -> TruckController.addTruck();
            case "4" -> {
            }
            default -> System.out.println("=> Lựa chọn không hợp lệ!");
        }
    }

    private static void showDisplayMenu() {
        System.out.println("----- HIỂN THỊ DANH SÁCH PHƯƠNG TIỆN -----");
        System.out.println("1. Hiển thị ô tô");
        System.out.println("2. Hiển thị xe máy");
        System.out.println("3. Hiển thị xe tải");
        System.out.println("4. Quay lại");
        System.out.print("=> Mời chọn: ");

        String choice = scanner.nextLine().trim();
        switch (choice) {
            case "1" -> CarController.showListCar();
            case "2" -> MotorbikeController.showListMotorbike();
            case "3" -> TruckController.showListTruck();
            case "4" -> {
            }
            default -> System.out.println("=> Lựa chọn không hợp lệ!");
        }
    }

    private static void showDeleteMenu() {
        System.out.println("----- XÓA PHƯƠNG TIỆN -----");
        String plate = TransportView.deleteTransport();

        Car car = CarController.searchCar(plate);
        Truck truck = TruckController.searchTruck(plate);
        Motorbike motorbike = MotorbikeController.searchMotorbike(plate);

        if (car != null) {
            if (TransportView.confirmDelete(car)) {
                CarController.deleteCar(plate);
                System.out.println("=> Đã xóa Ô TÔ có biển số: " + plate);
            } else {
                System.out.println("=> Hủy thao tác xóa.");
            }
        } else if (truck != null) {
            if (TransportView.confirmDelete(truck)) {
                TruckController.deleteTruck(plate);
                System.out.println("=> Đã xóa XE TẢI có biển số: " + plate);
            } else {
                System.out.println("=> Hủy thao tác xóa.");
            }
        } else if (motorbike != null) {
            if (TransportView.confirmDelete(motorbike)) {
                MotorbikeController.deleteMotorbike(plate);
                System.out.println("=> Đã xóa XE MÁY có biển số: " + plate);
            } else {
                System.out.println("=> Hủy thao tác xóa.");
            }
        } else {
            System.out.println("=> Không tìm thấy phương tiện có biển số: " + plate);
        }
    }

    private static void showEditMenu() {
        String plate = TransportView.editTransport();

        Car car = CarController.searchCar(plate);
        Truck truck = TruckController.searchTruck(plate);
        Motorbike motorbike = MotorbikeController.searchMotorbike(plate);

        if (car != null) {
            Car editedCar = CarView.editCar(car);
            CarController.editCar(editedCar);
            System.out.println("=> Đã chỉnh sửa Ô TÔ có biển số: " + plate);
        } else if (truck != null) {
            Truck editedTruck = TruckView.editTruck(truck);
            TruckController.editTruck(editedTruck);
            System.out.println("=> Đã chỉnh sửa XE TẢI có biển số: " + plate);
        } else if (motorbike != null) {
            Motorbike editedMotorbike = MotorbikeView.editMotorbike(motorbike);
            MotorbikeController.editMotorbike(editedMotorbike);
            System.out.println("=> Đã chỉnh sửa XE MÁY có biển số: " + plate);
        } else {
            System.out.println("=> Không tìm thấy phương tiện có biển số: " + plate);
        }
    }

    private static void showSearchMenu() {
        System.out.println("----- TÌM KIẾM PHƯƠNG TIỆN -----");
        String plate = TransportView.searchTransport();

        Car car = CarController.searchCar(plate);
        Truck truck = TruckController.searchTruck(plate);
        Motorbike motorbike = MotorbikeController.searchMotorbike(plate);

        if (car != null) {
            System.out.println("=> Tìm thấy Ô TÔ:");
            System.out.println(car);
        } else if (truck != null) {
            System.out.println("=> Tìm thấy XE TẢI:");
            System.out.println(truck);
        } else if (motorbike != null) {
            System.out.println("=> Tìm thấy XE MÁY:");
            System.out.println(motorbike);
        } else {
            System.out.println("=> Không tìm thấy phương tiện có biển số: " + plate);
        }
    }
}
