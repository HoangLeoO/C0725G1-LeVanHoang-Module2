package entity;

public abstract class NhanSu {
    protected String maNhanVien;
    protected String hoTen;
    protected int namSinh;
    protected String soDienThoai;

    public NhanSu() {
    }

    public NhanSu(String maNhanVien, String hoTen, int namSinh, String soDienThoai) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.soDienThoai = soDienThoai;
    }

    // Phương thức trừu tượng tính lương (tuỳ từng loại nhân viên)
    public abstract double tinhLuong();

    // Hiển thị thông tin chung
    public void hienThiThongTin() {
        System.out.println("Mã NV: " + maNhanVien);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Năm sinh: " + namSinh);
        System.out.println("SĐT: " + soDienThoai);
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return "NhanSu{" +
                "maNhanVien='" + maNhanVien + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh=" + namSinh +
                ", soDienThoai='" + soDienThoai + '\'' +
                '}';
    }

    // Getter/Setter (có thể bổ sung khi cần)
}
