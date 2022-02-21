package ss_de_thi_that_c11.de_thi_c11.utils;

import ss_de_thi_that_c11.de_thi_c11.models.BenhAn;
import ss_de_thi_that_c11.de_thi_c11.models.BenhAnThuong;
import ss_de_thi_that_c11.de_thi_c11.models.BenhAnVip;

import java.io.*;
import java.util.*;

public class ReadAndWriteFileToCSVC11 {

    public static void writeFileToBenhAn(String pathFile, List<String> stringList, boolean append) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(pathFile, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String string : stringList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<String> readFileBenhAn(String pathFile) {
        List<String> stringList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        FileReader fileReader;
        try {
            fileReader = new FileReader(pathFile);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringList;
    }

    public static List<BenhAn> chuyenStringListSangBenhAnList(List<String> stringList) {
        List<BenhAn> benhAnList = new ArrayList<>();
        String[] stringArray;
        BenhAn.setSoBenhAn(1);
        for (String string : stringList) {
            stringArray = string.split(",");
            if (stringArray.length == 8) {
                BenhAnThuong benhAnThuong = new BenhAnThuong(stringArray[1], stringArray[2],
                        stringArray[3], stringArray[4], stringArray[5], stringArray[6], Double.parseDouble(stringArray[7]));
                benhAnThuong.setSoThuTuBenhAn(Integer.parseInt(stringArray[0]));
                benhAnList.add(benhAnThuong);
            } else if ((stringArray.length == 9)){
                BenhAnVip benhAnVip = new BenhAnVip(stringArray[1], stringArray[2],
                        stringArray[3], stringArray[4], stringArray[5], stringArray[6], stringArray[7], stringArray[8]);
                benhAnVip.setSoThuTuBenhAn(Integer.parseInt(stringArray[0]));
                benhAnList.add(benhAnVip);
            }
        }
        return benhAnList;
    }

    public static List<String> chuyenBenhAnListSangStringList(List<BenhAn> benhAnList) {
        List<String> stringList = new ArrayList<>();
        for (BenhAn benhAn : benhAnList) {
            stringList.add(benhAn.toStringToFileCSV());
        }
        return stringList;
    }

}
