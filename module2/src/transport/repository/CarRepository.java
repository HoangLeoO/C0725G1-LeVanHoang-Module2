package transport.repository;


import transport.entity.Car;
import transport.entity.Transport;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static transport.repository.TransportRepository.transports;

public class CarRepository implements ICarRepository {

    @Override
    public List<Car> findAllTransport() {
        List<Car> cars = new ArrayList<>();
        for (Transport transport : transports) {
            if (transport instanceof Car) {
                cars.add((Car) transport);
            }
        }
        return cars;
    }

    @Override
    public Car findByLicensePlate(String licensePlate) {
        for (Transport transport : transports) {
            if (transport != null && Objects.equals(transport.getLicensePlate(), licensePlate)) {
                return (Car) transport;
            }
        }
        return null;
    }

    @Override
    public void addTransport(Car car) {
        transports.add(car);
    }

    @Override
    public void editTransport(Car car) {
        for (Transport transport : transports) {
            if (Objects.equals(transport.getLicensePlate(), car.getLicensePlate())) {
                transport.updateFrom(car);
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
