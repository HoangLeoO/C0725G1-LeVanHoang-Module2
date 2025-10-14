package entity;

public class KhachHangNuocNgoai extends KhachHang{
    private String quocTich;

    public KhachHangNuocNgoai() {
    }


    public KhachHangNuocNgoai(String maKhachHang, String hoTen, String quocTich) {
        super(maKhachHang, hoTen);
        this.quocTich = quocTich;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    @Override
    public String toString() {
        return super.toString() + "KhachHangNuocNgoai{" +
                "quocTich='" + quocTich + '\'' +
                '}';
    }
}
