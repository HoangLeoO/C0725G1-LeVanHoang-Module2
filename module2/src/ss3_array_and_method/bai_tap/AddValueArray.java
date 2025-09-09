package ss3_array_and_method.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class AddValueArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = {1, 3, 2, 4, 5};

        System.out.println("Them so ");
        int number = Integer.parseInt(input.nextLine());
        System.out.println("Vi tri index : ");
        int indexNumber = Integer.parseInt(input.nextLine());

        if (indexNumber <= -1 || indexNumber >= array.length + 1) {
            System.out.println("Khong chen duoc phan tu ");
        } else {
            int[] newArray = new int[array.length + 1];
            int index = 0;
            for (int i = 0; i < newArray.length; i++) {
                if (i == indexNumber) {
                    newArray[i] = number;
                    continue;
                }
                newArray[i] = array[index++];
            }
            System.out.println(Arrays.toString(newArray));
        }

    }
}
