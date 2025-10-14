package service;

import entity.HoaDon;

import repository.HoaDonRepository;
import repository.IHoaDonRepository;
import util.HoaDonConverter;


import java.util.ArrayList;
import java.util.List;

public class HoaDonService implements IHoaDonService {

    private static final IHoaDonRepository repo = new HoaDonRepository();
    private static List<HoaDon> du_lieu_dem = new ArrayList<>();

    public HoaDonService() {
        loadFile();
    }

    private void loadFile() {
        if (!du_lieu_dem.isEmpty()) return;
        List<String> lines = repo.loadFromFile();
        for (String line : lines) {
            du_lieu_dem.add(HoaDonConverter.fromDataString(line));
        }
    }

    private void saveFile() {
        List<String> lines = new ArrayList<>();
        for (HoaDon hoaDon : du_lieu_dem) {
            lines.add(HoaDonConverter.toDataString(hoaDon));
        }
        repo.writeToFile(lines);
    }


    @Override
    public boolean update(HoaDon hoaDon) {
        if (hoaDon == null || hoaDon.getMaHoaDon() == null) return false;

        for (HoaDon hoaDon1 : du_lieu_dem) {
            if (hoaDon.getMaHoaDon().equalsIgnoreCase(hoaDon1.getMaHoaDon())) {
                hoaDon1.setMaKhachHang(hoaDon.getMaKhachHang());
                hoaDon1.setNgayRaHoaDon(hoaDon.getNgayRaHoaDon());
                hoaDon1.setSoLuong(hoaDon.getSoLuong());
                hoaDon1.setDonGia(hoaDon.getDonGia());
                hoaDon1.setThanhTien(hoaDon.getThanhTien());
                saveFile();
                return true;
            }
        }
        return false;
    }

    @Override
    public List<HoaDon> findAll() {
        return du_lieu_dem;
    }

    @Override
    public HoaDon findByCode(String code) {
        for (HoaDon hoaDon : du_lieu_dem) {
            if (hoaDon.getMaHoaDon().equalsIgnoreCase(code)) {
                return hoaDon;
            }
        }
        return null;
    }

    @Override
    public boolean save(HoaDon item) {
        item.setMaHoaDon(taoMaHoaDonTuDong(du_lieu_dem));
        du_lieu_dem.add(item);
        saveFile();
        return false;
    }

    private static String taoMaHoaDonTuDong(List<HoaDon> danhSach) {
        String str = "MHD";
        int max = 0;
        for (HoaDon hd : danhSach) {
            String ma = hd.getMaHoaDon();
            if (ma != null && ma.startsWith(str)) {
                try {
                    int so = Integer.parseInt(ma.substring(str.length()));
                    if (so > max) {
                        max = so;
                    }
                } catch (NumberFormatException ignored) {

                }
            }
        }
        int next = max + 1;
        return String.format("%s%03d", str, next);
    }
}
