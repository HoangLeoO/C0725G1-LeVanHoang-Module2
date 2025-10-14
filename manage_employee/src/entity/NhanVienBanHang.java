package entity;

public class NhanVienBanHang extends NhanSu {
    private double doanhSo;
    private double phanTramHoaHong;

    public NhanVienBanHang(String maNhanVien, String hoTen, int namSinh, String soDienThoai,
                           double doanhSo, double phanTramHoaHong) {
        super(maNhanVien, hoTen, namSinh, soDienThoai);
        this.doanhSo = doanhSo;
        this.phanTramHoaHong = phanTramHoaHong;
    }

    public NhanVienBanHang() {
    }

    public double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public double getPhanTramHoaHong() {
        return phanTramHoaHong;
    }

    public void setPhanTramHoaHong(double phanTramHoaHong) {
        this.phanTramHoaHong = phanTramHoaHong;
    }

    @Override
    public double tinhLuong() {
        return doanhSo * phanTramHoaHong / 100;
    }


    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Doanh số: " + doanhSo);
        System.out.println("Phần trăm hoa hồng: " + phanTramHoaHong + "%");
        System.out.println("Lương: " + tinhLuong());
    }

    @Override
    public String toString() {
        return "NhanVienBanHang{" +
                "doanhSo=" + doanhSo +
                ", phanTramHoaHong=" + phanTramHoaHong +
                ", maNhanVien='" + maNhanVien + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh=" + namSinh +
                ", soDienThoai='" + soDienThoai + '\'' +
                '}';
    }
}
