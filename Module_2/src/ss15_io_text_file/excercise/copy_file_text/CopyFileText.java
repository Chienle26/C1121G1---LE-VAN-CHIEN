package ss15_io_text_file.excercise.copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CopyFileText {
    public static int readAndWriteFileText(String pathFileSource, String pathFileTarget) {
        File fileSource = new File(pathFileSource);
        File fileTarget = new File(pathFileTarget);
        int count = 0;
        //Cách 1: Dùng FileRead-Writer để đọc ghi từng ký tự
        try {
            FileReader fileReader = new FileReader(fileSource);
            FileWriter fileWriter = new FileWriter(fileTarget, false);
            int character;
            while ((character = fileReader.read()) != -1) {
                if (character != 10 && character != 13) {
                    count++;
                }
                fileWriter.write((char) character);
            }
            fileReader.close();
            fileWriter.close();

        } catch (IOException e) {
            System.err.println("File bị lỗi!");
        }
        return count;


        //Cách 2: Dùng BufferedReader-Writer để đọc-ghi từng dòng
        /*try {
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
        }*/
    }

    public static void main(String[] args) {
        int chars = CopyFileText.readAndWriteFileText("src/ss15_io_text_file/excercise/copy_file_text/SourceFile.csv",
                "src/ss15_io_text_file/excercise/copy_file_text/TargetFile.csv");
        try {
            File fileTarget = new File("src/ss15_io_text_file/excercise/copy_file_text/TargetFile.csv");
            FileReader fileReader = new FileReader(fileTarget);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Số ký tự trong tệp là: " + chars);
    }
}
