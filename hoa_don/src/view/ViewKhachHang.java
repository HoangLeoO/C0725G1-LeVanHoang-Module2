package view;

import entity.KhachHang;
import entity.KhachHangNuocNgoai;
import entity.KhachHangVietNam;
import util.InputUtil;

import java.util.List;
import java.util.Scanner;

public class ViewKhachHang {
    private static final Scanner sc = new Scanner(System.in);

    public static void hienThiDanhSachKhachHang(List<KhachHang> items) {
        System.out.println("=== DANH SÁCH KHÁCH HÀNG VIỆT NAM ===");
        for (KhachHang kh : items) {
            if (kh instanceof KhachHangVietNam vn) {
                System.out.println(vn.toString());
            }
        }
        System.out.println("=== DANH SÁCH KHÁCH HÀNG NƯỚC NGOÀI ===");
        for (KhachHang kh : items) {
            if (kh instanceof KhachHangNuocNgoai nn) {
                System.out.println(nn.toString());
            }
        }
    }


    public static KhachHang hienThiThemKhachHang(List<String> list, List<KhachHang> khachHangList) {
        while (true) {
            System.out.println("=== THÊM KHÁCH HÀNG ===");
            System.out.println("1. Khách hàng Việt Nam");
            System.out.println("2. Khách hàng nước ngoài");
            System.out.println("3. Quay lại.");
            System.out.print("Lựa chọn: ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: {
                        return nhapThongTinKhachHangVietNam(list, khachHangList);
                    }
                    case 2: {
                        return nhapThongTinKhachHangNuocNgoai(khachHangList);
                    }
                    case 3: {
                        return null;
                    }
                    default: {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên.");
            }
        }
    }

    private static void nhapThongTinChung(KhachHang kh, List<KhachHang> list) {
        do {
            if (kh instanceof KhachHangVietNam) {
                kh.setMaKhachHang(InputUtil.nhapMaKhachVietNam());
            } else if (kh instanceof KhachHangNuocNgoai) {
                kh.setMaKhachHang(InputUtil.nhapMaKhachNuocNgoai());
            }
            if (maDaTonTai(kh.getMaKhachHang(), list)) {
                System.out.println("Mã đã tồn tại!");
            }
        } while (maDaTonTai(kh.getMaKhachHang(), list));

        kh.setHoTen(InputUtil.nhapHoTen());
    }

    private static KhachHangVietNam nhapThongTinKhachHangVietNam(List<String> loaiKhachs, List<KhachHang> khachHangList) {
        KhachHangVietNam khachHangVietNam = new KhachHangVietNam();
        nhapThongTinChung(khachHangVietNam, khachHangList);
        khachHangVietNam.setLoaiKhachHang(chonLoaiKhachHang(loaiKhachs));
        khachHangVietNam.setDinhMucTieuThu(InputUtil.dinhMucTieuThu());
        return khachHangVietNam;
    }

    private static KhachHangNuocNgoai nhapThongTinKhachHangNuocNgoai(List<KhachHang> khachHangList) {
        KhachHangNuocNgoai khachHangNuocNgoai = new KhachHangNuocNgoai();
        nhapThongTinChung(khachHangNuocNgoai, khachHangList);
        System.out.println("Nhập quốc tịch : ");
        khachHangNuocNgoai.setQuocTich(sc.nextLine());
        return khachHangNuocNgoai;
    }

    private static String chonLoaiKhachHang(List<String> list) {
        System.out.println("Chọn loại khách hàng:");

        int num = 0;
        for (String string : list) {
            System.out.println(++num + " : " + string);
        }

        int choice = -1;
        while (true) {
            System.out.print("Nhập lựa chọn (1 - " + list.size() + "): ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= list.size()) {
                    break;
                } else {
                    System.out.println("Vui lòng nhập số trong khoảng hợp lệ.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên.");
            }
        }

        return list.get(choice - 1);
    }

    public static String timKiem() {
        return InputUtil.nhapTenTimKiem();
    }

    private static boolean maDaTonTai(String code, List<KhachHang> khachHangList) {
        if (khachHangList.isEmpty()) {
            return false;
        }
        for (KhachHang khachHang : khachHangList) {
            if (khachHang.getMaKhachHang().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }
}
