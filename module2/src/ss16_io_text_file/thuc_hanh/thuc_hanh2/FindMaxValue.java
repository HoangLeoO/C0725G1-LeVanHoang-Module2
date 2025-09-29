package ss16_io_text_file.thuc_hanh.thuc_hanh2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindMaxValue {
    public static void main(String[] args) {
        String fileNumber = "src/ss16_io_text_file/thuc_hanh/thuc_hanh2/number.txt";
        String fileNumberMax = "src/ss16_io_text_file/thuc_hanh/thuc_hanh2/numberMax.txt";
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> integers = readAndWriteFile.readFileText(fileNumber);

        int num = findMax(integers);

        readAndWriteFile.writerFile(fileNumberMax, num);


    }

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }
}
