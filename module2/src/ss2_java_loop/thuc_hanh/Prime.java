package ss2_java_loop.thuc_hanh;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number check : ");
        int num = scanner.nextInt();
        boolean check = true;

        if (num < 2) {
            check = false;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    check = false;
                    break;
                }
            }
        }


        if (check) {
            System.out.println("Is Prime");
        } else {
            System.out.println("Is Not Prime");
        }
    }
}
