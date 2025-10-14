package controller;

import entity.KySu;
import entity.NhanVienBanHang;
import entity.NhanVienVanPhong;
import service.INhanSuService;
import service.NhanVienBanHangService;

import java.util.List;

public class NhanVienBanHangController {
    private static final INhanSuService<NhanVienBanHang> dataService = new NhanVienBanHangService();

    public static List<NhanVienBanHang> findAll() {
        return dataService.findAll();
    }

    public static boolean addNhanVien(NhanVienBanHang nhanVienBanHang) {
        return dataService.save(nhanVienBanHang);
    }

    public static void update(NhanVienBanHang nhanVienBanHang) {
        dataService.update(nhanVienBanHang);
    }

    public static boolean delete(NhanVienBanHang nhanVienBanHang) {
        return dataService.delete(nhanVienBanHang);
    }
    public static List<NhanVienBanHang> findByName(String name){
        return dataService.findAllSearch(name);
    }
    public static NhanVienBanHang findByCode(String code){
        return dataService.findById(code);
    }
}
