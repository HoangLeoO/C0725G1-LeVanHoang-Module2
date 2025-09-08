package ss1_java_overview.bai_tap;

import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (0-999): ");
        int n = sc.nextInt();

        if (n < 0 || n > 999) {
            System.out.println("Out of range");
            return;
        }

        int hundred = n / 100;
        System.out.println(hundred);
        int ten = (n / 10) % 10;
        System.out.println(ten);
        int one = n % 10;
        System.out.println(one);

        String result = "";

        if (hundred > 0) {
            switch (hundred) {
                case 1:
                    result += "One hundred ";
                    break;
                case 2:
                    result += "Two hundred ";
                    break;
                case 3:
                    result += "Three hundred ";
                    break;
                case 4:
                    result += "Four hundred ";
                    break;
                case 5:
                    result += "Five hundred ";
                    break;
                case 6:
                    result += "Six hundred ";
                    break;
                case 7:
                    result += "Seven hundred ";
                    break;
                case 8:
                    result += "Eight hundred ";
                    break;
                case 9:
                    result += "Nine hundred ";
                    break;
            }
        }


        if (ten == 1) {
            switch (one) {
                case 0:
                    result += "Ten";
                    break;
                case 1:
                    result += "Eleven";
                    break;
                case 2:
                    result += "Twelve";
                    break;
                case 3:
                    result += "Thirteen";
                    break;
                case 4:
                    result += "Fourteen";
                    break;
                case 5:
                    result += "Fifteen";
                    break;
                case 6:
                    result += "Sixteen";
                    break;
                case 7:
                    result += "Seventeen";
                    break;
                case 8:
                    result += "Eighteen";
                    break;
                case 9:
                    result += "Nineteen";
                    break;
            }
        } else {

            switch (ten) {
                case 2:
                    result += "Twenty ";
                    break;
                case 3:
                    result += "Thirty ";
                    break;
                case 4:
                    result += "Forty ";
                    break;
                case 5:
                    result += "Fifty ";
                    break;
                case 6:
                    result += "Sixty ";
                    break;
                case 7:
                    result += "Seventy ";
                    break;
                case 8:
                    result += "Eighty ";
                    break;
                case 9:
                    result += "Ninety ";
                    break;
            }


            switch (one) {
                case 1:
                    result += "One";
                    break;
                case 2:
                    result += "Two";
                    break;
                case 3:
                    result += "Three";
                    break;
                case 4:
                    result += "Four";
                    break;
                case 5:
                    result += "Five";
                    break;
                case 6:
                    result += "Six";
                    break;
                case 7:
                    result += "Seven";
                    break;
                case 8:
                    result += "Eight";
                    break;
                case 9:
                    result += "Nine";
                    break;
            }
        }

        if (n == 0) result = "Zero";

        System.out.println(result);
    }
}
