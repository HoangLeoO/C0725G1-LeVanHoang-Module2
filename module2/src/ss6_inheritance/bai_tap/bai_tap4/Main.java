package ss6_inheritance.bai_tap.bai_tap4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập độ dài cạnh 1: ");
        double side1 = Double.parseDouble(scanner.nextLine());

        System.out.println("Nhập độ dài cạnh 2: ");
        double side2 =Double.parseDouble(scanner.nextLine());

        System.out.println("Nhập độ dài cạnh 3: ");
        double side3 = Double.parseDouble(scanner.nextLine());

        System.out.println("Nhập màu sắc của tam giác: ");
        String color = scanner.next();

        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);

        System.out.println("Màu sắc của tam giác: " + triangle.getColor());
        System.out.println("Diện tích của tam giác: " + triangle.getArea());
        System.out.println("Chu vi của tam giác: " + triangle.getPerimeter());
        System.out.println(triangle);
    }
}