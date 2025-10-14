package util;


import entity.KhachHang;
import entity.KhachHangNuocNgoai;
import entity.KhachHangVietNam;


public class KhachHangConverter {
    public static String toDataString(KhachHang khachHang) {
        if (khachHang instanceof KhachHangVietNam vn) {
            return String.join(",",
                    "KHVN",
                    vn.getMaKhachHang(),
                    vn.getHoTen(),
                    vn.getLoaiKhachHang(),
                    String.valueOf(vn.getDinhMucTieuThu())
                    );
        } else if (khachHang instanceof KhachHangNuocNgoai nn) {
            return String.join(",",
                    "KHNN",
                    nn.getMaKhachHang(),
                    nn.getHoTen(),
                    nn.getQuocTich()
            );
        } else {
            throw new IllegalArgumentException(" Lỗi chuyển đổi đối tượng sang string!");
        }
    }

    public static KhachHang fromDataString(String line) {
        String[] parts = line.split(",");
        String type = parts[0];

        switch (type) {
            case "KHVN":
                return new KhachHangVietNam(
                        parts[1],
                        parts[2],
                        parts[3],
                        Double.parseDouble(parts[4])
                );
            case "KHNN":
                return new KhachHangNuocNgoai(
                        parts[1],
                        parts[2],
                        parts[3]
                );
            default:
                throw new IllegalArgumentException("Lỗi chuyển đổi file sang đối tượng");
        }
    }
}
