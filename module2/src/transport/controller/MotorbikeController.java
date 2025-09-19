package transport.controller;


import transport.service.IMotorbikeService;
import transport.service.MotorbikeService;
import transport.view.MotorbikeView;

public class MotorbikeController {
    static IMotorbikeService motorbikeService = new MotorbikeService();
    public static void showListMotorbike(){
//        Motorbike[] motorbikes = (Motorbike[]) motorbikeService.findAllTransport();
//        MotorbikeView.showAllMotorbike(motorbikes);
    }
    public static void addMotorbike() {
        motorbikeService.addTransport(MotorbikeView.addMotorbike());
    }
}
