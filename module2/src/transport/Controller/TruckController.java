package transport.Controller;


import transport.entity.Truck;
import transport.service.ITruckService;
import transport.service.TruckService;
import transport.view.TruckView;

public class TruckController {
    static ITruckService truckService = new TruckService();

    public static void showListTruck() {
        Truck[] trucks = (Truck[]) truckService.findAllTransport();
        TruckView.showAllTruck(trucks);
    }

    public static void addTruck() {
        System.out.println("Dữ liêu xe mới : ");
        truckService.addTransport(TruckView.addTruck());
    }
}
