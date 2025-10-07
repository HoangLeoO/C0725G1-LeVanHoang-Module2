package service.facility;

import entity.facility.Facility;
import entity.facility.House;
import entity.facility.Room;
import entity.facility.Villa;
import repository.facility.FacilityRepository;
import repository.facility.IFacilityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FacilityService implements IFacilityService {
    private IFacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public void updateValueByKey(Facility facility) {
        facilityRepository.updateValueByKey(facility);
    }

    @Override
    public List<Facility> showMaintenanceList() {
        List<Facility> listResult = new ArrayList<>();
        for (Facility facility : facilityRepository.findAll()) {
            if (!facilityRepository.checkNumberUses(facility)) {
                listResult.add(facility);
            }
        }
        return listResult;
    }

    @Override
    public Facility findCode(String code) {
        return facilityRepository.findCode(code);
    }

    @Override
    public List<Facility> findAll() {

        return facilityRepository.findAll();
    }

    @Override
    public boolean add(Facility object) {
        List<Facility> facilityList = findAll();

        boolean check = true;
        Random random = new Random();

        if (object == null){
            return false;
        }
        while (check) {
            int number = random.nextInt(9000) + 1000;
            String prefix = "";

            if (object instanceof Villa) {
                prefix = "VL-";
            } else if (object instanceof House) {
                prefix = "HO-";
            } else if (object instanceof Room) {
                prefix = "RO-";
            }

            String newCode = prefix + number;
            boolean exists = false;

            // kiểm tra trùng mã
            for (Facility facility : facilityList) {
                if (facility.getServiceCode().equals(newCode)) {
                    exists = true;
                    break;
                }
            }

            // nếu không trùng thì dừng vòng lặp
            if (!exists) {
                object.setServiceCode(newCode);
                check = false;
            }
        }


        return facilityRepository.add(object);
    }

    @Override
    public void edit(Facility object) {
        facilityRepository.edit(object);
    }

    @Override
    public boolean deleteByCode(String code) {
        return false;
    }
}
