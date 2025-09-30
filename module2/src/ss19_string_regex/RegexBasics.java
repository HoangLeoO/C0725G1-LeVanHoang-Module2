package ss19_string_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexBasics {
    public static void main(String[] args) {
        // 1. Ký tự đại diện
        testRegex(".", "a", "Bất kỳ ký tự nào");

        // 2. Bắt đầu và kết thúc chuỗi
        testRegex("^abc", "abcdef", "Bắt đầu bằng 'abc'");
        testRegex("abc$", "xyzabc", "Kết thúc bằng 'abc'");

        // 3. Character classes
        testRegex("[abc]", "a", "Một ký tự trong a, b, c");
        testRegex("[^abc]", "d", "Một ký tự ngoài a, b, c");
        testRegex("[a-z]", "m", "Một chữ cái từ a đến z");
        testRegex("[0-9]", "5", "Một chữ số từ 0 đến 9");

        // 4. Shortcut character classes
        testRegex("\\d", "8", "Chữ số");
        testRegex("\\D", "x", "Không phải chữ số");
        testRegex("\\w", "A", "Chữ cái, số, hoặc _");
        testRegex("\\W", "!", "Không phải \\w");
        testRegex("\\s", " ", "Khoảng trắng");
        testRegex("\\S", "x", "Không phải khoảng trắng");

        // 5. Quantifiers
        testRegex("a*", "", "0 hoặc nhiều a");
        testRegex("a+", "aaa", "1 hoặc nhiều a");
        testRegex("a?", "", "0 hoặc 1 a");
        testRegex("a{3}", "aaa", "Chính xác 3 a");
        testRegex("a{2,4}", "aaa", "2 đến 4 a");

        // 6. Nhóm và OR
        testRegex("(abc|def)", "abc", "abc hoặc def");
        testRegex("(?:abc)", "abc", "Non-capturing group");

        // 7. Lookahead / Lookbehind
        testRegex("a(?=b)", "ab", "a trước b (lookahead)");
        testRegex("a(?!b)", "ac", "a không trước b (negative lookahead)");
        testRegex("(?<=b)a", "ba", "a sau b (lookbehind)");
        testRegex("(?<!b)a", "ca", "a không sau b (negative lookbehind)");

        // 8. Word boundaries
        testRegex("\\bword\\b", "word", "Ranh giới từ");
    }

    private static void testRegex(String regex, String text, String description) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("=== " + description + " ===");
        System.out.println("Text: " + text);
        System.out.println("Regex: " + regex);
        System.out.println("Match: " + matcher.find()); // dùng find() để thấy match trong chuỗi
        System.out.println();
    }
}
