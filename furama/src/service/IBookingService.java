package service;

import entity.Booking;

import java.util.Queue;

public interface IBookingService extends  IService<Booking> {
    Queue<Booking> listQueueBooking();
    Booking getFirstBooking();
}
