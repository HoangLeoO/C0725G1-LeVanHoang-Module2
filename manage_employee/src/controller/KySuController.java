package controller;

import entity.KySu;

import service.INhanSuService;
import service.KySuService;

import java.util.List;

public class KySuController {
    private static final INhanSuService<KySu> dataService = new KySuService();

    public static List<KySu> findAll() {
        return dataService.findAll();
    }

    public static boolean addNhanVien(KySu kySu) {
        return dataService.save(kySu);
    }

    public static void update(KySu kySu) {
        dataService.update(kySu);
    }

    public static boolean delete(KySu kySu) {
        return dataService.delete(kySu);
    }

    public static List<KySu> findByName(String name){
        return dataService.findAllSearch(name);
    }
    public static KySu findByCode(String code){
        return dataService.findById(code);
    }

}
