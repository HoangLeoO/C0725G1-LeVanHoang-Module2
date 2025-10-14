package view;

import entity.*;
import util.InputUtil;
import util.CodeGenerator;

import java.util.List;
import java.util.Scanner;

public class NhanSuView {
    private static final Scanner sc = new Scanner(System.in);

    // ================= Hiển thị danh sách =================
    public static void showListCompact(List<NhanSu> items) {
        System.out.printf("%-10s %-20s %-10s %-15s %-30s%n",
                "Mã", "Họ tên", "Năm sinh", "Loại", "Thông tin riêng");

        for (NhanSu ns : items) {
            String loai;
            String thongTin = "";

            if (ns instanceof NhanVienVanPhong nv) {
                loai = "Văn phòng";
                thongTin = String.format("Ngày làm: %d | Hệ số: %.2f", nv.getSoNgayLamViec(), nv.getHeSoLuong());
            } else if (ns instanceof KySu ks) {
                loai = "Kỹ sư";
                thongTin = String.format("Chuyên ngành: %s | Bậc: %d", ks.getChuyenNganh(), ks.getBacKyThuat());
            } else if (ns instanceof NhanVienBanHang bh) {
                loai = "Bán hàng";
                thongTin = String.format("Doanh số: %.1f | Hoa hồng: %.1f%%", bh.getDoanhSo(), bh.getPhanTramHoaHong());
            } else {
                loai = "Không xác định";
            }

            System.out.printf("%-10s %-20s %-10d %-15s %-30s%n",
                    ns.getMaNhanVien(), ns.getHoTen(), ns.getNamSinh(), loai, thongTin);
        }
    }

    // ================= Nhập thông tin chung (Add) =================
    private static void nhapThongTinChung(NhanSu ns) {
        // Tự động sinh mã nếu add
        if (ns instanceof NhanVienVanPhong) {
            ns.setMaNhanVien(CodeGenerator.generateCode("VP"));
        } else if (ns instanceof KySu) {
            ns.setMaNhanVien(CodeGenerator.generateCode("KS"));
        } else if (ns instanceof NhanVienBanHang) {
            ns.setMaNhanVien(CodeGenerator.generateCode("BH"));
        }

        ns.setHoTen(InputUtil.inputName());
        ns.setNamSinh(InputUtil.inputYearOfBirth());
        ns.setSoDienThoai(InputUtil.inputPhone());
    }

    // ==================== Thêm nhân sự ====================
    public static NhanSu showAdd() {
        System.out.println("=== CHỌN LOẠI NHÂN SỰ ===");
        System.out.println("1. Nhân viên văn phòng");
        System.out.println("2. Kỹ sư");
        System.out.println("3. Nhân viên bán hàng");
        System.out.print("Lựa chọn: ");
        int choice = Integer.parseInt(sc.nextLine());

        return switch (choice) {
            case 1 -> addNhanVienVanPhong();
            case 2 -> addKySu();
            case 3 -> addNhanVienBanHang();
            default -> {
                System.out.println("Lựa chọn không hợp lệ.");
                yield null;
            }
        };
    }

    private static NhanVienVanPhong addNhanVienVanPhong() {
        NhanVienVanPhong nv = new NhanVienVanPhong();
        nhapThongTinChung(nv);
        nv.setSoNgayLamViec(InputUtil.inputWorkingDays());
        nv.setHeSoLuong(InputUtil.inputSalary());
        return nv;
    }

    private static KySu addKySu() {
        KySu ks = new KySu();
        nhapThongTinChung(ks);
        System.out.print("Nhập chuyên ngành: ");
        ks.setChuyenNganh(sc.nextLine());
        System.out.print("Nhập bậc kỹ thuật: ");
        ks.setBacKyThuat(Integer.parseInt(sc.nextLine()));
        return ks;
    }

    private static NhanVienBanHang addNhanVienBanHang() {
        NhanVienBanHang bh = new NhanVienBanHang();
        nhapThongTinChung(bh);
        bh.setDoanhSo(InputUtil.inputSales());
        System.out.print("Nhập phần trăm hoa hồng: ");
        bh.setPhanTramHoaHong(Double.parseDouble(sc.nextLine()));
        return bh;
    }

    // ==================== Cập nhật nhân sự ====================
    public static NhanSu showUpdate(NhanSu old) {
        System.out.println("=== CẬP NHẬT NHÂN SỰ ===");
        System.out.println("(Enter để giữ nguyên giá trị)");

        // Giữ nguyên mã, chỉ update các trường khác
        System.out.println("Mã nhân viên: " + old.getMaNhanVien());

        old.setHoTen(InputUtil.inputName(old.getHoTen()));
        old.setNamSinh(InputUtil.inputYearOfBirth(old.getNamSinh()));
        old.setSoDienThoai(InputUtil.inputPhone(old.getSoDienThoai()));

        if (old instanceof NhanVienVanPhong nv) {
            nv.setSoNgayLamViec(InputUtil.inputWorkingDays(nv.getSoNgayLamViec()));
            nv.setHeSoLuong(InputUtil.inputSalary(nv.getHeSoLuong()));
        } else if (old instanceof KySu ks) {
            System.out.print("Chuyên ngành hiện tại (" + ks.getChuyenNganh() + "): ");
            String cn = sc.nextLine();
            if (!cn.isEmpty()) ks.setChuyenNganh(cn);

            System.out.print("Bậc kỹ thuật hiện tại (" + ks.getBacKyThuat() + "): ");
            String bac = sc.nextLine();
            if (!bac.isEmpty()) ks.setBacKyThuat(Integer.parseInt(bac));
        } else if (old instanceof NhanVienBanHang bh) {
            bh.setDoanhSo(InputUtil.inputSales(bh.getDoanhSo()));

            System.out.print("Hoa hồng hiện tại (%): " + bh.getPhanTramHoaHong() + " → ");
            String hh = sc.nextLine();
            if (!hh.isEmpty()) bh.setPhanTramHoaHong(Double.parseDouble(hh));
        }

        System.out.println("Cập nhật thành công!");
        return old;
    }

    // ==================== Xóa nhân sự ====================
    public static boolean delete(String id) {
        System.out.println("Bạn có muốn xóa nhân viên mã: " + id + " ? (Y/N)");
        String check = sc.nextLine();
        return check.equalsIgnoreCase("Y");
    }
    // ==================== Nhập mã nhân viên ====================
    public static String inputCode() {
        return InputUtil.inputCode();
    }
    public static String inputName() {
        return sc.nextLine();
    }
}
