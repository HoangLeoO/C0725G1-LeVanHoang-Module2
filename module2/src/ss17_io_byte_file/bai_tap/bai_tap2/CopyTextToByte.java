package ss17_io_byte_file.bai_tap.bai_tap2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyTextToByte {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập file nguồn
        System.out.print("Nhập đường dẫn file nguồn: ");
        String sourcePath = scanner.nextLine();
        File sourceFile = new File(sourcePath);

        if (!sourceFile.exists()) {
            System.out.println("File nguồn không tồn tại!");
            return;
        }

        // Nhập file đích
        System.out.print("Nhập đường dẫn file đích: ");
        String targetPath = scanner.nextLine();
        File targetFile = new File(targetPath);

        if (targetFile.exists()) {
            System.out.println("File đích đã tồn tại!");
            return;
        }

        // Thực hiện sao chép
        try (
                FileInputStream fis = new FileInputStream(sourceFile);
                FileOutputStream fos = new FileOutputStream(targetFile)
        ) {
            byte[] buffer = new byte[1024]; // đọc theo từng khối 1KB
            int length;
            int totalBytes = 0;

            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
                totalBytes += length;
            }

            System.out.println("Sao chép thành công!");
            System.out.println("Tổng số byte đã sao chép: " + totalBytes);

        } catch (IOException e) {
            System.out.println("Lỗi khi sao chép file: " + e.getMessage());
        }
    }
}
