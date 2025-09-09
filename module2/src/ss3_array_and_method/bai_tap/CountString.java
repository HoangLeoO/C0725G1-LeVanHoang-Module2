package ss3_array_and_method.bai_tap;

public class CountString {
    public static void main(String[] args) {
        String str = "Hoanghoadeasehy";
        char c = 'h';
        int count = 0 ;
        for (int i = 0 ; i < str.length() ; i++){
            if (str.charAt(i) == c){
                count++;
            }
        }
        System.out.println(count);
    }
}
