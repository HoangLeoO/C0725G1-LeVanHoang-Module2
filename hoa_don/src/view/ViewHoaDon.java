package view;

import entity.HoaDon;
import entity.KhachHang;
import entity.KhachHangNuocNgoai;
import entity.KhachHangVietNam;
import util.InputUtil;
import util.Validate;

import java.util.List;
import java.util.Scanner;

public class ViewHoaDon {
    private static final Scanner sc = new Scanner(System.in);

    public static void hienThiChiTietHoaDon(List<HoaDon> hoaDons) {
       String maHoaDon =  chonHoaDon(hoaDons,false);
       for (HoaDon hoaDon : hoaDons){
           if (hoaDon.getMaHoaDon().equalsIgnoreCase(maHoaDon)){
               System.out.println(hoaDon.toString());
           }
       }
    }

    public static HoaDon themHoaDon(List<KhachHang> khachHangs) {
        HoaDon hoaDon = new HoaDon();
        System.out.println("=== THÊM HÓA ĐƠN MỚI ===");

        hoaDon.setMaKhachHang(chonKhachHang(khachHangs, false));
        hoaDon.setNgayRaHoaDon(InputUtil.ngayTaoHoaDon());
        hoaDon.setSoLuong(InputUtil.soLuong());
        hoaDon.setDonGia(InputUtil.donGia());

        return hoaDon;
    }

    public static HoaDon chinhSuaHoaDon(List<HoaDon> hoaDons, List<KhachHang> khachHangs) {
        System.out.println("=== CHỈNH SỬA HÓA ĐƠN ===");

        String maHoaDon = chonHoaDon(hoaDons, true);
        if (maHoaDon.isBlank()) {
            System.out.println("Đã hủy chỉnh sửa.");
            return null;
        }
        HoaDon hoaDonCanSua = null;
        for (HoaDon h : hoaDons) {
            if (h.getMaHoaDon().equalsIgnoreCase(maHoaDon)) {
                hoaDonCanSua = h;
                break;
            }
        }
        System.out.println("Đang chỉnh sửa hóa đơn: " + maHoaDon);

        String maKH = chonKhachHang(khachHangs, true);
        if (!maKH.isBlank()) {
            hoaDonCanSua.setMaKhachHang(maKH);
        }
        hoaDonCanSua.setNgayRaHoaDon(InputUtil.ngayTaoHoaDon(hoaDonCanSua.getNgayRaHoaDon()));
        hoaDonCanSua.setSoLuong(InputUtil.soLuong(hoaDonCanSua.getSoLuong()));
        hoaDonCanSua.setDonGia(InputUtil.donGia(hoaDonCanSua.getDonGia()));

        System.out.println("Đã cập nhật hóa đơn thành công.");
        return hoaDonCanSua;
    }



    private static String chonKhachHang(List<KhachHang> khachHangs, boolean isUpdate) {
        System.out.println("=== DANH SÁCH KHÁCH HÀNG ===");

        int num = 0;
        for (KhachHang khachHang : khachHangs) {
            System.out.println(++num + " : " + khachHang);
        }
        String input;
        int choice;
        while (true) {
            System.out.print("Nhập lựa chọn (1 - " + khachHangs.size() + (isUpdate ? ", Enter để giữ nguyên): " : "): "));
            input = sc.nextLine().trim();
            if (isUpdate && input.isBlank()) {
                return "";
            }
            try {
                choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= khachHangs.size()) {
                    break;
                }
                System.out.println("Nhập số trong khoảng hợp lệ.");
            } catch (NumberFormatException e) {
                System.out.println("Nhập số nguyên hợp lệ.");
            }
        }
        return khachHangs.get(choice - 1).getMaKhachHang();
    }

    private static String chonHoaDon(List<HoaDon> hoaDons, boolean isUpdate) {
        System.out.println("=== DANH SÁCH HÓA ĐƠN ===");

        int num = 0;
        for (HoaDon hoaDon : hoaDons) {
            System.out.println(++num + " : " + hoaDon);
        }

        String input;
        int choice;

        while (true) {
            System.out.print("Nhập lựa chọn (1 - " + hoaDons.size() + (isUpdate ? ", Enter để hủy): " : "): "));
            input = sc.nextLine().trim();

            if (isUpdate && input.isBlank()) {
                return "";
            }

            try {
                choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= hoaDons.size()) {
                    break;
                }
                System.out.println("Nhập số trong khoảng hợp lệ.");
            } catch (NumberFormatException e) {
                System.out.println("Nhập số nguyên hợp lệ.");
            }
        }

        return hoaDons.get(choice - 1).getMaHoaDon();
    }


}
