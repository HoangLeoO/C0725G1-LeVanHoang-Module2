package transport.repository;

import transport.entity.Car;
import transport.entity.Motorbike;
import transport.entity.Transport;
import transport.entity.Truck;

import java.util.Objects;

public class TransportRepository implements ITransportRepository{

    @Override
    public Transport findByLicensePlate(String licensePlate) {
        for (Car car : CarRepository.cars) {
            if (car != null) {
                if (Objects.equals(car.getLicensePlate(), licensePlate)) {
                    return car;
                }
            }
        }
        for (Motorbike motorbike : MotorbikeRepository.motorbikes) {
            if (motorbike != null) {
                if (Objects.equals(motorbike.getLicensePlate(), licensePlate)) {
                    return motorbike;
                }
            }
        }
        for (Truck truck : TruckRepository.trucks) {
            if (truck != null) {
                if (Objects.equals(truck.getLicensePlate(), licensePlate)) {
                    return truck;
                }
            }
        }
        return null;
    }
}
