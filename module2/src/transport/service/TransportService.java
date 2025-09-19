package transport.service;


import transport.entity.Transport;
import transport.repository.TransportRepository;

import java.util.List;

public class TransportService implements ITransportService<Transport,String> {
    TransportRepository transportRepository = new TransportRepository();
    @Override
    public List<Transport> findAllTransport() {
        return transportRepository.findAllTransport();
    }

    @Override
    public Transport findByLicensePlate(String licensePlate) {
        return transportRepository.findByLicensePlate(licensePlate);
    }

    @Override
    public void addTransport(Transport object) {
        transportRepository.addTransport(object);
    }

    @Override
    public void editTransport(Transport object) {
        transportRepository.editTransport(object);
    }

    @Override
    public void deleteTransport(String licensePlate) {
        transportRepository.deleteTransport(licensePlate);
    }
}
