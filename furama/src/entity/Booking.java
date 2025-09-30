package entity;

import java.time.LocalDate;

public class Booking {
    private String bookingCode;   // Mã booking
    private LocalDate bookingDate; // Ngày booking
    private LocalDate startDate;   // Ngày bắt đầu thuê
    private LocalDate endDate;     // Ngày kết thúc thuê
    private String customerCode;   // Mã khách hàng
    private String serviceCode;    // Mã dịch vụ (Villa/House/Room)

    public Booking(String bookingCode, LocalDate bookingDate, LocalDate startDate, LocalDate endDate,
                   String customerCode, String serviceCode) {
        this.bookingCode = bookingCode;
        this.bookingDate = bookingDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerCode = customerCode;
        this.serviceCode = serviceCode;
    }

    public Booking() {}

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }
}