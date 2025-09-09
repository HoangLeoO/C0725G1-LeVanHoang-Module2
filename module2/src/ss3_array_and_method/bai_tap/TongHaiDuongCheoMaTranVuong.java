package ss3_array_and_method.bai_tap;

import java.util.Scanner;

public class TongHaiDuongCheoMaTranVuong {
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
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
            System.out.println(matrix[i][i]);
        }

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][matrix[i].length - 1 - i];
            System.out.println(matrix[i][matrix[i].length - 1 - i]);
        }
        System.out.println(sum);
    }
}
