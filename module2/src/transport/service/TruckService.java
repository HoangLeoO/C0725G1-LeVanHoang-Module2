package transport.service;


import transport.entity.Truck;
import transport.repository.ITruckRepository;
import transport.repository.TruckRepository;

import java.util.List;

public class TruckService implements ITruckService {
    private ITruckRepository truckRepository = new TruckRepository();

    @Override
    public List<Truck> findAllTransport() {
        return truckRepository.findAllTransport();
    }

    @Override
    public Truck findByLicensePlate(String licensePlate) {
        return truckRepository.findByLicensePlate(licensePlate);
    }

    @Override
    public void addTransport(Truck object) {
        truckRepository.addTransport(object);
    }

    @Override
    public void editTransport(Truck object) {
        truckRepository.editTransport(object);
    }

    @Override
    public void deleteTransport(String licensePlate) {
        truckRepository.deleteTransport(licensePlate);
    }
}
