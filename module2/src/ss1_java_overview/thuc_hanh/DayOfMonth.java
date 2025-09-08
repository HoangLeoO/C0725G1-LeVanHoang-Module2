package ss1_java_overview.thuc_hanh;

import java.util.Scanner;

public class DayOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month;
        do {
            System.out.println("Input month : ");
            month = scanner.nextInt();
            switch (month) {
                case 2:
                    System.out.println("Month is : 28 or 29 Day");
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    System.out.println("Month " + month + " is 31 Day");
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    System.out.println("Month " + month + " is 30 Day");
                    break;
                default:
                    System.out.print("Invalid input!");
                    break;
            }
        } while (month > 0 && month < 13);
    }
}
