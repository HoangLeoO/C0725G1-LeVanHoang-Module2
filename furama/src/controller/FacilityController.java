package controller;

import entity.facility.Facility;
import service.facility.FacilityService;
import service.facility.IFacilityService;

import java.util.List;

public class FacilityController {
    private static IFacilityService facilityService = new FacilityService();

    public static List<Facility> showAll(){
        return facilityService.findAll();
    }
    public static boolean add(Facility facility){
        return facilityService.add(facility);
    }
    public static List<Facility> showMaintenanceList(){
        return facilityService.showMaintenanceList();
    }

}
