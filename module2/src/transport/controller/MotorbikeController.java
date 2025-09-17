package transport.controller;


import transport.entity.Motorbike;
import transport.service.IMotorbikeService;
import transport.service.MotorbikeService;
import transport.view.MotorbikeView;

import java.util.Scanner;

public class MotorbikeController {
    static IMotorbikeService motorbikeService = new MotorbikeService();
    static Scanner scanner = new Scanner(System.in);

    public static void showListMotorbike() {
        Motorbike[] motorbikes = motorbikeService.findAllMotorbike();
        MotorbikeView.showAllMotorbike(motorbikes);
    }

    public static void addMotorbike() {
        System.out.println("Dữ liêu xe mới : ");
        motorbikeService.addMotorbike(MotorbikeView.addMotorbike());
    }
}
