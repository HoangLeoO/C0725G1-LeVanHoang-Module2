package transport_v2.Controller;


import transport_v2.entity.Truck;
import transport_v2.service.ITruckService;
import transport_v2.service.TruckService;
import transport_v2.view.TruckView;

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
