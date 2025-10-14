package controller;

import entity.HoaDon;
import entity.KhachHang;
import entity.KhachHangNuocNgoai;
import entity.KhachHangVietNam;
import service.HoaDonService;
import service.IHoaDonService;
import util.InputUtil;

import java.util.List;

public class HoaDonController {
    private static IHoaDonService hoaDonService = new HoaDonService();

    public static List<HoaDon> danhSachHoaDon() {
        return hoaDonService.findAll();
    }

    public static boolean themHoaDon(HoaDon hoaDon) {
        if (hoaDon != null) {
            hoaDonService.save(hoaDon);
            return true;
        } else {
            return false;
        }
    }

    public static boolean chinhSuaHoaDon(HoaDon hoaDon) {
        if (hoaDon != null) {
            hoaDonService.update(hoaDon);
            System.out.println("Chỉnh sửa thành công!");
            return true;
        } else {
            System.out.println("Chỉnh sửa không thành công!");
            return false;
        }
    }

    public static HoaDon chiTietHoaDon(String code) {
        HoaDon hoaDon = hoaDonService.findByCode(code);
        if (hoaDon == null) {
            System.out.println(" Không tìm thấy thông tin hóa đơn! ");
        }
        return hoaDon;
    }

    public static double thanhTien(KhachHang khachHang, double soLuong, double donGia) {
        if (khachHang instanceof KhachHangVietNam) {
            return InputUtil.thanhTienVietNam(soLuong, donGia, ((KhachHangVietNam) khachHang).getDinhMucTieuThu());
        }
        if (khachHang instanceof KhachHangNuocNgoai) {
            return InputUtil.thanhTienNuocNgoai(soLuong, donGia);
        }
        return 0;
    }

}
