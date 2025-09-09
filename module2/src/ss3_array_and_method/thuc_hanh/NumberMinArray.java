package ss3_array_and_method.thuc_hanh;

public class NumberMinArray {
    public static void main(String[] args) {
        int[] arrNum = { 1,2,3,3,4,1};
        System.out.println(min(arrNum));
    }

    public static int min(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
