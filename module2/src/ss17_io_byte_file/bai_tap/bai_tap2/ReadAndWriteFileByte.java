package util;

import java.io.*;

public class ReadAndWriteFileByte {

    // Phương thức sao chép file nguồn -> file đích
    public static int copyFile(String sourcePath, String targetPath) throws IOException {
        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        if (!sourceFile.exists()) {
            throw new FileNotFoundException("File nguồn không tồn tại: " + sourcePath);
        }

        if (targetFile.exists()) {
            throw new IOException("File đích đã tồn tại: " + targetPath);
        }

        int totalBytes = 0;
        try (
                FileInputStream fis = new FileInputStream(sourceFile);
                FileOutputStream fos = new FileOutputStream(targetFile)
        ) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
                totalBytes += length;
            }
        }
        return totalBytes;
    }
}
