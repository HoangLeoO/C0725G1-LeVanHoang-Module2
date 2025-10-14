package repository;

import entity.KySu;
import entity.NhanVienBanHang;

import java.util.ArrayList;
import java.util.List;

public class KySuRepository implements IKySuRepository{
    private static final List<KySu> listData = new ArrayList<>();

    static {
        listData.add(new KySu("KS001", "Nguyễn Văn Hùng", 1988, "0912345678", "Cơ khí", 3));
        listData.add(new KySu("KS002", "Trần Thị Lan", 1990, "0934567890", "Điện tử", 4));
        listData.add(new KySu("KS003", "Phạm Minh Đức", 1992, "0987654321", "Xây dựng", 2));
        listData.add(new KySu("KS004", "Vũ Anh Tuấn", 1985, "0909876543", "Công nghệ thông tin", 5));
        listData.add(new KySu("KS005", "Lê Hồng Phúc", 1993, "0977123456", "Cơ điện tử", 3));
    }
    @Override
    public List<KySu> findAll() {
        return listData;
    }

    @Override
    public boolean save(KySu kySu) {
        return listData.add(kySu);
    }

    @Override
    public void update(int index, KySu kySu) {
        listData.set(index,kySu);
    }

    @Override
    public boolean delete(KySu kySu) {
        return listData.remove(kySu);
    }
}
