package repository.Facility;

import entity.facility.House;

import java.util.List;

public class HouseRepository implements IHouseRepository{
    @Override
    public House findCode(String code) {
        return null;
    }

    @Override
    public List<House> findAll() {
        return List.of();
    }

    @Override
    public boolean add(House object) {
        return false;
    }

    @Override
    public void edit(House object) {

    }

    @Override
    public boolean deleteByCode(String code) {
        return false;
    }
}
