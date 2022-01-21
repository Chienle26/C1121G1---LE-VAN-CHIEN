package ss15_io_text_file.excercise.read_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadTextFile {
    public static List<Country> readFile(String pathFile) {
        List<Country> list = new ArrayList<>();
        try {
            File file = new File(pathFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr = null;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                Country country = new Country(arr[0], arr[1], arr[2]);
                list.add(country);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.err.println("File bị lỗi!");
        }
        return list;
    }

    public static void main(String[] args) {
        List<Country> countries = new ArrayList<>();
        countries = ReadTextFile.readFile("src/ss15_io_text_file/excercise/read_file_csv/ListCountry.csv");
        for (Country country : countries) {
            System.out.println(country.getNumbericalOrder() + "." + country.getContry());
        }

    }
}
