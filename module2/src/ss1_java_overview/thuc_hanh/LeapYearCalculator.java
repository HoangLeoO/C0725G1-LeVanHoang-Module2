package ss1_java_overview.thuc_hanh;

import java.util.Scanner;

public class LeapYearCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Input Year : ");
        int year = scanner.nextInt();
        boolean check = false ;
        if (year % 4 == 0){
            if (year % 100 == 0){
                check = year % 400 == 0;
            }else {
                check = true;
            }
        }

        if (check){
            System.out.printf("%d is a leap year", year);
        }else {
            System.out.printf("%d is NOT a leap year", year);
        }
    }
}
