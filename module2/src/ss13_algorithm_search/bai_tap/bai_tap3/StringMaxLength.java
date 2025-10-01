package ss13_algorithm_search.bai_tap.bai_tap3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMaxLength {
    public static void main(String[] args) {
        String text = new Scanner(System.in).nextLine();
        System.out.println(testS(text));
    }

    public static StringBuilder testS(String text) {

        int index = 0;
        List<StringBuilder> stringBuilderList = new ArrayList<>();

        while (index < text.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(text.charAt(index));
            int i = index + 1;
            for (; i < text.length(); i++) {
                if (stringBuilder.charAt(stringBuilder.length() - 1) > text.charAt(i)) {
                    break;
                }
                stringBuilder.append(text.charAt(i));
            }
            stringBuilderList.add(stringBuilder);
            index = i;
        }


        StringBuilder longest = stringBuilderList.get(0);
        for (StringBuilder sb : stringBuilderList) {
            if (sb.length() > longest.length()) {
                longest = sb;
            }
        }

        return longest;
    }
}
