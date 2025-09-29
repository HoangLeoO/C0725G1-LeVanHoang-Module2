package transport.view.controller;


import transport.view.TruckView;
import transport.view.service.ITruckService;
import transport.view.service.TruckService;

public class TruckController {
    static ITruckService truckService = new TruckService();

    public static void showListTruck() {
//        Truck[] trucks = (Truck[]) truckService.findAllTransport();
//        TruckView.showAllTruck(trucks);
    }

    public static void addTruck() {
        System.out.println("Dữ liêu xe mới : ");
        truckService.addTransport(TruckView.addTruck());
    }
}
