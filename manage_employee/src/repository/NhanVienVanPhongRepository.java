package repository;

import entity.NhanVienVanPhong;

import java.util.ArrayList;
import java.util.List;

public class NhanVienVanPhongRepository implements INhanVienVanPhongRepository {

    private static final List<NhanVienVanPhong> listData = new ArrayList<>();

    static {
        listData.add(new NhanVienVanPhong("VP001", "Nguyễn Thị Mai", 1995, "0911111111", 22, 2.0));
        listData.add(new NhanVienVanPhong("VP002", "Lê Văn Quang", 1990, "0922222222", 25, 2.5));
        listData.add(new NhanVienVanPhong("VP003", "Trần Thu Trang", 1987, "0933333333", 20, 1.8));
        listData.add(new NhanVienVanPhong("VP004", "Phạm Ngọc Duy", 1996, "0944444444", 26, 2.3));
        listData.add(new NhanVienVanPhong("VP005", "Vũ Thị Hồng", 1991, "0955555555", 23, 2.1));
    }

    @Override
    public List<NhanVienVanPhong> findAll() {
        return listData;
    }

    @Override
    public boolean save(NhanVienVanPhong nhanVienVanPhong) {
        return listData.add(nhanVienVanPhong);
    }

    @Override
    public void update(int index, NhanVienVanPhong nhanVienVanPhong) {
        listData.set(index, nhanVienVanPhong);
    }

    @Override
    public boolean delete(NhanVienVanPhong nhanVienVanPhong) {
        return listData.remove(nhanVienVanPhong);
    }
}
