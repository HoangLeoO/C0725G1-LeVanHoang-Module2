package util;

import java.util.Random;

public class CodeGenerator {
    private static final Random random = new Random();

    // Sinh mã nhân sự theo prefix
    public static String generateCode(String prefix) {
        int number = random.nextInt(900) + 100; // 100–999
        return prefix + number;
    }
}
