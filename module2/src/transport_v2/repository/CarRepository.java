package transport_v2.repository;

import transport_v2.entity.Car;
import transport_v2.entity.Transport;


import java.util.Objects;

import static transport_v2.repository.TransportRepository.transports;

public class CarRepository implements ICarRepository {

    @Override
    public Transport[] findAllTransport() {
        Car[] cars = new Car[100];
        int indexCar = 0;
        for (int i = 0; i < transports.length; i++) {
            if (transports[i] instanceof Car) {
                cars[indexCar] = (Car) transports[i];
                indexCar++;
            }
        }
        return cars;
    }

    @Override
    public Transport findByLicensePlate(String licensePlate) {
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
