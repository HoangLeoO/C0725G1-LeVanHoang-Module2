package ss3_array_and_method.bai_tap;

import java.util.Arrays;

public class GopMang {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {4,5,6};
        int[] arr3 = new int[arr1.length+arr2.length];
        int indexArr3 = 0;
        for (int k : arr1) {
            arr3[indexArr3++] = k;
        }
        for (int j : arr2) {
            arr3[indexArr3++] = j;
        }
        System.out.println(Arrays.toString(arr3));
    }
}
