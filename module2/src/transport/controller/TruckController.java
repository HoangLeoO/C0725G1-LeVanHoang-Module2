package transport.controller;

import transport.entity.Truck;
import transport.service.ITruckService;
import transport.service.TruckService;
import transport.view.TruckView;

public class TruckController {
    static ITruckService truckService = new TruckService();

    public static void showListTruck(){
        Truck[] trucks = truckService.findAllTruck();
        TruckView.showAllTruck(trucks);
    }
    public static void addTruck(){
        System.out.println("Dữ liêu xe mới : ");
        truckService.addTruck(TruckView.addTruck());
    }
}
