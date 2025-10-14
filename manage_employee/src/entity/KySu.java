package entity;

public class KySu extends NhanSu {
    private String chuyenNganh;
    private int bacKyThuat;

    public KySu() {
    }

    public KySu(String maNhanVien, String hoTen, int namSinh, String soDienThoai,
                String chuyenNganh, int bacKyThuat) {
        super(maNhanVien, hoTen, namSinh, soDienThoai);
        this.chuyenNganh = chuyenNganh;
        this.bacKyThuat = bacKyThuat;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public int getBacKyThuat() {
        return bacKyThuat;
    }

    public void setBacKyThuat(int bacKyThuat) {
        this.bacKyThuat = bacKyThuat;
    }

    @Override
    public double tinhLuong() {
        return bacKyThuat * 2_000_000; // Ví dụ: mỗi bậc kỹ thuật 2 triệu
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Chuyên ngành: " + chuyenNganh);
        System.out.println("Bậc kỹ thuật: " + bacKyThuat);
        System.out.println("Lương: " + tinhLuong());
    }

    @Override
    public String toString() {
        return "KySu{" +
                "chuyenNganh='" + chuyenNganh + '\'' +
                ", bacKyThuat=" + bacKyThuat +
                ", maNhanVien='" + maNhanVien + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh=" + namSinh +
                ", soDienThoai='" + soDienThoai + '\'' +
                '}';
    }
}
