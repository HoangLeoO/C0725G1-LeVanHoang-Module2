package ss3_array_and_method.bai_tap;

import java.util.Scanner;

public class ValueMaxMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 4, 2},
                {5, 6, 9, 8}
        };
        int max = matrix[0][0];
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt > max) {
                    max = anInt;
                }
            }
        }
        System.out.println("Max = " + max);
    }
}
