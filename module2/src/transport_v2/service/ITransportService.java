package transport_v2.service;

import transport_v2.entity.Transport;

public interface ITransportService {

    Transport[] findAllTransport();

    Transport findByLicensePlate(String licensePlate);

    void addTransport(Transport transport);

    void editTransport(Transport transport);

    void deleteTransport(String licensePlate);
}
