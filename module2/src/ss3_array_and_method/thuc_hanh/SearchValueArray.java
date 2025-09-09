package ss3_array_and_method.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class SearchValueArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sizeArray;
        do {
            System.out.println("Nhap do dai cua mang :");
            sizeArray = Integer.parseInt(input.nextLine());
        } while (sizeArray < 1);


        String[] nameStudent = new String[sizeArray];

        for (int i = 0; i < nameStudent.length; i++) {
            System.out.println("Input Name Student : ");
            nameStudent[i] = input.nextLine();
        }
        System.out.println("List Student : " + Arrays.toString(nameStudent));

        System.out.println("Search Name : ");
        String name = input.nextLine();
        boolean checkName = false;
        for (String s : nameStudent) {
            if (s.equals(name)) {
                checkName = true;
                break;
            }
        }
        if (checkName){
            System.out.println(name);
        }else {
            System.out.println("No student name");
        }

    }
}
