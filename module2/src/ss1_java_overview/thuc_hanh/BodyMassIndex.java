package ss1_java_overview.thuc_hanh;

import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Input  weight :");
        float weigh = scanner.nextFloat();
        System.out.println(" Input  height :");
        float height = scanner.nextFloat();

        float bmi = weigh/(height*height);

        if (bmi >= 30){
            System.out.println("Obese");
        }else if (bmi >= 25){
            System.out.println("Overweight");
        }else if (bmi >= 18.5){
            System.out.println("Normal");
        }else {
            System.out.println("Underweight");
        }

    }
}
