package controller;

import entity.HoaDon;
import entity.KhachHang;
import view.ViewHoaDon;
import view.ViewKhachHang;

import java.util.List;
import java.util.Scanner;

public class MenuController {
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        boolean running = true;
        while (running) {
            System.out.println(" Menu chức năng");
            System.out.println(" 1. Thêm mới khách hàng");
            System.out.println(" 2. Hiển thị thông tin khách hàng ");
            System.out.println(" 3. Tìm kiếm khách hàng");
            System.out.println(" 4. Thêm mới hóa đơn");
            System.out.println(" 5. Chỉnh sửa hóa đơn");
            System.out.println(" 6. Hiển thị thông tin chi tiết hóa đơn");
            System.out.println(" 7. Thoát");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    List<String> loaiKhachs = KhachHangController.danhSachLoaiKhach();
                    List<KhachHang> khachHangs = KhachHangController.danhSachKhachHang();
                    KhachHang khachHang = ViewKhachHang.hienThiThemKhachHang(loaiKhachs, khachHangs);
                    KhachHangController.themMoiKhachHang(khachHang);
                }
                case "2" -> {
                    ViewKhachHang.hienThiDanhSachKhachHang(KhachHangController.danhSachKhachHang());
                }
                case "3" -> {
                    String name = ViewKhachHang.timKiem();
                    ViewKhachHang.hienThiDanhSachKhachHang(KhachHangController.timKiemTheoTenKhachHang(name));
                }
                case "4" -> {
                    List<KhachHang> khachHangs = KhachHangController.danhSachKhachHang();
                    HoaDon hoaDon = ViewHoaDon.themHoaDon(khachHangs);
                    KhachHang khachHang = KhachHangController.timKiemBangMaKhachHang(hoaDon.getMaKhachHang());
                    double thanhTien = HoaDonController.thanhTien(khachHang, hoaDon.getSoLuong(), hoaDon.getDonGia());
                    hoaDon.setThanhTien(thanhTien);
                    HoaDonController.themHoaDon(hoaDon);
                }
                case "5" -> {
                    List<HoaDon> hoaDons = HoaDonController.danhSachHoaDon();
                    List<KhachHang> khachHangs = KhachHangController.danhSachKhachHang();
                    HoaDon hoaDon = ViewHoaDon.chinhSuaHoaDon(hoaDons, khachHangs);
                    HoaDonController.chinhSuaHoaDon(hoaDon);
                }
                case "6" -> {
                    List<HoaDon> hoaDons = HoaDonController.danhSachHoaDon();
                    ViewHoaDon.hienThiChiTietHoaDon(hoaDons);
                }
                case "7" -> {
                    running = false;
                }
                default -> {

                }
            }
        }
    }
}
