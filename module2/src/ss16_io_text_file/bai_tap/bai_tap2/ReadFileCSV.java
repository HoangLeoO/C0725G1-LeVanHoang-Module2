package ss16_io_text_file.bai_tap.bai_tap2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {
    public static void main(String[] args) {
        List<Test> testList = new ArrayList<>();
        File file = new File("src/ss16_io_text_file/bai_tap/bai_tap2/test.csv");

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = "";
            String[] arr ;
            while ((line = bufferedReader.readLine()) != null){
                arr = line.split(",");
                Test test = new Test(Integer.parseInt(arr[0]),arr[1],arr[2]);
                testList.add(test);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(Test test : testList){
            System.out.println(test.getCode() + " : " + test.getName());
        }
    }
}
