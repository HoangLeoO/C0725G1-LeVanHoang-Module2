package ss19_string_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexBasics {
    public static void main(String[] args) {
        // 1. Ký tự đại diện / anchors
        testRegex(".", "a", "Bất kỳ ký tự nào");
        testRegex("^abc", "abcdef", "Bắt đầu bằng 'abc'");
        testRegex("abc$", "xyzabc", "Kết thúc bằng 'abc'");
        testRegex("\\bword\\b", "word", "Word boundary");
        testRegex("\\Bword\\B", "sworded", "Không phải word boundary");

        // 2. Character classes
        testRegex("[abc]", "a", "Một ký tự trong a,b,c");
        testRegex("[^abc]", "d", "Một ký tự ngoài a,b,c");
        testRegex("[a-z]", "m", "Chữ cái a-z");
        testRegex("[A-Z]", "M", "Chữ cái A-Z");
        testRegex("[0-9]", "5", "Một chữ số");

        // 3. Shortcut character classes
        testRegex("\\d", "8", "Chữ số");
        testRegex("\\D", "x", "Không phải chữ số");
        testRegex("\\w", "A", "Chữ cái, số hoặc _");
        testRegex("\\W", "!", "Không phải \\w");
        testRegex("\\s", " ", "Khoảng trắng");
        testRegex("\\S", "x", "Không phải khoảng trắng");

        // 4. Quantifiers
        testRegex("a*", "", "0 hoặc nhiều a");
        testRegex("a+", "aaa", "1 hoặc nhiều a");
        testRegex("a?", "", "0 hoặc 1 a");
        testRegex("a{3}", "aaa", "Chính xác 3 a");
        testRegex("a{2,}", "aaaa", "Ít nhất 2 a");
        testRegex("a{2,4}", "aaa", "Từ 2 đến 4 a");

        // 5. Nhóm & OR
        testRegex("(abc|def)", "abc", "abc hoặc def");
        testRegex("(abc|def)", "def", "abc hoặc def");
        testRegex("(?:abc)", "abc", "Non-capturing group");

        // 6. Lookahead / Lookbehind
        testRegex("a(?=b)", "ab", "a trước b (lookahead)");
        testRegex("a(?!b)", "ac", "a không trước b (negative lookahead)");
        testRegex("(?<=b)a", "ba", "a sau b (lookbehind)");
        testRegex("(?<!b)a", "ca", "a không sau b (negative lookbehind)");

        // 7. Escape sequences
        testRegex("\\.", ".", "Dấu chấm");
        testRegex("\\\\", "\\", "Backslash");
        testRegex("\\n", "\n", "Dòng mới");
        testRegex("\\t", "\t", "Tab");

        // 8. Ký hiệu nâng cao
        testRegex("\\Aabc", "abcdef", "Bắt đầu chuỗi (\\A)");
        testRegex("abc\\Z", "xyzabc", "Kết thúc chuỗi (\\Z)");
        testRegex("(?i)abc", "ABC", "Case-insensitive match");
        testRegex("\\p{L}+", "NguyenVanA", "Một hoặc nhiều ký tự chữ (Unicode)");
        testRegex("\\p{N}+", "12345", "Một hoặc nhiều chữ số (Unicode)");
    }

    private static void testRegex(String regex, String text, String description) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("=== " + description + " ===");
        System.out.println("Text: " + (text.equals("\n") ? "\\n" : text.equals("\t") ? "\\t" : text));
        System.out.println("Regex: " + regex);
        System.out.println("Match: " + matcher.find());
        System.out.println();
    }
}
