package ss3_array_and_method.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteValueArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println("Nhap phan tu can xoa");
        int valueDelete = Integer.parseInt(input.nextLine());
        int indexDelete = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valueDelete) {
                indexDelete = i;
                break;
            }
        }
        if (indexDelete == -1) {
            System.out.println("Không tìm thấy giá trị cần xóa.");
        } else {
            int[] newArray = new int[array.length - 1];
            int index = 0 ;
            for (int i = 0; i < array.length; i++) {
                if (i == indexDelete) {
                    continue;
                }
                newArray[index++] = array[i];
            }
            System.out.println(Arrays.toString(newArray));
        }
    }
}
