package ss16_io_binary_file_and_serialization.exercise.product_management_binary_file.util;

import ss16_io_binary_file_and_serialization.exercise.product_management_binary_file.model.model.SmartPhone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFromBinaryFile {
    public static List<SmartPhone> readBinaryFile(String pathFile) {
        List<SmartPhone> smartPhoneList = new ArrayList<>();
        File file = new File(pathFile);
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            if (file.length()>0){
                objectInputStream = new ObjectInputStream(fileInputStream);
                smartPhoneList = (ArrayList<SmartPhone>)objectInputStream.readObject();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return smartPhoneList;
    }
}
