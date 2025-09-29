package ss16_io_text_file.bai_tap.bai_tap1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriterFile {
    public static List<String> loadFileText(String filePath) {
        List<String> result = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File không tồn tại: " + filePath);
            return result;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equals("")) {
                    result.add(line);
                }
            }
        } catch (Exception e) {
            System.out.println(" Loi doc file " + e);
        }
        return result;
    }

    public static void writerFile(String filePath, String str) {
        File file = new File(filePath);

        if (!file.exists()) {
            return;
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        } catch (Exception e) {
            System.out.println(" Loi ghi file " + e);
        }
    }

}
