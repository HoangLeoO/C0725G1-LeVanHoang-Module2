package transport.service;


import transport.entity.Transport;
import transport.repository.ITransportRepository;
import transport.repository.TransportRepository;

public class TransportService implements ITransportService {
    ITransportRepository transportRepository = new TransportRepository();

    @Override
    public Transport[] findAllTransport() {
        return transportRepository.findAllTransport();
    }

    @Override
    public Transport findByLicensePlate(String licensePlate) {
        return transportRepository.findByLicensePlate(licensePlate);
    }

    @Override
    public void addTransport(Transport transport) {
        transportRepository.addTransport(transport);
    }

    @Override
    public void editTransport(Transport transport) {
        transportRepository.editTransport(transport);
    }

    @Override
    public void deleteTransport(String licensePlate) {
        transportRepository.deleteTransport(licensePlate);
    }
}
