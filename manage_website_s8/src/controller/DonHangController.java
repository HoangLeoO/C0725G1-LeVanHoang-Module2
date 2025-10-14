package controller;

import View.ViewDonHang;
import entity.DonHang;
import service.DonHangService;
import service.IDonHangService;

import java.util.Scanner;

public class DonHangController {
    private static IDonHangService donHangService = new DonHangService();

    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        boolean running = true;
        while (running) {
            System.out.println(" Menu chức năng");
            System.out.println(" 1. Thêm ");
            System.out.println(" 2. Hiển ");
            System.out.println(" 3. Xóa  bằng mã số");
            System.out.println(" 4. Tìm kiếm  gần đúng tên");
            System.out.println(" 5. Thoát");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    donHangService.addItem(ViewDonHang.showAdd());
                }
                case "2" -> {
                    ViewDonHang.showList(donHangService.findAll());
                }
                case "3" -> {
                    System.out.println(" Nhap ma don hang");
                    String code = scanner.nextLine();
                    if (ViewDonHang.delete(code)){
                        donHangService.deleteItem(donHangService.findByCode(code));
                    }
                }
                case "4" -> {
                    System.out.println(" Nhập tên  bạn muốn tìm!");
                    String name = scanner.nextLine();
                    ViewDonHang.showList(donHangService.findByName(name));
                }
                case "5" -> {
                    running = false;
                }
                default -> {

                }
            }
        }
    }
}
