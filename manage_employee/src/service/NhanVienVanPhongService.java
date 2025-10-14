package service;

import entity.NhanVienBanHang;
import entity.NhanVienVanPhong;
import repository.INhanSuRepository;
import repository.NhanVienVanPhongRepository;

import java.util.ArrayList;
import java.util.List;

public class NhanVienVanPhongService implements INhanVienVanPhongService {

    private static final INhanSuRepository<NhanVienVanPhong> nhanVienVanPhongRepository = new NhanVienVanPhongRepository();

    @Override
    public NhanVienVanPhong findById(String id) {
        for (NhanVienVanPhong nhanVienVanPhong : findAll()) {
            if (nhanVienVanPhong.getMaNhanVien().equals(id)) {
                return nhanVienVanPhong;
            }
        }
        return null;
    }

    @Override
    public List<NhanVienVanPhong> findAll() {
        return nhanVienVanPhongRepository.findAll();
    }

    @Override
    public boolean save(NhanVienVanPhong nhanVienVanPhong) {
        return nhanVienVanPhongRepository.save(nhanVienVanPhong);
    }

    @Override
    public void update(NhanVienVanPhong nhanVienVanPhong) {
        int index = findAll().indexOf(findById(nhanVienVanPhong.getMaNhanVien()));
        nhanVienVanPhongRepository.update(index, nhanVienVanPhong);
    }

    @Override
    public boolean delete(NhanVienVanPhong nhanVienVanPhong) {
        return nhanVienVanPhongRepository.delete(nhanVienVanPhong);
    }

    @Override
    public List<NhanVienVanPhong> findAllSearch(String name) {
        List<NhanVienVanPhong> lists = new ArrayList<>();
        for (NhanVienVanPhong kySu : findAll()) {
            if (kySu.getHoTen().toLowerCase().contains(name.toLowerCase())) {
                lists.add(kySu);
            }
        }
        return lists;
    }
}
