package transport.service;

import transport.entity.Motorbike;

public interface IMotorbikeService {
    Motorbike[] findAllMotorbike();

    Motorbike getMotorbikeFindLicensePlate(String licensePlate);

    void addMotorbike(Motorbike motorbike);

    void editMotorbike(Motorbike motorbike);

    void deleteMotorbike(String licensePlate);
}
