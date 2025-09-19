package transport.service;


import transport.entity.Truck;

import java.util.List;

public class TruckService implements ITruckService {

    @Override
    public List<Truck> findAllTransport() {
        return List.of();
    }

    @Override
    public Truck findByLicensePlate(String licensePlate) {
        return null;
    }

    @Override
    public void addTransport(Truck object) {

    }

    @Override
    public void editTransport(Truck object) {

    }

    @Override
    public void deleteTransport(String licensePlate) {

    }
}
