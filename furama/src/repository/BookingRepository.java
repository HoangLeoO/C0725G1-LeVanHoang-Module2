package repository;

import entity.Booking;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BookingRepository implements IBookingRepository {
    private static final Set<Booking> listBooking = new TreeSet<>();
    private static final Queue<Booking> bookingQueue = new LinkedList<>();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    static {
        listBooking.add(new Booking("BK001",
                LocalDate.parse("01/10/2025", formatter),
                LocalDate.parse("05/10/2025", formatter),
                LocalDate.parse("10/10/2025", formatter),
                "KH-0010", "VL-0001"));

        listBooking.add(new Booking("BK002",
                LocalDate.parse("05/10/2025", formatter),
                LocalDate.parse("10/10/2025", formatter),
                LocalDate.parse("20/10/2025", formatter),
                "KH-0012", "VL-0001"));
        bookingQueue.addAll(listBooking);
    }


    @Override
    public Booking findCode(String code) {
        return null;
    }

    @Override
    public List<Booking> findAll() {
        List<Booking> list = new ArrayList<>(listBooking);
        return list;
    }

    @Override
    public boolean add(Booking object) {
        boolean added = listBooking.add(object);
        if (added) {
            bookingQueue.add(object);
            return true;
        } else{
            return false;
        }

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
        return bookingQueue;
    }

    @Override
    public Booking getFirstBooking() {
        return bookingQueue.remove();
    }
}
