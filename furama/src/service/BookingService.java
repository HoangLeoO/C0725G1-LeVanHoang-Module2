package service;

import entity.Booking;
import repository.BookingRepository;
import repository.IBookingRepository;
import repository.facility.FacilityRepository;
import repository.facility.IFacilityRepository;

import java.util.List;
import java.util.Queue;

public class BookingService implements IBookingService{

    private IBookingRepository bookingRepository = new BookingRepository();
    private IFacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public Booking findCode(String code) {
        return null;
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public boolean add(Booking object) {
        boolean check = bookingRepository.add(object);
        if (check){
            facilityRepository.updateValueByKey(facilityRepository.findCode(object.getServiceCode()));
        }
        return check;
    }

    @Override
    public void edit(Booking object) {

    }

    @Override
    public boolean deleteByCode(String code) {
        return false;
    }

    @Override
    public Queue<Booking> listQueueBooking() {
        return bookingRepository.listQueueBooking();
    }

    @Override
    public Booking getFirstBooking() {
        return bookingRepository.getFirstBooking();
    }
}
