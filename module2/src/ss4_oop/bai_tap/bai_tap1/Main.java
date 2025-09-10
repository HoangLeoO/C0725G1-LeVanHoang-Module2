package ss4_oop.bai_tap.bai_tap1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(" Nhap a : ");
        double a = Double.parseDouble(input.nextLine());
        System.out.println(" Nhap b : ");
        double b = Double.parseDouble(input.nextLine());
        System.out.println(" Nhap c : ");
        double c = Double.parseDouble(input.nextLine());
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);

        if (quadraticEquation.isQuadraticEquation()) {
            double[] arrayRoot = quadraticEquation.getRoots();
            if (arrayRoot.length == 2) {
                System.out.println("Phuong trinh co 2 nghiem la : " + arrayRoot[0] + " va " + arrayRoot[1]);
            } else if (arrayRoot.length == 1) {
                System.out.println("Phuong trinh co 1 nghiem la : " + arrayRoot[0]);
            }else {
                System.out.println(" Phuong trinh vo nghiem ");
            }
        }else {
            System.out.println(" Khong phai phuong trinh bat 2");
        }
    }
}
