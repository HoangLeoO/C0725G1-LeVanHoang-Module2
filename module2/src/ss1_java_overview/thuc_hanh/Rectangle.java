package ss1_java_overview.thuc_hanh;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        float wight, height;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Wight : ");
        wight = scanner.nextFloat();

        System.out.println("Enter Height : ");
        height = scanner.nextFloat();

        float area = wight * height;
        System.out.println("Area is : " + area);
    }
}
