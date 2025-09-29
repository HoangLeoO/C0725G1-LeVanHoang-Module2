package ss16_io_text_file.thuc_hanh.thuc_hanh2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFileText(String filePath) {
        List<Integer> numbers = new ArrayList<>();

        File file = new File(filePath);

        if (!file.exists()) {
            return null;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }

        } catch (Exception e) {
            System.out.println("Loi file r");
        }
        return numbers;
    }

    public void writerFile(String filePath, int numMax) {

        File file = new File(filePath);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("Gia tri lon nhat la " + numMax);
            bw.newLine();
        } catch (Exception e) {
            System.out.println("Loi file w");
        }
    }
}
