package transport.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static List<String> readFromCSV(String filePath) {
        List<String> listString = new ArrayList<>();
        File file = new File(filePath);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                listString.add(line);
            }
        } catch (Exception e) {
            System.out.println(" Loi doc file !");
        }
        return listString;
    }

    public static void writerToFileCSV(String filePath, List<String> list) {
        File file = new File(filePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (String string : list) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            System.out.println(" Loi ghi file !");
        }
    }

    public static void writerToFileCSV(String filePath, List<String> list, boolean append) {
        File file = new File(filePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, append))) {
            for (String string : list) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            System.out.println(" Loi ghi file !");
        }
    }
}
