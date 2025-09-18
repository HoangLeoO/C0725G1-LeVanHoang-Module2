package transport_v2.view;


import transport_v2.entity.Transport;

import java.util.Scanner;

public class TransportView {
    static Scanner scanner = new Scanner(System.in);

    public static String editTransport(){
        System.out.println("----- CHỈNH SỬA THÔNG TIN PHƯƠNG TIỆN -----");
        System.out.println(" Nhập biển số xe chỉnh sửa: ");
        return scanner.nextLine();
    }
    public static String deleteTransport(){
        System.out.println("----- XÓA PHƯƠNG TIỆN -----");
        System.out.println(" Nhập biển số xe cần xóa : ");
        return scanner.nextLine();
    }
    public static boolean confirmDelete(Transport transport) {
        System.out.println("Bạn có chắc chắn muốn xóa phương tiện sau?");
        System.out.println(transport.toString());
        System.out.print("Nhập Y để xác nhận, N để hủy: ");

        Scanner scanner = new Scanner(System.in);
        String confirm = scanner.nextLine().trim().toUpperCase();

        return confirm.equals("Y");
    }

    public static boolean confirmEdit(Transport transport) {
        System.out.println("Bạn có chắc chắn muốn thay đổi thông tin phương tiện sau?");
        System.out.println(transport.toString());
        System.out.print("Nhập Y để xác nhận, N để hủy: ");

        Scanner scanner = new Scanner(System.in);
        String confirm = scanner.nextLine().trim().toUpperCase();

        return confirm.equals("Y");
    }
}
