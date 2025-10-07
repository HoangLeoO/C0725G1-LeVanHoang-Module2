package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Booking implements Comparable<Booking>{
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return bookingCode.equals(booking.bookingCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingCode, bookingDate, startDate, endDate, customerCode, serviceCode);
    }

    @Override
    public int compareTo(Booking other) {
        // Ưu tiên theo ngày booking
        int cmp = this.bookingDate.compareTo(other.bookingDate);

        if (cmp == 0) {
            // Nếu trùng ngày booking → so sánh theo ngày kết thúc
            cmp = this.endDate.compareTo(other.endDate);
        }

        if (cmp == 0) {
            // Nếu vẫn trùng cả hai ngày → so sánh theo mã booking (để tránh mất dữ liệu)
            cmp = this.bookingCode.compareTo(other.bookingCode);
        }

        return cmp;
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format(
                "%-8s | Booking: %-10s | Start: %-10s | End: %-10s | Customer: %-6s | Service: %-6s",
                bookingCode,
                bookingDate.format(formatter),
                startDate.format(formatter),
                endDate.format(formatter),
                customerCode,
                serviceCode
        );
    }

}