package transport.view.repository;

import transport.view.entity.Car;
import transport.view.entity.Motorbike;
import transport.view.entity.Transport;
import transport.view.entity.Truck;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TransportRepository implements ITransportRepository<Transport, String> {

    static final List<Transport> transports = new ArrayList<>();

    static {
        transports.add(new Car("OTO-001", "Toyota", 2019, "Nguyễn Văn A", 7, "Oto"));
        transports.add(new Car("OTO-002", "Huyndai", 2010, "Nguyễn Văn B", 45, "Oto"));
        transports.add(new Car("OTO-003", "Toyota", 2020, "Nguyễn Văn D", 16, "Oto"));
        transports.add(new Motorbike("MOTO-001", "Toyota", 2019, "Nguyễn Văn A", 120));
        transports.add(new Motorbike("MOTO-002", "Huyndai", 2010, "Nguyễn Văn B", 60));
        transports.add(new Truck("TRUCK-001", "Toyota", 2019, "Nguyễn Văn A", 10));
        transports.add(new Truck("TRUCK-002", "Huyndai", 2010, "Nguyễn Văn B", 5));
    }


    @Override
    public List<Transport> findAllTransport() {
        return transports;
    }

    @Override
    public Transport findByLicensePlate(String licensePlate) {
        for (Transport transport : transports) {
            if (transport != null && Objects.equals(transport.getLicensePlate(), licensePlate)) {
                return transport;
            }
        }
        return null;
    }

    @Override
    public void addTransport(Transport transport) {
        transports.add(transport);
    }

    @Override
    public void editTransport(Transport transport) {
        for (int i = 0; i < transports.size(); i++) {
            if (Objects.equals(transports.get(i).getLicensePlate(), transport.getLicensePlate())) {
                transports.get(i).updateFrom(transport);
                return;
            }
        }
    }

    @Override
    public void deleteTransport(String licensePlate) {
        for (Transport transport : transports) {
            if (transport != null) {
                if (Objects.equals(transport.getLicensePlate(), licensePlate)) {
                    transports.remove(transport);
                }
            }
        }
    }
}
