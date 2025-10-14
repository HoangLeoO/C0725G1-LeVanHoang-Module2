package View;

import entity.DonHang;
import entity.DonHangDoDienTu;
import entity.DonHangQuanAo;
import entity.DonHangThucPham;
import util.CodeGenerator;
import util.InputUtil;

import java.util.List;
import java.util.Scanner;

public class ViewDonHang {
    private static final Scanner sc = new Scanner(System.in);

    public static void showList(List<DonHang> items) {
        System.out.println("DANH SACH DON DIEN TU");
        for (DonHang dh : items) {
            if (dh instanceof DonHangDoDienTu dienTu) {
                System.out.println(dienTu.toString());
            }
        }
        System.out.println("DANH SACH DON QUAN AO");
        for (DonHang dh : items) {
            if (dh instanceof DonHangQuanAo dienTu) {
                System.out.println(dienTu.toString());
            }
        }
        System.out.println("DANH SACH DON THUC PHAM");
        for (DonHang dh : items) {
            if (dh instanceof DonHangThucPham dienTu) {
                System.out.println(dienTu.toString());
            }
        }
    }

    public static void formInput(DonHang ns){
        if (ns instanceof DonHangDoDienTu) {
            ns.setMaDonHang(CodeGenerator.generateCode("DT"));
        } else if (ns instanceof DonHangThucPham) {
            ns.setMaDonHang(CodeGenerator.generateCode("TP"));
        } else if (ns instanceof DonHangQuanAo) {
            ns.setMaDonHang(CodeGenerator.generateCode("QA"));
        }

        ns.setKhachHang(InputUtil.inputName());
        ns.setNgayDat(InputUtil.inputBirthday());
        ns.setTongTien(InputUtil.inputSalary());
    }

    public static DonHang showAdd() {
        System.out.println("=== THEM DON HANG ===");
        System.out.println("1. DON HANG DIEN TU");
        System.out.println("2. DON HANG QUAN AO");
        System.out.println("3. DON HANG THUC PHAM");
        System.out.print("Lựa chọn: ");
        int choice = Integer.parseInt(sc.nextLine());

        return switch (choice) {
            case 1 -> addDonHangDienTu();
            case 2 -> addDonHangQuanAo();
            case 3 -> addDonHangThucPham();
            default -> {
                System.out.println("Lựa chọn không hợp lệ.");
                yield null;
            }
        };
    }

    private static DonHangDoDienTu addDonHangDienTu() {
        DonHangDoDienTu nv = new DonHangDoDienTu();
        formInput(nv);
        nv.setThoiGianBaoHanh(InputUtil.inputMonth());
        System.out.println(nv.toString());
        return nv;
    }

    private static DonHangQuanAo addDonHangQuanAo() {
        DonHangQuanAo ks = new DonHangQuanAo();
        formInput(ks);
        System.out.print("Nhập size: ");
        ks.setSize(sc.nextLine());
        System.out.print("Nhập chấc liệu: ");
        ks.setChatLieu(sc.nextLine());
        return ks;
    }

    private static DonHangThucPham addDonHangThucPham() {
        DonHangThucPham bh = new DonHangThucPham();
        formInput(bh);
        bh.setHanSuDung(InputUtil.inputBirthday());
        return bh;
    }


    public static boolean delete(String id) {
        System.out.println("Bạn có muốn xóa đơn hàng mã: " + id + " ? (Y/N)");
        String check = sc.nextLine();
        return check.equalsIgnoreCase("Y");
    }

    public static String inputCode() {
        return InputUtil.inputCode();
    }
    public static String inputName() {
        return sc.nextLine();
    }
}
