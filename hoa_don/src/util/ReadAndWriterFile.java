package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriterFile {
    public static List<String> readFile(String pathFile) {
        List<String> result = new ArrayList<>();
        File file = new File(pathFile);
        if (!file.exists()) {
            return result;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
        } catch (Exception e){
            System.out.println(" Lỗi đọc file ! ");
        }

        return result;
    }

    public static void writerFile(String pathFile, List<String> strings) {
        File file = new File(pathFile);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (String string : strings) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            System.out.println(" Lỗi ghi file ! ");
        }
    }
    public static void writerFile(String pathFile, List<String> strings,Boolean append) {
        File file = new File(pathFile);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,append))) {
            for (String string : strings) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            System.out.println(" Lỗi ghi file ! ");
        }
    }

}