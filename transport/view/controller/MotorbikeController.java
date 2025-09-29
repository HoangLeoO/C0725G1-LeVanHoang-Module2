package transport.view.controller;


import transport.view.MotorbikeView;
import transport.view.service.IMotorbikeService;
import transport.view.service.MotorbikeService;

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
