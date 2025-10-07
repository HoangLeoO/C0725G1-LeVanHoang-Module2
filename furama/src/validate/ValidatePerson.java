package validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePerson {
    public static final String CODE_CUSTOMER = "^KH-(\\d){4}$";
    public static final String CODE_EMPLOYEE = "^NV-(\\d){4}$";
    // Regex cho họ và tên: ít nhất 2 từ, mỗi từ bắt đầu bằng chữ hoa, có thể có dấu tiếng Việt
    public static final String FULL_NAME = "^[A-ZÀ-Ỹ][a-zà-ỹ]+(\\s[A-ZÀ-Ỹ][a-zà-ỹ]+)+$";
    // Regex ngày sinh: định dạng yyyy-MM-dd, ví dụ 1990-12-31
    public static final String BIRTH_DAY = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$";
    // Regex CMND/CCCD: 9 hoặc 12 chữ số
    public static final String ID_CARD = "^\\d{9}|\\d{12}$";
    // Regex số điện thoại Việt Nam: 10 hoặc 11 số, bắt đầu bằng 0
    public static final String PHONE = "^0\\d{9,10}$";
    // Regex email cơ bản: abc@domain.com
    public static final String EMAIL = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
    // Regex địa chỉ: ít nhất 3 ký tự (có thể gồm số, chữ, dấu cách, dấu , . -)
    public static final String ADDRESS = "^[\\w\\s,.-]{3,}$";
    // Regex lương: số thực, có thể có 2 chữ số thập phân
    public static final String SALARY = "^\\d+(\\.\\d{1,2})?$";

    // Hàm dùng chung để check regex
    private static boolean validate(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean checkFullName(String text) {
        return validate(text, FULL_NAME);
    }

    public static boolean checkBirthDay(String text) {
        return validate(text, BIRTH_DAY);
    }

    public static boolean checkIdCard(String text) {
        return validate(text, ID_CARD);
    }

    public static boolean checkPhone(String text) {
        return validate(text, PHONE);
    }

    public static boolean checkEmail(String text) {
        return validate(text, EMAIL);
    }

    public static boolean checkAddress(String text) {
        return validate(text, ADDRESS);
    }

    public static boolean checkSalary(String text) {
        return validate(text, SALARY);
    }

    public static boolean checkCodeCustomer(String text) {
        return validate(text, CODE_CUSTOMER);
    }

    public static boolean checkCodeEmployee(String text) {
        return validate(text, CODE_EMPLOYEE);
    }
}

