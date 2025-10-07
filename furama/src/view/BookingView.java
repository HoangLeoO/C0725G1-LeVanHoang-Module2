package view;

import entity.Booking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class BookingView {
    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static void showList(List<Booking> list){
        System.out.println("=== DANH SÁCH BOOKING ===");
        list.forEach(System.out::println);
    }

    public static Booking showAdd() {

        System.out.println("=== THÊM BOOKING MỚI ===");

        System.out.print("Nhập mã booking (VD: BK001): ");
        String bookingCode = scanner.nextLine().trim();


        LocalDate bookingDate ;
        while (true) {
            System.out.print("Nhập ngày booking (dd/MM/yyyy): ");
            String bookingDateStr = scanner.nextLine();
            try {
                bookingDate = LocalDate.parse(bookingDateStr,formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Ngày booking không hợp lệ. Nhập lại!");
            }
        }


        LocalDate startDate;
        while (true) {
            System.out.print("Nhập ngày bắt đầu (dd/MM/yyyy): ");
            String startDateStr = scanner.nextLine();
            try {
                startDate = LocalDate.parse(startDateStr,formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Ngày bắt đầu không hợp lệ. Nhập lại!");
            }
        }


        LocalDate endDate ;
        while (true) {
            System.out.print("Nhập ngày kết thúc (dd/MM/yyyy): ");
            String endDateStr = scanner.nextLine();
            try {
                endDate = LocalDate.parse(endDateStr,formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Ngày kết thúc không hợp lệ. Nhập lại!");
            }
        }

        System.out.print("Nhập mã khách hàng (VD: C001): ");
        String customerCode = scanner.nextLine().trim();

        System.out.print("Nhập mã dịch vụ (VD: SV001): ");
        String serviceCode = scanner.nextLine().trim();

        System.out.println("=== ĐÃ NHẬP BOOKING ===");
        System.out.printf("Code: %s | Booking: %s | Start: %s | End: %s | Customer: %s | Service: %s%n",
                bookingCode,
                bookingDate.format(formatter),
                startDate.format(formatter),
                endDate.format(formatter),
                customerCode,
                serviceCode);

        return new Booking(bookingCode, bookingDate, startDate, endDate, customerCode, serviceCode);
    }

}
