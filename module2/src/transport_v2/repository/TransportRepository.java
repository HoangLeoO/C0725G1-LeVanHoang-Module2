package transport_v2.repository;

import transport_v2.entity.Car;
import transport_v2.entity.Motorbike;
import transport_v2.entity.Transport;
import transport_v2.entity.Truck;

import java.util.Objects;

public class TransportRepository implements ITransportRepository {

    public static Transport[] transports = new Transport[100];


    static {
        transports[0] = new Car("OTO-001", "Toyota", 2019, "Nguyễn Văn A", 7, "Oto");
        transports[1] = new Car("OTO-002", "Huyndai", 2010, "Nguyễn Văn B", 45, "Oto");
        transports[2] = new Car("OTO-003", "Toyota", 2020, "Nguyễn Văn D", 16, "Oto");
        transports[3] = new Motorbike("MOTO-001", "Toyota", 2019, "Nguyễn Văn A", 120);
        transports[4] = new Motorbike("MOTO-002", "Huyndai", 2010, "Nguyễn Văn B", 60);
        transports[5] = new Truck("TRUCK-001", "Toyota", 2019, "Nguyễn Văn A", 10);
        transports[6] = new Truck("TRUCK-002", "Huyndai", 2010, "Nguyễn Văn B", 5);
    }


    @Override
    public Transport[] findAllTransport() {
        return transports;
    }

    @Override
    public Transport findByLicensePlate(String licensePlate) {
        for (Transport transport : transports) {
            if (transport != null) {
                if (Objects.equals(transport.getLicensePlate(), licensePlate)) {
                    return transport;
                }
            }
        }
        return null;
    }

    @Override
    public void addTransport(Transport transport) {
        for (int i = 0; i < transports.length; i++) {
            if (transports[i] == null) {
                transports[i] = transport;
                break;
            }
        }
    }

    @Override
    public void editTransport(Transport transport) {
        for (int i = 0; i < transports.length; i++) {
            if (transports[i] != null) {
                if (Objects.equals(transports[i].getLicensePlate(), transport.getLicensePlate())) {
                    transports[i].updateFrom(transport);
                    break;
                }
            }
        }
    }

    @Override
    public void deleteTransport(String licensePlate) {
        for (int i = 0; i < transports.length; i++) {
            if (transports[i] != null) {
                if (Objects.equals(transports[i].getLicensePlate(), licensePlate)) {
                    transports[i] = null;
                    break;
                }
            }
        }
        for (int i = 0; i < transports.length; i++) {
            if (i + 1 < transports.length) {
                if (transports[i] == null && transports[i + 1] != null) {
                    for (int j = i + 1; j < transports.length; j++) {
                        if (transports[j] != null) {
                            Transport temp = transports[j];
                            transports[j] = transports[i];
                            transports[i] = temp;
                            break;
                        }
                    }
                }
            }
        }
    }
}
