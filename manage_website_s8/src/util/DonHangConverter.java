package util;

import entity.DonHang;
import entity.DonHangDoDienTu;
import entity.DonHangQuanAo;
import entity.DonHangThucPham;

import java.time.LocalDate;

public class DonHangConverter {
    public static String toDataString(DonHang donHang) {
        if (donHang instanceof DonHangDoDienTu c) {
            return String.join(",",
                    "DoDienTu",
                    String.valueOf(c.getMaDonHang()),
                    c.getKhachHang(),
                    String.valueOf(c.getNgayDat()),
                    String.valueOf(c.getTongTien()),
                    String.valueOf(c.getThoiGianBaoHanh())
            );
        } else if (donHang instanceof DonHangQuanAo h) {
            return String.join(",",
                    "QuanAo",
                    String.valueOf(h.getMaDonHang()),
                    h.getKhachHang(),
                    String.valueOf(h.getNgayDat()),
                    String.valueOf(h.getTongTien()),
                    h.getSize(),
                    h.getChatLieu()
            );
        } else if (donHang instanceof DonHangThucPham b) {
            return String.join(",",
                    "ThucPham",
                    String.valueOf(b.getMaDonHang()),
                    b.getKhachHang(),
                    String.valueOf(b.getNgayDat()),
                    String.valueOf(b.getTongTien()),
                    String.valueOf(b.getHanSuDung())
            );
        } else {
            throw new IllegalArgumentException("Không có đơn hàng này : " + donHang.getClass());
        }
    }

    public static DonHang fromDataString(String line) {
        String[] parts = line.split(",");
        String type = parts[0];

        switch (type) {
            case "DoDienTu":
                return new DonHangDoDienTu(
                        parts[1],
                        parts[2],
                        LocalDate.parse(parts[3]),
                        Double.parseDouble(parts[4]),
                        Integer.parseInt(parts[5])
                );
            case "QuanAo":
                return new DonHangQuanAo(
                        parts[1],
                        parts[2],
                        LocalDate.parse(parts[3]),
                        Double.parseDouble(parts[4]),
                        parts[5],
                        parts[6]
                );
            case "ThucPham":
                return new DonHangThucPham(
                        parts[1],
                        parts[2],
                        LocalDate.parse(parts[3]),
                        Double.parseDouble(parts[4]),
                        LocalDate.parse(parts[5])
                );
            default:
                throw new IllegalArgumentException("Đơn hàng không hợp lệ: " + type);
        }
    }
}
