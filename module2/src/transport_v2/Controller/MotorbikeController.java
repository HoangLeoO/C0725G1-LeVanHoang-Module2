package transport_v2.Controller;


import transport_v2.entity.Motorbike;
import transport_v2.service.IMotorbikeService;
import transport_v2.service.MotorbikeService;
import transport_v2.view.MotorbikeView;

public class MotorbikeController {
    static IMotorbikeService motorbikeService = new MotorbikeService();
    public static void showListMotorbike(){
        Motorbike[] motorbikes = (Motorbike[]) motorbikeService.findAllTransport();
        MotorbikeView.showAllMotorbike(motorbikes);
    }
    public static void addMotorbike() {
        motorbikeService.addTransport(MotorbikeView.addMotorbike());
    }
}
