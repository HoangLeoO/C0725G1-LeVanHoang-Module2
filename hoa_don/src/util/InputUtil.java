package util;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtil {
    private static final Scanner sc = new Scanner(System.in);


    public static String nhapMaKhachVietNam() {
        return nhapMaKhachVietNam(null);
    }

    public static String nhapMaKhachVietNam(String oldValue) {
        String code;
        do {
            System.out.print("Nhập mã khách hàng Việt Nam (KHVN-XXXXX)" + (oldValue != null ? " (" + oldValue + ")" : "") + ": ");
            code = sc.nextLine().trim();
            if (oldValue != null && code.isEmpty()) {
                return oldValue;
            }
            if (!code.matches(Validate.CODE_VN)) {
                System.out.println("Mã  khách hàng Việt Nam không hợp lệ! ");
            } else break;
        } while (true);
        return code;
    }

    public static String nhapMaKhachNuocNgoai() {
        return nhapMaKhachNuocNgoai(null);
    }

    public static String nhapMaKhachNuocNgoai(String oldValue) {
        String code;
        do {
            System.out.print("Nhập mã khách hàng nước ngoài (KHNN-XXXXX)" + (oldValue != null ? " (" + oldValue + ")" : "") + ": ");
            code = sc.nextLine().trim();
            if (oldValue != null && code.isEmpty()) {
                return oldValue;
            }
            if (!code.matches(Validate.CODE_NN)) {
                System.out.println("Mã  khách hàng nước ngoài không hợp lệ!");
            } else break;
        } while (true);
        return code;
    }

    public static String nhapHoTen() {
        return nhapHoTen(null);
    }

    public static String nhapHoTen(String oldValue) {
        String name;
        do {
            System.out.print("Nhập họ tên" + (oldValue != null ? " (" + oldValue + ")" : "") + ": ");
            name = sc.nextLine().trim();
            if (oldValue != null && name.isEmpty()) {
                return oldValue;
            }
            if (!name.matches(Validate.FULL_NAME)) {
                System.out.println("Tên không hợp lệ! Ít nhất 2 từ, mỗi từ bắt đầu bằng chữ hoa, có thể có dấu tiếng Việt.");
            } else break;
        } while (true);
        return name;
    }


    public static double dinhMucTieuThu() {
        return dinhMucTieuThu(0);
    }

    public static double dinhMucTieuThu(double oldValue) {
        double salary;
        do {
            System.out.print("Nhập định mức tiêu thụ" + (oldValue != 0 ? " (" + oldValue + ")" : "") + ": ");
            String line = sc.nextLine().trim();
            if (oldValue != 0 && line.isEmpty()) {
                return oldValue;
            }
            try {
                salary = Double.parseDouble(line);
                if (salary <= 0) {
                    System.out.println("định mức tiêu thụ lớn hơn 0!");
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        } while (true);
        return salary;
    }

    public static double soLuong() {
        return soLuong(0);
    }

    public static double soLuong(double oldValue) {
        double salary;
        do {
            System.out.print("Nhập số lượng(số KW tiêu thụ)" + (oldValue != 0 ? " (" + oldValue + ")" : "") + ": ");
            String line = sc.nextLine().trim();
            if (oldValue != 0 && line.isEmpty()) {
                return oldValue;
            }
            try {
                salary = Double.parseDouble(line);
                if (salary <= 0) {
                    System.out.println("số lượng lớn hơn 0!");
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        } while (true);
        return salary;
    }

    public static double donGia() {
        return donGia(0);
    }

    public static double donGia(double oldValue) {
        double salary;
        do {
            System.out.print("Nhập đơn giá" + (oldValue != 0 ? " (" + oldValue + ")" : "") + ": ");
            String line = sc.nextLine().trim();
            if (oldValue != 0 && line.isEmpty()) {
                return oldValue;
            }
            try {
                salary = Double.parseDouble(line);
                if (salary <= 0) {
                    System.out.println("đơn giá lớn hơn 0!");
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        } while (true);
        return salary;
    }

    public static String nhapTenTimKiem() {
        System.out.println("Nhập tên khách hàng cần tìm:");
        return sc.nextLine();
    }

    public static LocalDate ngayTaoHoaDon() {
        return ngayTaoHoaDon(null);
    }

    public static LocalDate ngayTaoHoaDon(LocalDate oldValue) {
        LocalDate date;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();
        LocalDate minDate = LocalDate.of(2000, 1, 1); // ngày tối thiểu cho phép

        do {
            System.out.print("Nhập ngày tạo hóa đơn (dd/MM/yyyy)"
                    + (oldValue != null ? " (" + oldValue.format(formatter) + ")" : "") + ": ");
            String line = sc.nextLine().trim();

            // Nếu cập nhật mà người dùng bỏ trống => giữ giá trị cũ
            if (oldValue != null && line.isEmpty()) {
                return oldValue;
            }

            try {
                date = LocalDate.parse(line, formatter);

                if (date.isBefore(minDate)) {
                    System.out.println("Ngày không hợp lệ! Không được trước năm 2000.");
                } else if (date.isAfter(today)) {
                    System.out.println("Ngày không hợp lệ! Không thể lớn hơn ngày hiện tại.");
                } else {
                    break;
                }

            } catch (DateTimeParseException e) {
                System.out.println("Vui lòng nhập đúng định dạng dd/MM/yyyy!");
            }

        } while (true);

        return date;
    }
    public static double thanhTienVietNam(double soLuong, double donGia, double dinhMucTieuThu) {
        if (soLuong <= dinhMucTieuThu) {
            return soLuong * donGia;
        } else {
            double vuot = soLuong - dinhMucTieuThu;
            return (dinhMucTieuThu * donGia) + (vuot * donGia * 2.5);
        }
    }

    public static double thanhTienNuocNgoai(double soLuong, double donGia) {
        return soLuong * donGia;
    }
}
