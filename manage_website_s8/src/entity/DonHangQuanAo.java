package entity;

import entity.DonHang;

import java.time.LocalDate;

public class DonHangQuanAo extends DonHang {
    private String size;       // Size
    private String chatLieu;   // Chất liệu

    public DonHangQuanAo() {}

    public DonHangQuanAo(String maDonHang, String khachHang, LocalDate ngayDat, double tongTien,
                         String size, String chatLieu) {
        super(maDonHang, khachHang, ngayDat, tongTien);
        this.size = size;
        this.chatLieu = chatLieu;
    }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getChatLieu() { return chatLieu; }
    public void setChatLieu(String chatLieu) { this.chatLieu = chatLieu; }

    @Override
    public String toString() {
        return "DonHangQuanAo{" +
                super.toString() +
                ", size='" + size + '\'' +
                ", chatLieu='" + chatLieu + '\'' +
                '}';
    }
}
