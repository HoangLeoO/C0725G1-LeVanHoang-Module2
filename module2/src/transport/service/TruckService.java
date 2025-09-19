package transport.service;


import transport.entity.Transport;
import transport.repository.ITruckRepository;
import transport.repository.TruckRepository;

public class TruckService implements ITruckService {
    ITruckRepository truckRepository = new TruckRepository();

    @Override
    public Transport[] findAllTransport() {
        return truckRepository.findAllTransport();
    }

    @Override
    public Transport findByLicensePlate(String licensePlate) {
        return truckRepository.findByLicensePlate(licensePlate);
    }

    @Override
    public void addTransport(Transport transport) {
        truckRepository.addTransport(transport);
    }

    @Override
    public void editTransport(Transport transport) {
        truckRepository.editTransport(transport);
    }

    @Override
    public void deleteTransport(String licensePlate) {
        truckRepository.deleteTransport(licensePlate);
    }
}
