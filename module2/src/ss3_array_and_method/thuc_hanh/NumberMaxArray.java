package ss3_array_and_method.thuc_hanh;

public class NumberMaxArray {
    public static void main(String[] args) {
        int[] arrayNumber = { 1,3,2,6,10};
        int max = arrayNumber[1];
        for (int i = 0 ; i < arrayNumber.length ; i++){
            if (max < arrayNumber[i]){
                max = arrayNumber[i];
            }
        }
        System.out.println("Number Max in Array : " + max);

    }
}
