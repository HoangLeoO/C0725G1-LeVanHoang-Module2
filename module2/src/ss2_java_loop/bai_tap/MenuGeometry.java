package ss2_java_loop.bai_tap;

import java.util.Scanner;

public class MenuGeometry {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Tam giac vuong goc 4 goc");
            System.out.println("2. Tam giac can");
            System.out.println("3. Hinh chu nhat");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 1; i <= 5; i++) {
                        String str = "";
                        for (int j = 1; j <= i; j++) {
                            str += " * ";
                        }
                        System.out.println(str);
                    }
                    for (int i = 1; i <= 5; i++) {
                        String str = "";
                        for (int j = i; j <= 5; j++) {
                            str += " * ";
                        }
                        System.out.println(str);
                    }
                    for (int i = 5; i > 0; i--) {
                        String str = "";
                        for (int m = i-1; m > 0; m--) {
                           str += "   ";
                        }
                        for (int j = i-1; j < 5; j++) {
                            str += " * ";
                        }
                        System.out.println(str);
                    }

                    for (int i = 5; i > 0; i--) {
                        String str = "";
                        for (int m = i-1; m < 4 ; m++) {
                            str += "   ";
                        }
                        for (int j = i; j > 0; j--) {
                            str += " * ";
                        }
                        System.out.println(str);
                    }
                    break;
                case 2:
                    for (int i = 1; i <= 7; i++){
                        String str = "";
                        for (int j = 1; j <= 7 - i; j++) {
                            str += " ";
                        }
                        for (int k = 1; k <= 2 * i - 1; k++) {
                            str += "*";
                        }
                        System.out.println(str);
                    }

                    break;
                case 3:
                    for (int i = 1; i <= 5; i++) {
                        String str = "";
                        for (int j = 1; j <= 7; j++) {
                            str += " * ";
                        }
                        System.out.println(str);
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("No choice!");
                    break;
            }
        }
    }
}
