package controller;

import entity.Booking;
import service.BookingService;
import service.IBookingService;

import java.util.List;
import java.util.Queue;

public class BookingController {
    private static IBookingService bookingService = new BookingService();

    public static List<Booking> showAll(){
        return bookingService.findAll();
    }
    public static boolean addBooking(Booking booking){
        return bookingService.add(booking);
    }
    public static Queue<Booking> showListQueueBooking(){
        return bookingService.listQueueBooking();
    }

    public static Booking getFirstAndRemoveBooking(){
        return bookingService.getFirstBooking();
    }
}
