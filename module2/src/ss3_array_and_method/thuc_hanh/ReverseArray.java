package ss3_array_and_method.thuc_hanh;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        int[] array2 = new int[array.length];
        int index = 0;
        for (int i = array.length-1 ; i >= 0 ; i--){
            System.out.println(i);
            array2[index] = array[i];
            index++;
        }
        System.out.println("array : " + Arrays.toString(array) + "\n" + "array2 : " + Arrays.toString(array2));
    }
}
