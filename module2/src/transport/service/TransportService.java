package transport.service;

import transport.entity.Transport;
import transport.repository.ITransportRepository;
import transport.repository.TransportRepository;

public class TransportService implements ITransportService {
    ITransportRepository transportRepository = new TransportRepository();
    @Override
    public Transport findByLicensePlate(String licensePlate) {
        return transportRepository.findByLicensePlate(licensePlate);
    }
}
