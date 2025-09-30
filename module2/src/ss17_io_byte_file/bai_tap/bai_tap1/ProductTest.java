package ss17_io_byte_file.bai_tap.bai_tap1;


import java.util.ArrayList;
import java.util.List;

public class ProductTest {
    private static final String PATH_FILE = "src/ss17_io_byte_file/bai_tap/bai_tap1/productText.dat";
    public static void main(String[] args) {
        ReadAndWriteByteFile<Project> readAndWriteByteFile = new ReadAndWriteByteFile<>();
        List<Project> projectList = new ArrayList<>();
        projectList.add(new Project("test", "test", 10000, ",test", "test"));
        readAndWriteByteFile.writeFile(PATH_FILE,projectList);
        List<Project> test = new ArrayList<>();
        test = readAndWriteByteFile.readFile(PATH_FILE);
        System.out.println(test.get(0).getName());
    }
}
