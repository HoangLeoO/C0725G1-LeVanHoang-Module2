package ss3_array_and_method.bai_tap;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SumMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap cot");
        int sizeCol = Integer.parseInt(input.nextLine());
        System.out.println("Nhap hang");
        int sizeRow = Integer.parseInt(input.nextLine());

        int[][] matrix = new int[sizeCol][sizeRow];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Tinh Tong Hang Thu : ");
        int numIndex = Integer.parseInt(input.nextLine()) - 1;

        int sum = 0;
        for (int i = 0; i < matrix[numIndex].length; i++) {
            sum += matrix[numIndex][i];
        }
        System.out.println(sum);
    }
}
