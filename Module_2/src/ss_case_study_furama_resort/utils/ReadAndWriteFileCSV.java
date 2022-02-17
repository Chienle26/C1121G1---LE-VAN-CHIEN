package ss_case_study_furama_resort.utils;

import ss_case_study_furama_resort.models.model.*;

import java.io.*;
import java.util.*;

public class ReadAndWriteFileCSV {
    public static final String VILLA_FILE = "src/ss_case_study_furama_resort/data/Villa.csv";
    public static final String HOUSE_FILE = "src/ss_case_study_furama_resort/data/House.csv";
    public static final String ROOM_FILE = "src/ss_case_study_furama_resort/data/Room.csv";
    public static final String BOOKING_FILE = "src/ss_case_study_furama_resort/data/Booking.csv";
    public static final String BOOKING_FILE_COPY = "src/ss_case_study_furama_resort/data/BookingCopy.csv";
    public static final String CONTRACT_FILE = "src/ss_case_study_furama_resort/data/Contract.csv";

    public static void writeContractToCSV(Queue<Contract> contractQueue, String pathFile, Boolean append) {
        List<String> list = new ArrayList<>();
        for (Contract element : contractQueue) {
            list.add(element.getStringContract());
        }
        stringList(list, pathFile, append);
    }

    public static Queue<Contract> readContractToCSV(String pathFile) {
        Contract.setNumber(1);
        Queue<Contract> contractQueue = new LinkedList<>();
        Set<Booking> bookingSet = readBookingToCSV(BOOKING_FILE_COPY);
        try {
            File file = new File(pathFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr = null;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                for (Booking element : bookingSet) {
                    if (element.getBookingCode() == Integer.parseInt(arr[1])) {
                        Contract contract = new Contract(element, Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), element);
                        contractQueue.add(contract);
                    }
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contractQueue;
    }

    public static void writeBookingToCSV(Set<Booking> bookingSet, String pathFile, Boolean append) {
        List<Booking> bookingList = new ArrayList<>(bookingSet);
        List<String> list = new ArrayList<>();
        for (Booking element : bookingList) {
            list.add(element.getStringBooking());
        }
        stringList(list, pathFile, append);
    }

    public static Set<Booking> readBookingToCSV(String pathFile) {
        Set<Booking> bookingSet = new TreeSet<>();
        try {
            File file = new File(pathFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr = null;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                Booking booking = new Booking(Integer.parseInt(arr[0]), arr[1], arr[2], Integer.parseInt(arr[3]), arr[4], arr[5]);
                bookingSet.add(booking);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookingSet;
    }

    public static void writeFacilityToCSV(Map<Facility, Integer> facilityMap, String pathFile, boolean append) {
        List<Facility> facilityList = new ArrayList<>(facilityMap.keySet());
        List<String> list = new ArrayList<>();
        for (Facility element : facilityList) {
            list.add(element.getStringFacility() + "," + facilityMap.get(element));
        }
        stringList(list, pathFile, append);
    }

    //    method chung cho ghi file
    public static void stringList(List<String> stringList, String pathFile, Boolean append) {
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String element : stringList) {
                bufferedWriter.write(element);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Map<Facility, Integer> readFacilityToCSV(String pathFile) {
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        File file = new File(pathFile);

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arr = null;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                if (pathFile.equals(VILLA_FILE)) {
                    Villa villa = new Villa(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]),
                            Integer.parseInt(arr[3]), arr[4], arr[5], Integer.parseInt(arr[6]), Integer.parseInt(arr[7]));
                    facilityIntegerMap.put(villa, Integer.parseInt(arr[8]));
                } else if (pathFile.equals(HOUSE_FILE)) {
                    House house = new House(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]),
                            Integer.parseInt(arr[3]), arr[4], arr[5], Integer.parseInt(arr[6]));
                    facilityIntegerMap.put(house, Integer.parseInt(arr[7]));
                } else if (pathFile.equals(ROOM_FILE)) {
                    Room room = new Room(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]),
                            Integer.parseInt(arr[3]), arr[4], arr[5]);
                    facilityIntegerMap.put(room, Integer.parseInt(arr[6]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facilityIntegerMap;
    }

    public static List<String> readFileCSV(String path) {
        List<String> list = new ArrayList<>();
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void writeFileCSV(String path, List<String> list, boolean append) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String element : list) {
                bufferedWriter.write(element);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T> List<String> changeToStringList(List<T> list) {
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Person) {
                stringList.add(((Person) list.get(i)).getStringPerson());
            }
            if (list.get(i) instanceof Facility) {
                stringList.add(((Facility) list.get(i)).getStringFacility());
            }
            if (list.get(i) instanceof Booking) {
                stringList.add(((Booking) list.get(i)).getStringBooking());
            }
            if (list.get(i) instanceof Contract) {
                stringList.add(((Contract) list.get(i)).getStringContract());
            }
        }
        return stringList;
    }
}
