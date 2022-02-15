package ss_case_study_furama_resort.utils;

import java.io.*;
import java.util.Collection;

public class ReadAndWriteFile {

    public static void writeFile(Collection collection, String pathFile) {
        File file = new File(pathFile);
//        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.valueOf(collection));
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readFile(Collection collection, String pathFile) {
        File file = new File(pathFile);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine())!=null){
                System.out.println(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
