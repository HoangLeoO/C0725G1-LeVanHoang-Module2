package entity;

public abstract class KhachHang {
    private String maKhachHang;
    private String hoTen;


    public KhachHang() {
    }

    public KhachHang(String maKhachHang, String hoTen) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "maKhachHang='" + maKhachHang + '\'' +
                ", hoTen='" + hoTen + '\'' +
                '}';
    }
}
