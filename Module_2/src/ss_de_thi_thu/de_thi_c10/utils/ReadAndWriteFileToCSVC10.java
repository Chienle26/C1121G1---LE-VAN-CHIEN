package ss_de_thi_thu.de_thi_c10.utils;

import ss_de_thi_thu.de_thi_c10.models.SanPham;
import ss_de_thi_thu.de_thi_c10.models.SanPhamNhapKhau;
import ss_de_thi_thu.de_thi_c10.models.SanPhamXuatKhau;

import java.io.*;
import java.util.*;

public class ReadAndWriteFileToCSVC10 {

    public static void writeFileToSanPham(String pathFile, List<String> stringList, boolean append) {
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

    public static List<String> readFileSanPham(String pathFile) {
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

    public static List<SanPham> chuyenStringListSangSanPhamList(List<String> stringList){
        List<SanPham> sanPhamList = new ArrayList<>();
        String[] stringArray;
        SanPham.setSoSanPham(1);
        for (String string : stringList) {
            stringArray = string.split(",");
            if (stringArray.length == 9) {
                SanPhamNhapKhau sanPhamNhapKhau = new SanPhamNhapKhau(stringArray[1], stringArray[2],
                        Double.parseDouble(stringArray[3]), Integer.parseInt(stringArray[4]), stringArray[5],
                        Double.parseDouble(stringArray[6]), stringArray[7], Double.parseDouble(stringArray[8]));
                sanPhamNhapKhau.setIdSanPham(Integer.parseInt(stringArray[0]));
                sanPhamList.add(sanPhamNhapKhau);
            } else {
                SanPhamXuatKhau sanPhamXuatKhau = new SanPhamXuatKhau(stringArray[1], stringArray[2],
                        Double.parseDouble(stringArray[3]), Integer.parseInt(stringArray[4]), stringArray[5],
                        Double.parseDouble(stringArray[6]), stringArray[7]);
                sanPhamXuatKhau.setIdSanPham(Integer.parseInt(stringArray[0]));
                sanPhamList.add(sanPhamXuatKhau);
            }
        }
        return sanPhamList;
    }

    public static List<String> chuyenSanPhamListSangStringList(List<SanPham> sanPhamList){
        List<String> stringList = new ArrayList<>();
        for (SanPham sanPham : sanPhamList) {
            stringList.add(sanPham.toStringToFileCSV());
        }
        return stringList;
    }

//    Ghi file chung
//    public static void writeStringListToCSV(List<String> stringList, String pathFile, Boolean append) {
//        File file = new File(pathFile);
//        try {
//            FileWriter fileWriter = new FileWriter(file, append);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            for (String element : stringList) {
//                bufferedWriter.write(element);
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.flush();
//            bufferedWriter.close();
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
