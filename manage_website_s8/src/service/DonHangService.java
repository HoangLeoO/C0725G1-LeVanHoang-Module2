package service;

import entity.DonHang;
import repository.DonHangRepository;
import repository.IDonHangRepository;
import util.DonHangConverter;
import util.UserException;

import java.util.ArrayList;
import java.util.List;

public class DonHangService implements IDonHangService {

    private static final IDonHangRepository data = new DonHangRepository();
    private static List<DonHang> cache = new ArrayList<>();

    public DonHangService() {
        loadFromFile();
    }

    private void loadFromFile() {
        if (!cache.isEmpty()) return;
        List<String> lines = data.loadFromFile();
        for (String string : lines) {
//            try {
                cache.add(DonHangConverter.fromDataString(string));
//            } catch (Exception e) {
//
//            }
        }
        System.out.println("Dữ liệu  được nạp vào cache !");
    }

    private void saveCacheToFile() {
        List<String> lines = new ArrayList<>();
        for (DonHang donHang : cache) {
            lines.add(DonHangConverter.toDataString(donHang));
        }
        data.writeToFile(lines);
    }

    @Override
    public List<DonHang> findAll() {
        return cache;
    }

    @Override
    public List<DonHang> findByName(String name) {
        List<DonHang> result = new ArrayList<>();
        for (DonHang donHang : cache) {
            if (donHang.getKhachHang().toLowerCase().contains(name.toLowerCase())) {
                result.add(donHang);
            }
        }
        return result;
    }

    @Override
    public DonHang findByCode(String code) {
        for (DonHang donHang : cache) {
            if (donHang.getMaDonHang().equalsIgnoreCase(code.toLowerCase())) {
                return donHang;
            }
        }
        return null;
    }

    @Override
    public boolean addItem(DonHang item) {
        if (item == null) {
            return false;
        }
        cache.add(item);
        saveCacheToFile();
        return true;
    }

    @Override
    public boolean deleteItem(DonHang item) {
        if (item == null) {
            return false;
        }
        cache.remove(item);
        return true;
    }
}
