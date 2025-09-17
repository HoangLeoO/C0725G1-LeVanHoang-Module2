package transport.view;

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
}
