package ss19_string_regex.bai_tap;

public class ValidateNameClass {
    public static void main(String[] args) {
        System.out.println(validateNameClass("C0223G"));
    }
    public static boolean validateNameClass(String name){
        String regex = "^[ACP]\\d{4}[GHIK]$";
        return name.matches(regex);
    }
}
