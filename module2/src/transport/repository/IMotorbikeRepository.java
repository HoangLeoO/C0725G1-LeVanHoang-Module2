package transport.repository;

import transport.entity.Motorbike;
import transport.entity.Truck;

public interface IMotorbikeRepository {
    Motorbike[] findAllMotorbike();

    Motorbike getMotorbikeFindLicensePlate(String licensePlate);

    void addMotorbike(Motorbike motorbike);

    void editMotorbike(Motorbike motorbike);

    void deleteMotorbike(String licensePlate);
}
