package controller;

import entity.KySu;
import entity.NhanSu;
import entity.NhanVienBanHang;
import entity.NhanVienVanPhong;
import view.NhanSuView;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NhanSuController {

    private static final Scanner sc = new Scanner(System.in);

    public static void showMenu() {
        boolean running = true;
        while (running) {
            System.out.println(" Chức năng quản lý nhân sự");
            System.out.println("1. Them");
            System.out.println("2. Hien thi");
            System.out.println("3. Xoa nhan su");
            System.out.println("4. Tim kiem");
            System.out.println("5Thoat");

            String choice = sc.nextLine();

            switch (choice){
                case "1" -> {
                    NhanSu nhanSu = NhanSuView.showAdd();
                    if (nhanSu instanceof NhanVienBanHang){
                        NhanVienBanHangController.addNhanVien((NhanVienBanHang) nhanSu);
                    }
                    if (nhanSu instanceof NhanVienVanPhong){
                        NhanVienVanPhongController.addNhanVien((NhanVienVanPhong) nhanSu);
                    }
                    if (nhanSu instanceof KySu){
                        KySuController.addNhanVien((KySu) nhanSu);
                    }
                }
                case "2" ->{
                    List<NhanSu> list = new ArrayList<>();
                    list.addAll(NhanVienBanHangController.findAll());
                    list.addAll(NhanVienVanPhongController.findAll());
                    list.addAll(KySuController.findAll());
                    System.out.println("\n=== DANH SÁCH NHÂN SỰ ===");
                    NhanSuView.showListCompact(list);
                }
                case "3" -> {
                    String code = NhanSuView.inputCode();
                    NhanSuController.deleteByCode(code);
                }
                case "4" -> {
                    String code = NhanSuView.inputName();
                    List<NhanSu> nhanSuList = findAllSearch(code);
                    System.out.println("\n=== DANH SÁCH TÌM KIẾM ===");
                    NhanSuView.showListCompact(nhanSuList);
                }
                case "5" -> {
                    running = false;
                }
                default -> {
                    System.out.println(" Khong co chuc nang nay!");
                }
            }

        }
    }

    public static List<NhanSu> findAllSearch(String name) {

        List<NhanSu> nhanSuList = new ArrayList<>();
        nhanSuList.addAll(KySuController.findByName(name));
        nhanSuList.addAll(NhanVienBanHangController.findByName(name));
        nhanSuList.addAll(NhanVienVanPhongController.findByName(name));

        return nhanSuList;
    }

    public static NhanSu findByCode(String code) {
        NhanSu ns = KySuController.findByCode(code);
        if (ns != null) return ns;

        ns = NhanVienBanHangController.findByCode(code);
        if (ns != null) return ns;

        ns = NhanVienVanPhongController.findByCode(code);
        return ns;
    }
    public static boolean deleteByCode(String code) {
        NhanSu ns = findByCode(code);
        if (ns == null) {
            System.out.println("Không tìm thấy nhân sự có mã: " + code);
            return false;
        }

        if (!NhanSuView.delete(code)) {
            System.out.println("Hủy thao tác xóa.");
            return false;
        }

        if (ns instanceof KySu) {
            return KySuController.delete((KySu) ns);
        } else if (ns instanceof NhanVienBanHang) {
            return NhanVienBanHangController.delete((NhanVienBanHang) ns);
        } else if (ns instanceof NhanVienVanPhong) {
            return NhanVienVanPhongController.delete((NhanVienVanPhong) ns);
        }

        System.out.println("Loại nhân sự không xác định!");
        return false;
    }
}
