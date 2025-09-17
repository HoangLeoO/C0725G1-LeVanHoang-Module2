package transport.service;

import transport.entity.Transport;

public interface ITransportService {
    Transport findByLicensePlate(String licensePlate);
}
