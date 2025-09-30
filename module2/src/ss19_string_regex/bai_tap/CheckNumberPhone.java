package ss19_string_regex.bai_tap;

public class CheckNumberPhone {
    public static void main(String[] args) {
        String regex = "^(84)-(0)[0-9]{9}";
        String phone = "84-0978489648";
        System.out.println(phone.matches(regex));
    }
}
