package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAnimal {
    private static final String CODE = "^((C)|(H)|(B))-(\\d){1,4}$";
    private static final String NAME = "^([A-Z][a-z]+(\\s[A-Z][a-z]+)*)$";
    private static final String YEAR = "^\\d{4}$";
    private static final String WING_SPAN = "^\\d+$";
    private static final String CAN_TALK = "^(((Y)|(N))|((y)|(n)))$";
    private static final String check = "";


    private static boolean validate(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean checkName(String text) {
        return validate(text, NAME);
    }

    public static boolean checkCode(String text) {
        return validate(text, CODE);
    }

    public static boolean checkYear(String text) {
        return validate(text, YEAR);
    }
    public static boolean checkCanTalk(String text) {
        return validate(text, CAN_TALK);
    }
    public static boolean checkWingSpan(String text) {
        return validate(text, WING_SPAN);
    }
    public static boolean isDouble(String value) {
        if (value == null || value.trim().isEmpty()) {
            return false;
        }

        // Chuẩn hoá dấu phẩy thành dấu chấm (người dùng có thể nhập "1,5")
        value = value.trim().replace(",", ".");

        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
