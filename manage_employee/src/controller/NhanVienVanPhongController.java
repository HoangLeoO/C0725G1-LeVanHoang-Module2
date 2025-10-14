package controller;

import entity.KySu;
import entity.NhanVienBanHang;
import entity.NhanVienVanPhong;
import service.INhanSuService;
import service.INhanVienVanPhongService;
import service.NhanVienVanPhongService;

import java.util.List;

public class NhanVienVanPhongController {

    private static final INhanSuService<NhanVienVanPhong> dataService = new NhanVienVanPhongService();

    public static List<NhanVienVanPhong> findAll() {
        return dataService.findAll();
    }

    public static boolean addNhanVien(NhanVienVanPhong nhanVienVanPhong) {
        return dataService.save(nhanVienVanPhong);
    }

    public static void update(NhanVienVanPhong nhanVienVanPhong) {
        dataService.update(nhanVienVanPhong);
    }

    public static boolean delete(NhanVienVanPhong nhanVienVanPhong) {
        return dataService.delete(nhanVienVanPhong);
    }

    public static List<NhanVienVanPhong> findByName(String name){
        return dataService.findAllSearch(name);
    }
    public static NhanVienVanPhong findByCode(String code){
        return dataService.findById(code);
    }


}
