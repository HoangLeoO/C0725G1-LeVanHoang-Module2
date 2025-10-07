package repository;

import entity.Booking;

import java.util.Queue;

public interface IBookingRepository extends IRepository<Booking>  {
    Queue<Booking> listQueueBooking();
    Booking getFirstBooking();
}
