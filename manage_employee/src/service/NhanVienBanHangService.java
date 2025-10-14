package service;

import entity.KySu;
import entity.NhanVienBanHang;
import entity.NhanVienVanPhong;
import repository.INhanSuRepository;
import repository.NhanVienBanHangRepository;

import java.util.ArrayList;
import java.util.List;

public class NhanVienBanHangService implements INhanVienBanHangService{
    private static final INhanSuRepository<NhanVienBanHang> dataRepo = new NhanVienBanHangRepository();

    @Override
    public NhanVienBanHang findById(String id) {
        for (NhanVienBanHang nhanVienBanHang : findAll()) {
            if (nhanVienBanHang.getMaNhanVien().equals(id)) {
                return nhanVienBanHang;
            }
        }
        return null;
    }

    @Override
    public List<NhanVienBanHang> findAll() {
        return dataRepo.findAll();
    }

    @Override
    public boolean save(NhanVienBanHang nhanVienBanHang) {
        return dataRepo.save(nhanVienBanHang);
    }

    @Override
    public void update(NhanVienBanHang nhanVienBanHang) {
        int index = findAll().indexOf(findById(nhanVienBanHang.getMaNhanVien()));
        dataRepo.update(index, nhanVienBanHang);
    }

    @Override
    public boolean delete(NhanVienBanHang nhanVienBanHang) {
        return dataRepo.delete(nhanVienBanHang);
    }

    @Override
    public List<NhanVienBanHang> findAllSearch(String name) {
        List<NhanVienBanHang> lists = new ArrayList<>();
        for (NhanVienBanHang kySu : findAll()) {
            if (kySu.getHoTen().toLowerCase().contains(name.toLowerCase())) {
                lists.add(kySu);
            }
        }
        return lists;
    }
}
