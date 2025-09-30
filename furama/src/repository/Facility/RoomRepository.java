package repository.Facility;

import entity.facility.Room;

import java.util.List;

public class RoomRepository implements IRoomRepository{
    @Override
    public Room findCode(String code) {
        return null;
    }

    @Override
    public List<Room> findAll() {
        return List.of();
    }

    @Override
    public boolean add(Room object) {
        return false;
    }

    @Override
    public void edit(Room object) {

    }

    @Override
    public boolean deleteByCode(String code) {
        return false;
    }
}
