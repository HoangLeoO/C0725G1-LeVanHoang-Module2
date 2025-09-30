package ss17_io_byte_file.bai_tap.bai_tap1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteByteFile<T> {

    @SuppressWarnings("unchecked")
    public List<T> readFile(String pathFile) {
        File file = new File(pathFile);

        if (!file.exists()) {
            return new ArrayList<>(); // Nếu file chưa có thì trả list rỗng
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            return (List<T>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Lỗi khi đọc file: " + pathFile, e);
        }
    }

    public void writeFile(String pathFile, List<T> list) {
        File file = new File(pathFile);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(list);
            System.out.println("Ghi file thành công: " + pathFile);
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi ghi file: " + pathFile, e);
        }
    }
}
