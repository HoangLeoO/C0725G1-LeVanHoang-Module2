package transport.repository;

import transport.entity.Transport;

public interface ITransportRepository {
    Transport findByLicensePlate(String licensePlate);
}
