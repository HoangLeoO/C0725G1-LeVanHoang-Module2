package controller;

import entity.KhachHang;
import service.IKhachHangService;
import service.KhachHangService;

import java.util.ArrayList;
import java.util.List;


public class KhachHangController {
    private static IKhachHangService khachHangService = new KhachHangService();

    public static List<KhachHang> danhSachKhachHang() {
        return khachHangService.findAll();
    }

    public static List<String> danhSachLoaiKhach() {
        return khachHangService.findAllLoaiKhach();
    }

    public static boolean themMoiKhachHang(KhachHang khachHang) {
        if (khachHangService.save(khachHang)) {
            System.out.println("Thêm mới thành công!");
            return true;
        } else {
            System.out.println("Thêm mới không thành công");
            return false;
        }
    }


    public static List<KhachHang> timKiemTheoTenKhachHang(String name) {
        List<KhachHang> khachHangList = khachHangService.findByName(name);
        if (khachHangList.isEmpty()) {
            System.out.println(" Không tìm thấy khách hàng!");
        }
        return khachHangList;
    }
    public static KhachHang timKiemBangMaKhachHang(String code) {
       return khachHangService.findByCode(code);
    }
}
