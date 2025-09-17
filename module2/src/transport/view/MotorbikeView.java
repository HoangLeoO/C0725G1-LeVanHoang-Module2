package transport.view;

import transport.entity.Motorbike;

import java.util.Scanner;

public class MotorbikeView {
    static Scanner scanner = new Scanner(System.in);

    public static void showAllMotorbike(Motorbike[] motorbikes) {
        boolean found = false;
        System.out.println("===== DANH SÁCH XE MÁY =====");
        for (Motorbike motorbike : motorbikes) {
            if (motorbike != null) {
                System.out.println(motorbike);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Danh sách xe máy trống!");
        }
        System.out.println("============================");
    }

    public static Motorbike addMotorbike() {
        Motorbike motorbike = new Motorbike();

        System.out.println("----- THÊM MỚI XE MÁY -----");
        System.out.print("Nhập biển số xe: ");
        motorbike.setLicensePlate(scanner.nextLine());

        System.out.print("Nhập hãng sản xuất: ");
        motorbike.setManufacturer(scanner.nextLine());

        System.out.print("Nhập năm sản xuất: ");
        motorbike.setYearOfManufacture(Integer.parseInt(scanner.nextLine()));

        System.out.print("Nhập chủ sở hữu: ");
        motorbike.setOwner(scanner.nextLine());

        System.out.print("Nhập công suất (cc): ");
        motorbike.setEnginePower(Integer.parseInt(scanner.nextLine()));

        System.out.println("=> Thêm mới thành công!");
        System.out.println("-------------------------");

        return motorbike;
    }

    public static Motorbike editMotorbike(Motorbike motorbike) {
        Motorbike motorbikeEdit = new Motorbike();
        motorbikeEdit.setLicensePlate(motorbike.getLicensePlate()); // giữ nguyên biển số

        System.out.println("----- CẬP NHẬT XE MÁY -----");
        System.out.println("Biển số: " + motorbike.getLicensePlate());

        System.out.print("Hãng sản xuất (" + motorbike.getManufacturer() + "): ");
        String manufacturer = scanner.nextLine();
        motorbikeEdit.setManufacturer(manufacturer.isEmpty() ? motorbike.getManufacturer() : manufacturer);

        System.out.print("Năm sản xuất (" + motorbike.getYearOfManufacture() + "): ");
        String yearInput = scanner.nextLine();
        motorbikeEdit.setYearOfManufacture(yearInput.isEmpty() ? motorbike.getYearOfManufacture() : Integer.parseInt(yearInput));

        System.out.print("Chủ sở hữu (" + motorbike.getOwner() + "): ");
        String owner = scanner.nextLine();
        motorbikeEdit.setOwner(owner.isEmpty() ? motorbike.getOwner() : owner);

        System.out.print("Công suất (cc) (" + motorbike.getEnginePower() + "): ");
        String capacityInput = scanner.nextLine();
        motorbikeEdit.setEnginePower(capacityInput.isEmpty() ? motorbike.getEnginePower() : Integer.parseInt(capacityInput));

        System.out.println("=> Cập nhật thành công!");
        System.out.println("-------------------------");

        return motorbikeEdit;
    }
}
