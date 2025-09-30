package repository.Facility;

import entity.facility.Villa;

import java.util.List;

public class VillaRepository implements IVillaRepository {
    @Override
    public Villa findCode(String code) {
        return null;
    }

    @Override
    public List<Villa> findAll() {
        return List.of();
    }

    @Override
    public boolean add(Villa villa) {
        return true;
    }

    @Override
    public void edit(Villa object) {

    }

    @Override
    public boolean deleteByCode(String code) {
        return false;
    }

}