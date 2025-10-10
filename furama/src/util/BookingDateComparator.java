package util;

import entity.Booking;

import java.util.Comparator;

public class BookingDateComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking b1, Booking b2) {
        // So sánh theo code booking
        int cmp = b1.getBookingCode().compareTo(b2.getBookingCode());

        // Nếu trùng mã thì giữ mã booking đầu
        if (cmp == 0) {
            return 0;
        }

        // khong trung thi sap xep theo ngay bat dau
        cmp = b1.getBookingDate().compareTo(b2.getBookingDate());

        // trung ngay bat dau thi xap xep theo ngay ket thuc
        if (cmp == 0) {
            cmp = b1.getBookingCode().compareTo(b2.getBookingCode());
        }


        // Nếu trùng mã thì xem như trùng hoàn toàn => bỏ
        return cmp;
    }
}
