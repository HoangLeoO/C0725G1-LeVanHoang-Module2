package transport.service;

import transport.entity.Motorbike;
import transport.repository.IMotorbikeRepository;
import transport.repository.MotorbikeRepository;

public class MotorbikeService implements IMotorbikeService{
    IMotorbikeRepository motorbikeRepository = new MotorbikeRepository();
    @Override
    public Motorbike[] findAllMotorbike() {
        return motorbikeRepository.findAllMotorbike();
    }

    @Override
    public Motorbike getMotorbikeFindLicensePlate(String licensePlate) {
        return motorbikeRepository.getMotorbikeFindLicensePlate(licensePlate);
    }

    @Override
    public void addMotorbike(Motorbike motorbike) {
        motorbikeRepository.addMotorbike(motorbike);
        System.out.println(" Thêm phương tiện mới có biển số xe " + motorbike.getLicensePlate() + "thành công !");
    }

    @Override
    public void editMotorbike(Motorbike motorbike) {
        motorbikeRepository.editMotorbike(motorbike);
    }

    @Override
    public void deleteMotorbike(String licensePlate) {
        motorbikeRepository.deleteMotorbike(licensePlate);
    }
}
