package transport.controller;

import transport.entity.Truck;
import transport.service.ITruckService;
import transport.service.TruckService;
import transport.view.TruckView;

import java.util.List;

public class TruckController {
    static ITruckService truckService = new TruckService();

    public static void showListTruck() {
        List<Truck> trucks = truckService.findAllTransport();
        TruckView.showAllTruck(trucks);
    }

    public static void addTruck() {
        truckService.addTransport(TruckView.addTruck());
    }

    public static void editTruck(Truck truck) {
        truckService.editTransport(truck);
    }

    public static Truck searchTruck(String plate) {
        return truckService.findByLicensePlate(plate);
    }

    public static void deleteTruck(String plate) {
        truckService.deleteTransport(plate);
    }
}
