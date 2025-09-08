package ss1_java_overview.bai_tap;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chose;
        System.out.println(" Nhập mệnh giá cần chuyển đổi :  ");
        float rate = scanner.nextFloat();
        do {
            System.out.println("---Chuyển Đổi Tiền Tệ---\n" +
                    " - Chọn tỉ giá -\n" +
                    "- VND - \n" +
                    "- UED - \n" +
                    "- End - \n"
            );
            chose = scanner.nextInt();
            switch (chose) {
                case 1:
                    System.out.println("VND = " + rate*23000);
                    break;
                case 2 :
                    System.out.println("UED = " + rate/23000);
                    break;
                default:
                    System.out.println("---End---");
            }
        } while (chose > 0 && chose < 3);
    }
}
