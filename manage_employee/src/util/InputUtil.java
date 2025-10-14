package util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner sc = new Scanner(System.in);

    // -------------------- MÃ NHÂN SỰ --------------------
    public static String inputCode() {
        return inputCode(null);
    }

    public static String inputCode(String oldValue) {
        String code;
        do {
            System.out.print("Nhập mã nhân sự" + (oldValue != null ? " (" + oldValue + ")" : "") + ": ");
            code = sc.nextLine().trim();
            if (oldValue != null && code.isEmpty()) return oldValue;
            if (!code.matches(Validate.CODE)) {
                System.out.println("Mã nhân sự không hợp lệ!");
            } else break;
        } while (true);
        return code;
    }

    // -------------------- HỌ TÊN --------------------
    public static String inputName() {
        return inputName(null);
    }

    public static String inputName(String oldValue) {
        String name;
        do {
            System.out.print("Nhập họ tên" + (oldValue != null ? " (" + oldValue + ")" : "") + ": ");
            name = sc.nextLine().trim();
            if (oldValue != null && name.isEmpty()) return oldValue;
            if (!name.matches(Validate.FULL_NAME)) {
                System.out.println("Tên không hợp lệ! Ít nhất 2 từ, mỗi từ bắt đầu bằng chữ hoa, có thể có dấu tiếng Việt.");
            } else break;
        } while (true);
        return name;
    }

    // -------------------- SỐ ĐIỆN THOẠI --------------------
    public static String inputPhone() {
        return inputPhone(null);
    }

    public static String inputPhone(String oldValue) {
        String phone;
        do {
            System.out.print("Nhập số điện thoại" + (oldValue != null ? " (" + oldValue + ")" : "") + ": ");
            phone = sc.nextLine().trim();
            if (oldValue != null && phone.isEmpty()) return oldValue;
            if (!phone.matches(Validate.PHONE)) {
                System.out.println("Số điện thoại không hợp lệ! VD: 09xxxxxxxx hoặc 01xxxxxxxx");
            } else break;
        } while (true);
        return phone;
    }

    // -------------------- NĂM SINH --------------------
    public static int inputYearOfBirth() {
        return inputYearOfBirth(0);
    }

    public static int inputYearOfBirth(int oldValue) {
        int year;
        do {
            System.out.print("Nhập năm sinh" + (oldValue != 0 ? " (" + oldValue + ")" : "") + " (1950–2005): ");
            String line = sc.nextLine().trim();
            if (oldValue != 0 && line.isEmpty()) return oldValue;
            try {
                year = Integer.parseInt(line);
                if (year < 1950 || year > 2005) {
                    System.out.println("Năm sinh không hợp lệ!");
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        } while (true);
        return year;
    }

    // -------------------- LƯƠNG --------------------
    public static double inputSalary() {
        return inputSalary(0);
    }

    public static double inputSalary(double oldValue) {
        double salary;
        do {
            System.out.print("Nhập lương cơ bản" + (oldValue != 0 ? " (" + oldValue + ")" : "") + ": ");
            String line = sc.nextLine().trim();
            if (oldValue != 0 && line.isEmpty()) return oldValue;
            try {
                salary = Double.parseDouble(line);
                if (salary <= 0) {
                    System.out.println("Lương phải lớn hơn 0!");
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        } while (true);
        return salary;
    }

    // -------------------- NGÀY LÀM VIỆC --------------------
    public static int inputWorkingDays() {
        return inputWorkingDays(0);
    }

    public static int inputWorkingDays(int oldValue) {
        int days;
        do {
            System.out.print("Nhập số ngày làm việc" + (oldValue != 0 ? " (" + oldValue + ")" : "") + " (1–31): ");
            String line = sc.nextLine().trim();
            if (oldValue != 0 && line.isEmpty()) return oldValue;
            try {
                days = Integer.parseInt(line);
                if (days < 1 || days > 31) {
                    System.out.println("Số ngày làm việc không hợp lệ!");
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        } while (true);
        return days;
    }

    // -------------------- DOANH SỐ --------------------
    public static double inputSales() {
        return inputSales(0);
    }

    public static double inputSales(double oldValue) {
        double sales;
        do {
            System.out.print("Nhập doanh số bán hàng" + (oldValue != 0 ? " (" + oldValue + ")" : "") + ": ");
            String line = sc.nextLine().trim();
            if (oldValue != 0 && line.isEmpty()) return oldValue;
            try {
                sales = Double.parseDouble(line);
                if (sales < 0) {
                    System.out.println("Doanh số không được âm!");
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        } while (true);
        return sales;
    }
}
