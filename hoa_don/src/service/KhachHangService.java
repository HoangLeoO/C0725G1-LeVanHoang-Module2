package service;

import entity.KhachHang;
import repository.IKhachHangRepository;
import repository.KhachHangRepository;
import util.KhachHangConverter;


import java.util.ArrayList;
import java.util.List;

public class KhachHangService implements IKhachHangService {

    private static final IKhachHangRepository repo = new KhachHangRepository();
    private static List<KhachHang> du_lieu_dem = new ArrayList<>();
    private static List<String> loai_khach = new ArrayList<>();


    public KhachHangService() {
        loadFileLoaiKhach();
        loadFileKhachHang();
    }

    private void loadFileKhachHang() {
        if (!du_lieu_dem.isEmpty()) return;
        List<String> lines = repo.loadFromFile();
        for (String line : lines) {
            du_lieu_dem.add(KhachHangConverter.fromDataString(line));
        }
    }

    private void loadFileLoaiKhach() {
        if (!loai_khach.isEmpty()) return;
        List<String> lines = repo.loadFromType();

        for (String line : lines) {
            String[] parts = line.split(",");
            loai_khach.add(parts[1]);
        }
    }

    private void saveFile() {
        List<String> lines = new ArrayList<>();
        for (KhachHang khachHang : du_lieu_dem) {
            lines.add(KhachHangConverter.toDataString(khachHang));
        }
        repo.writeToFile(lines);
    }

    @Override
    public List<KhachHang> findByName(String name) {
        List<KhachHang> result = new ArrayList<>();
        for (KhachHang khachHang : du_lieu_dem) {
            if (khachHang.getHoTen().toLowerCase().contains(name.toLowerCase())) {
                result.add(khachHang);
            }
        }
        return result;
    }

    @Override
    public List<KhachHang> findAll() {
        return du_lieu_dem;
    }

    @Override
    public KhachHang findByCode(String code) {
        for (KhachHang khachHang : du_lieu_dem) {
            if (khachHang.getMaKhachHang().equalsIgnoreCase(code)) {
                return khachHang;
            }
        }
        return null;
    }

    @Override
    public boolean save(KhachHang item) {
        if (item == null) {
            return false;
        }
        du_lieu_dem.add(item);
        saveFile();
        return true;
    }

    @Override
    public List<String> findAllLoaiKhach() {
        return loai_khach;
    }
}
