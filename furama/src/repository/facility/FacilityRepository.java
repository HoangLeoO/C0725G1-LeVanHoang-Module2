package repository.facility;

import entity.enums.RentalType;
import entity.facility.Facility;
import entity.facility.House;
import entity.facility.Room;
import entity.facility.Villa;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository {
    protected static Map<Facility, Integer> listFacility = new LinkedHashMap<>();

    static {
        // Villa
        listFacility.put(new Villa("VL-0001", "Villa Beach Front", 350.0, 500.0, 8, RentalType.DAY, "VIP", 50.0, 2), 4);
        listFacility.put(new Villa("VL-0002", "Villa Mountain View", 200.0, 300.0, 6, RentalType.MONTH, "Deluxe", 30.0, 1), 5);
        listFacility.put(new Villa("VL-0003", "Villa Garden", 250.0, 400.0, 10, RentalType.YEAR, "Standard", 40.0, 3), 0);

        // House
        listFacility.put(new House("HO-0001", "House Lake View", 120.0, 200.0, 4, RentalType.DAY, "Deluxe", 2), 0);
        listFacility.put(new House("HO-0002", "House City Center", 150.0, 250.0, 5, RentalType.MONTH, "Standard", 3), 5);

        // Room
        listFacility.put(new Room("RO-0001", "Room Single Bed", 30.0, 50.0, 2, RentalType.HOUR, "Free breakfast"), 0);
        listFacility.put(new Room("RO-0002", "Room Double Bed", 45.0, 80.0, 3, RentalType.DAY, "Free drinks"), 0);
    }


    @Override
    public Facility findCode(String code) {
        List<Facility> list = findAll();
        for (Facility facility : list) {
            if (facility.getServiceCode().equals(code)) {

                return facility;
            }
        }
        return null;
    }

    @Override
    public List<Facility> findAll() {
        return new ArrayList<>(listFacility.keySet());
    }

    @Override
    public boolean add(Facility object) {
        if (object != null) {
            listFacility.put(object, 0);
            return true;
        }
        return false;
    }

    @Override
    public void edit(Facility object) {
        listFacility.put(object, listFacility.get(object));
    }

    @Override
    public boolean deleteByCode(String code) {
        Facility facility = findCode(code);
        if (facility != null) {
            listFacility.remove(facility);
            return true;
        }
        return false;
    }


    @Override
    public void updateValueByKey(Facility facility) {
              listFacility.put(facility, listFacility.get(facility) + 1);
    }

    @Override
    public boolean checkNumberUses(Facility facility) {
        return listFacility.get(facility) != 5;
    }

    public Integer showValue(Facility facility){
        return listFacility.get(facility);
    }
}
