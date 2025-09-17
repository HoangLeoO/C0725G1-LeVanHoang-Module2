package transport.service;

import transport.entity.Truck;
import transport.repository.ITruckRepository;
import transport.repository.TruckRepository;

public class TruckService implements ITruckService{
    ITruckRepository truckRepository = new TruckRepository();

    @Override
    public Truck[] findAllTruck() {
        return truckRepository.findAllTruck();
    }

    @Override
    public Truck getTruckFindLicensePlate(String licensePlate) {
        return truckRepository.getTruckFindLicensePlate(licensePlate);
    }

    @Override
    public void addTruck(Truck truck) {
        truckRepository.addTruck(truck);
        System.out.println(" Thêm phương tiện mới có biển số xe " + truck.getLicensePlate() + "thành công !");

    }

    @Override
    public void editTruck(Truck truck) {
        truckRepository.editTruck(truck);
    }

    @Override
    public void deleteTruck(String licensePlate) {
        truckRepository.deleteTruck(licensePlate);
    }
}
