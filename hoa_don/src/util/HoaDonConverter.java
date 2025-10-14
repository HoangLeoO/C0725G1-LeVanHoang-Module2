package util;

import entity.HoaDon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HoaDonConverter {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String toDataString(HoaDon hoaDon) {
        return String.join(",",
                hoaDon.getMaHoaDon(),
                hoaDon.getMaKhachHang(),
                hoaDon.getNgayRaHoaDon().format(formatter),
                String.valueOf(hoaDon.getSoLuong()),
                String.valueOf(hoaDon.getDonGia()),
                String.valueOf(hoaDon.getThanhTien())
        );
    }

    public static HoaDon fromDataString(String line) {
        String[] parts = line.split(",");

        return new HoaDon(
                parts[0],
                parts[1],
                LocalDate.parse(parts[2],formatter),
                Double.parseDouble(parts[3]),
                Double.parseDouble(parts[4]),
                Double.parseDouble(parts[5])
        );
    }
}
