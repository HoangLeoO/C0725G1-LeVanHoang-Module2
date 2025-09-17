package transport.view;

import transport.entity.Truck;

import java.util.Scanner;

public class TruckView {
    static Scanner scanner = new Scanner(System.in);

    public static void showAllTruck(Truck[] trucks) {
        boolean found = false;
        System.out.println("===== DANH SÁCH XE TẢI =====");
        for (Truck truck : trucks) {
            if (truck != null) {
                System.out.println(truck);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Danh sách xe tải trống!");
        }
        System.out.println("============================");
    }

    public static Truck addTruck() {
        Truck truck = new Truck();

        System.out.println("----- THÊM MỚI XE TẢI -----");
        System.out.print("Nhập biển số xe: ");
        truck.setLicensePlate(scanner.nextLine());

        System.out.print("Nhập hãng sản xuất: ");
        truck.setManufacturer(scanner.nextLine());

        System.out.print("Nhập năm sản xuất: ");
        truck.setYearOfManufacture(Integer.parseInt(scanner.nextLine()));

        System.out.print("Nhập chủ sở hữu: ");
        truck.setOwner(scanner.nextLine());

        System.out.print("Nhập trọng tải (tấn): ");
        truck.setPayloadCapacity(Double.parseDouble(scanner.nextLine()));

        System.out.println("=> Thêm mới thành công!");
        System.out.println("-------------------------");

        return truck;
    }

    public static Truck editTruck(Truck truck) {
        Truck truckEdit = new Truck();
        truckEdit.setLicensePlate(truck.getLicensePlate()); // giữ nguyên biển số

        System.out.println("----- CẬP NHẬT XE TẢI -----");
        System.out.println("Biển số: " + truck.getLicensePlate());

        System.out.print("Hãng sản xuất (" + truck.getManufacturer() + "): ");
        String manufacturer = scanner.nextLine();
        truckEdit.setManufacturer(manufacturer.isEmpty() ? truck.getManufacturer() : manufacturer);

        System.out.print("Năm sản xuất (" + truck.getYearOfManufacture() + "): ");
        String yearInput = scanner.nextLine();
        truckEdit.setYearOfManufacture(yearInput.isEmpty() ? truck.getYearOfManufacture() : Integer.parseInt(yearInput));

        System.out.print("Chủ sở hữu (" + truck.getOwner() + "): ");
        String owner = scanner.nextLine();
        truckEdit.setOwner(owner.isEmpty() ? truck.getOwner() : owner);

        System.out.print("Trọng tải (tấn) (" + truck.getPayloadCapacity() + "): ");
        String payloadInput = scanner.nextLine();
        truckEdit.setPayloadCapacity(payloadInput.isEmpty() ? truck.getPayloadCapacity() : Double.parseDouble(payloadInput));

        System.out.println("=> Cập nhật thành công!");
        System.out.println("-------------------------");

        return truckEdit;
    }
}
