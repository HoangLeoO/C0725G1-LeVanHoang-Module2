package repository.facility;

import entity.facility.Facility;
import repository.IRepository;


public interface IFacilityRepository extends IRepository<Facility> {
    public void updateValueByKey(Facility facility);
    public boolean checkNumberUses(Facility facility);
}