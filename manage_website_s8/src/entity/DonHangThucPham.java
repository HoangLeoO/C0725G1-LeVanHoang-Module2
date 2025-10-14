package entity;

import java.time.LocalDate;

public class DonHangThucPham extends DonHang {
    private LocalDate hanSuDung;  // Hạn sử dụng

    public DonHangThucPham() {}

    public DonHangThucPham(String maDonHang, String khachHang, LocalDate ngayDat, double tongTien,
                           LocalDate hanSuDung) {
        super(maDonHang, khachHang, ngayDat, tongTien);
        this.hanSuDung = hanSuDung;
    }

    public LocalDate getHanSuDung() { return hanSuDung; }
    public void setHanSuDung(LocalDate hanSuDung) { this.hanSuDung = hanSuDung; }

    @Override
    public String toString() {
        return "DonHangThucPham{" +
                super.toString() +
                ", hanSuDung=" + hanSuDung +
                '}';
    }
}
