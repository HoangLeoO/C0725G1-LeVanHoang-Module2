package entity;

public class KhachHangVietNam extends KhachHang{
    private String loaiKhachHang;
    private double dinhMucTieuThu;

    public KhachHangVietNam() {
    }

    public KhachHangVietNam(String maKhachHang, String hoTen, String loaiKhachHang, double dinhMucTieuThu) {
        super(maKhachHang, hoTen);
        this.loaiKhachHang = loaiKhachHang;
        this.dinhMucTieuThu = dinhMucTieuThu;
    }

    public String getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(String loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    public double getDinhMucTieuThu() {
        return dinhMucTieuThu;
    }

    public void setDinhMucTieuThu(double dinhMucTieuThu) {
        this.dinhMucTieuThu = dinhMucTieuThu;
    }

    @Override
    public String toString() {
        return super.toString() + "KhachHangVietNam{" +
                "loaiKhachHang='" + loaiKhachHang + '\'' +
                ", dinhMucTieuThu=" + dinhMucTieuThu +
                '}';
    }


}
