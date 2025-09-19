package transport.controller;


import transport.entity.Car;
import transport.entity.Motorbike;
import transport.entity.Transport;
import transport.entity.Truck;
import transport.service.TransportService;
import transport.view.CarView;
import transport.view.MotorbikeView;
import transport.view.TransportView;
import transport.view.TruckView;

import java.util.Scanner;

public class TransportController {
    static Scanner scanner = new Scanner(System.in);
    static TransportService transportService = new TransportService();

    public static void showMenu() {
        boolean running = true;

        while (running) {
            System.out.println("===== CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG =====");
            System.out.println("1. Thêm mới phương tiện");
            System.out.println("2. Hiển thị danh sách phương tiện");
            System.out.println("3. Xóa phương tiện");
            System.out.println("4. Thay đổi thông tin phương tiện");
            System.out.println("5. Thoát");
            System.out.print("=> Mời chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> showAddMenu();
                case 2 -> showDisplayMenu();
                case 3 -> showDeleteMenu();
                case 4 -> showEditMenu();
                case 5 -> {
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

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> CarController.addCar();
            case 2 -> MotorbikeController.addMotorbike();
            case 3 -> TruckController.addTruck();
            case 4 -> {
            }
        }
    }

    private static void showDisplayMenu() {
        System.out.println("----- HIỂN THỊ DANH SÁCH PHƯƠNG TIỆN -----");
        System.out.println("1. Hiển thị ô tô");
        System.out.println("2. Hiển thị xe máy");
        System.out.println("3. Hiển thị xe tải");
        System.out.println("4. Quay lại");
        System.out.print("=> Mời chọn: ");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> {
                CarController.showListCar();
            }
            case 2 -> {
                MotorbikeController.showListMotorbike();
            }
            case 3 -> {
                TruckController.showListTruck();
            }
            case 4 -> {
            }
        }
    }

    private static void showDeleteMenu() {
        String plate = TransportView.deleteTransport();
        Transport transport = transportService.findByLicensePlate(plate);

        if (transport == null) {
            System.out.println("Không tìm thấy phương tiện với biển số: " + plate);
            return;
        }

        if (!TransportView.confirmDelete(transport)) {
            System.out.println("Hủy thao tác xóa.");
            return;
        }

        if (transport instanceof Car) {
            CarController.carService.deleteTransport(transport.getLicensePlate());
        } else if (transport instanceof Motorbike) {
            MotorbikeController.motorbikeService.deleteTransport(transport.getLicensePlate());
        } else if (transport instanceof Truck) {
            TruckController.truckService.deleteTransport(transport.getLicensePlate());
        }

        System.out.println("=> Đã xóa phương tiện có biển số: " + plate);
    }


    private static void showEditMenu() {
        String plate = TransportView.editTransport();
        Transport transport = transportService.findByLicensePlate(plate);

        if (transport == null) {
            System.out.println("Không tìm thấy phương tiện với biển số: " + plate);
            return;
        }

//        if (!TransportView.confirmEdit(transport)) {
//            System.out.println("Hủy thao tác suawr.");
//            return;
//        }

        if (transport instanceof Car) {
            transportService.editTransport(CarView.editCar((Car) transport));
        } else if (transport instanceof Motorbike) {
            transportService.editTransport(MotorbikeView.editMotorbike((Motorbike) transport));
        } else if (transport instanceof Truck) {
            transportService.editTransport(TruckView.editTruck((Truck) transport));
        }

        System.out.println("=> Đã chỉnh sửa phương tiện có biển số: " + plate);
    }
}
