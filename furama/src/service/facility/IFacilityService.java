package service.facility;

import entity.facility.Facility;
import service.IService;

import java.util.List;

public interface IFacilityService extends IService<Facility> {
    public void updateValueByKey(Facility facility );
    public  List<Facility> showMaintenanceList();
}
