package transport.service;

import transport.entity.Truck;

public interface ITruckService {
    Truck[] findAllTruck();

    Truck getTruckFindLicensePlate(String licensePlate);

    void addTruck(Truck truck);

    void editTruck(Truck truck);

    void deleteTruck(String licensePlate);
}
