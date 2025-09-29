package transport.controller;

import transport.entity.Motorbike;
import transport.service.IMotorbikeService;
import transport.service.MotorbikeService;
import transport.view.MotorbikeView;

import java.util.List;

public class MotorbikeController {
    static IMotorbikeService motorbikeService = new MotorbikeService();

    public static void showListMotorbike() {
        List<Motorbike> motorbikes = motorbikeService.findAllTransport();
        MotorbikeView.showAllMotorbike(motorbikes);
    }

    public static void addMotorbike() {
        motorbikeService.addTransport(MotorbikeView.addMotorbike());
    }

    public static void editMotorbike(Motorbike motorbike) {
        motorbikeService.editTransport(motorbike);
    }

    public static Motorbike searchMotorbike(String plate) {
        return motorbikeService.findByLicensePlate(plate);
    }
    public static void deleteMotorbike(String plate) {
        motorbikeService.deleteTransport(plate);
    }
}
