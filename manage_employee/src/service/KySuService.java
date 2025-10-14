package service;

import controller.KySuController;
import entity.KySu;
import repository.INhanSuRepository;
import repository.KySuRepository;

import java.util.ArrayList;
import java.util.List;

public class KySuService implements IKySuService{
    private static final INhanSuRepository<KySu> dataRepo = new KySuRepository();

    @Override
    public KySu findById(String id) {
        for (KySu kySu : findAll()) {
            if (kySu.getMaNhanVien().equals(id)) {
                return kySu;
            }
        }
        return null;
    }

    @Override
    public List<KySu> findAll() {
        return dataRepo.findAll();
    }

    @Override
    public boolean save(KySu kySu) {
        return dataRepo.save(kySu);
    }

    @Override
    public void update(KySu kySu) {
        int index = findAll().indexOf(findById(kySu.getMaNhanVien()));
        dataRepo.update(index, kySu);
    }

    @Override
    public boolean delete(KySu kySu) {
        return dataRepo.delete(kySu);
    }

    @Override
    public List<KySu> findAllSearch(String name) {
        List<KySu> lists = new ArrayList<>();
        for (KySu kySu : findAll()) {
            if (kySu.getHoTen().toLowerCase().contains(name.toLowerCase())) {
                lists.add(kySu);
            }
        }
        return lists;
    }
}
