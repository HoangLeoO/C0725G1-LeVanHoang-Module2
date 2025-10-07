package view;


import entity.Booking;
import entity.Contract;

import java.util.List;
import java.util.Scanner;

public class ContractView {

    private static Scanner scanner = new Scanner(System.in);

    public static void showList(List<Contract> contracts) {
        for (Contract contract : contracts) {
            System.out.println(contract.toString());
        }
    }

    public static Contract showAdd(Booking booking) {
        System.out.println("=== NHẬP THÔNG TIN HỢP ĐỒNG ===");

        Contract contract = new Contract();

        System.out.print("Nhập mã hợp đồng: ");
        contract.setContractNumber(scanner.nextLine().trim());

        System.out.println("Mã booking: " + booking.getBookingCode());
        contract.setBookingCode(booking.getBookingCode());

        System.out.print("Nhập số tiền cọc trước: ");
        contract.setDeposit(Double.parseDouble(scanner.nextLine().trim()));

        System.out.print("Nhập tổng số tiền thanh toán: ");
        contract.setTotalPayment(Double.parseDouble(scanner.nextLine().trim()));

        System.out.println(" Thêm hợp đồng thành công!\n");
        return contract;
    }

    public static Contract showEdit(Contract contract) {
        System.out.println("=== CHỈNH SỬA HỢP ĐỒNG ===");
        System.out.println("Hợp đồng hiện tại:");
        System.out.println(contract);
        System.out.println("-----------------------------");

        System.out.print("Nhập mã hợp đồng mới (bỏ trống nếu giữ nguyên): ");
        String newContractNumber = scanner.nextLine().trim();
        if (!newContractNumber.isEmpty()) {
            contract.setContractNumber(newContractNumber);
        }

        System.out.print("Nhập mã booking mới (bỏ trống nếu giữ nguyên): ");
        String newBookingCode = scanner.nextLine().trim();
        if (!newBookingCode.isEmpty()) {
            contract.setBookingCode(newBookingCode);
        }

        System.out.print("Nhập số tiền cọc mới (bỏ trống nếu giữ nguyên): ");
        String depositInput = scanner.nextLine().trim();
        if (!depositInput.isEmpty()) {
            try {
                contract.setDeposit(Double.parseDouble(depositInput));
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ, giữ nguyên số tiền cọc cũ.");
            }
        }

        System.out.print("Nhập tổng số tiền thanh toán mới (bỏ trống nếu giữ nguyên): ");
        String totalInput = scanner.nextLine().trim();
        if (!totalInput.isEmpty()) {
            try {
                contract.setTotalPayment(Double.parseDouble(totalInput));
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ, giữ nguyên tổng thanh toán cũ.");
            }
        }

        System.out.println("Cập nhật thành công!");
        System.out.println("Thông tin hợp đồng sau khi chỉnh sửa:");
        System.out.println(contract);

        return contract;
    }
}
