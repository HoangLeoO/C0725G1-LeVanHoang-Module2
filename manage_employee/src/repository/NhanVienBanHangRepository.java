package repository;

import entity.NhanVienBanHang;
import entity.NhanVienVanPhong;

import java.util.ArrayList;
import java.util.List;

public class NhanVienBanHangRepository implements INhanVienBanHangRepository{

    private static final List<NhanVienBanHang> listData = new ArrayList<>();

    static {


        listData.add(new NhanVienBanHang("BH001", "Nguyen Van An", 1990, "0909123456", 250_000_000, 5.0));
        listData.add(new NhanVienBanHang("BH002", "Tran Thi Bich", 1995, "0912345678", 300_000_000, 6.5));
        listData.add(new NhanVienBanHang("BH003", "Le Van Cuong", 1988, "0932123456", 180_000_000, 4.0));
        listData.add(new NhanVienBanHang("BH004", "Pham Thi Dao", 1993, "0987654321", 400_000_000, 7.0));
        listData.add(new NhanVienBanHang("BH005", "Bui Van Hieu", 1998, "0978123456", 150_000_000, 3.5));

    }
    @Override
    public List<NhanVienBanHang> findAll() {
        return listData;
    }

    @Override
    public boolean save(NhanVienBanHang nhanVienBanHang) {
        return listData.add(nhanVienBanHang);
    }

    @Override
    public void update(int index, NhanVienBanHang nhanVienBanHang) {
        listData.set(index, nhanVienBanHang);
    }

    @Override
    public boolean delete(NhanVienBanHang nhanVienBanHang) {
        return listData.remove(nhanVienBanHang);
    }
}
