package entity;

import java.time.LocalDate;

public class DonHangDoDienTu extends DonHang {
    private int thoiGianBaoHanh;  // Thời gian bảo hành (tháng)

    public DonHangDoDienTu() {}

    public DonHangDoDienTu(String maDonHang, String khachHang, LocalDate ngayDat, double tongTien,
                           int thoiGianBaoHanh) {
        super(maDonHang, khachHang, ngayDat, tongTien);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public int getThoiGianBaoHanh() { return thoiGianBaoHanh; }
    public void setThoiGianBaoHanh(int thoiGianBaoHanh) { this.thoiGianBaoHanh = thoiGianBaoHanh; }

    @Override
    public String toString() {
        return "DonHangDoDienTu{" +
                super.toString() +
                ", thoiGianBaoHanh=" + thoiGianBaoHanh +
                '}';
    }
}
