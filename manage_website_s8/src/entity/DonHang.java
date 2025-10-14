package entity;

import java.time.LocalDate;

public class DonHang {
    private String maDonHang;     // Mã đơn hàng
    private String khachHang;     // Khách hàng
    private LocalDate ngayDat;    // Ngày đặt
    private double tongTien;      // Tổng tiền

    public DonHang() {}

    public DonHang(String maDonHang, String khachHang, LocalDate ngayDat, double tongTien) {
        this.maDonHang = maDonHang;
        this.khachHang = khachHang;
        this.ngayDat = ngayDat;
        this.tongTien = tongTien;
    }

    public String getMaDonHang() { return maDonHang; }
    public void setMaDonHang(String maDonHang) { this.maDonHang = maDonHang; }

    public String getKhachHang() { return khachHang; }
    public void setKhachHang(String khachHang) { this.khachHang = khachHang; }

    public LocalDate getNgayDat() { return ngayDat; }
    public void setNgayDat(LocalDate ngayDat) { this.ngayDat = ngayDat; }

    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }

    @Override
    public String toString() {
        return "DonHang{" +
                "maDonHang='" + maDonHang + '\'' +
                ", khachHang='" + khachHang + '\'' +
                ", ngayDat=" + ngayDat +
                ", tongTien=" + tongTien +
                '}';
    }
}
