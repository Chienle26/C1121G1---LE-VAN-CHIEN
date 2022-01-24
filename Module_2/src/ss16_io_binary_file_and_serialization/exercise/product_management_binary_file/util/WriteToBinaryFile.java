package ss16_io_binary_file_and_serialization.exercise.product_management_binary_file.util;

import ss16_io_binary_file_and_serialization.exercise.product_management_binary_file.model.model.SmartPhone;

import java.io.*;
import java.util.List;

public class WriteToBinaryFile {
    public static void writeBinaryFile(List<SmartPhone> smartPhoneList, String pathFile){
        File file = new File(pathFile);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(smartPhoneList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null){
                    objectOutputStream.close();
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
