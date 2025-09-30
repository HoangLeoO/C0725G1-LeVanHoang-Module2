package ss15_exceptions.bai_tap.bai_tap1;

import java.util.Scanner;

public class TriangleTest {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            try {
                System.out.println(" Nhap a , b ,c");
                int a = Integer.parseInt(scanner.nextLine());
                int b = Integer.parseInt(scanner.nextLine());
                int c = Integer.parseInt(scanner.nextLine());
                Triangle triangle = new Triangle(a, b, c);
                break;
            } catch (TriangleException e) {
                System.err.println("Lỗi: " + e.getMessage());
            } catch (Exception e) {
                System.err.println(" Dữ liệu nhập không hợp lệ (phải là số)!");
                System.out.println(" Vui lòng nhập lại!\n");
            }


        }
        scanner.close();
        System.out.println(" is a triangle");
    }

    public static void checkTriangle(double a, double b, double c) throws TriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new TriangleException("Cạnh tam giác phải là số dương!");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new TriangleException("Tổng 2 cạnh phải lớn hơn cạnh còn lại!");
        }
    }

}
