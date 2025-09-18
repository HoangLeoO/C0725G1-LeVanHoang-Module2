package transport_v2.repository;


import transport_v2.entity.Transport;

public interface ITransportRepository {

    Transport[] findAllTransport();

    Transport findByLicensePlate(String licensePlate);

    void addTransport(Transport transport);

    void editTransport(Transport transport);

    void deleteTransport(String licensePlate);
}
