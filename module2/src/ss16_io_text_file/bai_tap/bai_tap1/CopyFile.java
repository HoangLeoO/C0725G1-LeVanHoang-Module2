package ss16_io_text_file.bai_tap.bai_tap1;



import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) {
        List<String> fileSource = new ArrayList<>();
        fileSource = ReadWriterFile.loadFileText("src/ss16_io_text_file/bai_tap/bai_tap1/source.txt");

        for (String string : fileSource){
            ReadWriterFile.writerFile("src/ss16_io_text_file/bai_tap/bai_tap1/target.txt",string);
        }


    }
}
