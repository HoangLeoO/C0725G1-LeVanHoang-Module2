package entity;

public class NhanVienVanPhong extends NhanSu {
    private int soNgayLamViec;
    private double heSoLuong;

    public NhanVienVanPhong(String maNhanVien, String hoTen, int namSinh, String soDienThoai,
                            int soNgayLamViec, double heSoLuong) {
        super(maNhanVien, hoTen, namSinh, soDienThoai);
        this.soNgayLamViec = soNgayLamViec;
        this.heSoLuong = heSoLuong;
    }

    public NhanVienVanPhong() {
    }

    @Override
    public double tinhLuong() {
        return soNgayLamViec * heSoLuong * 100_000; // Ví dụ mỗi ngày 100k * hệ số
    }

    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Số ngày làm việc: " + soNgayLamViec);
        System.out.println("Hệ số lương: " + heSoLuong);
        System.out.println("Lương: " + tinhLuong());
    }

    @Override
    public String toString() {
        return "NhanVienVanPhong{" +
                "soNgayLamViec=" + soNgayLamViec +
                ", heSoLuong=" + heSoLuong +
                ", maNhanVien='" + maNhanVien + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh=" + namSinh +
                ", soDienThoai='" + soDienThoai + '\'' +
                '}';
    }
}
