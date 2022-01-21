package ss15_io_text_file.excercise.copy_file_text;

import java.io.*;
import java.util.ArrayList;

public class CopyFileText {
    public static void readAndWriteFileText(String pathFileSource, String pathFileTarget) {
        File fileSource = new File(pathFileSource);
        File fileTarget = new File(pathFileTarget);
        try {
            FileReader fileReader = new FileReader(fileSource);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(fileTarget,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            while ((line=bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.err.println("Lỗi đọc file");
        }
    }

    public static void main(String[] args) {
        CopyFileText.readAndWriteFileText("src/ss15_io_text_file/excercise/copy_file_text/SourceFile.csv",
                "src/ss15_io_text_file/excercise/copy_file_text/TargetFile.csv");
        try {
            File fileTarget = new File("src/ss15_io_text_file/excercise/copy_file_text/TargetFile.csv");
            FileReader fileReader = new FileReader(fileTarget);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line=bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
