package ss1_java_overview.bai_tap;

import java.util.Scanner;

public class HelloWord {
    public static void main(String[] args) {
        System.out.println("Hello Word");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name : ");
        String name = scanner.nextLine();
        System.out.println(" Hello : " + name );
    }
}
