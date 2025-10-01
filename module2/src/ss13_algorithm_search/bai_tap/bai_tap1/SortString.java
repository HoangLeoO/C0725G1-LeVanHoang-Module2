package ss13_algorithm_search.bai_tap.bai_tap1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortString {
    public static void main(String[] args) {
        String text = new Scanner(System.in).nextLine();
        System.out.println(sortText(text));

    }

    public static StringBuilder sortText(String text) {
        StringBuilder result = new StringBuilder();
        result.append(text.charAt(0));
        for (int i = 1 ; i < text.length() ; i++){
            if (text.charAt(i) > result.charAt(result.length()-1)){
                result.append(text.charAt(i));
            }
        }
        return result;
    }


}
