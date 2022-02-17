package ss_case_study_furama_resort.models.services.impl;

import ss_case_study_furama_resort.models.model.Facility;
import ss_case_study_furama_resort.models.model.House;
import ss_case_study_furama_resort.models.model.Room;
import ss_case_study_furama_resort.models.model.Villa;
import ss_case_study_furama_resort.models.services.IFacilityService;
import ss_case_study_furama_resort.utils.ReadAndWriteFileCSV;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    Scanner scanner = new Scanner(System.in);
    public static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
    public static Map<Facility, Integer> villaMap = new LinkedHashMap<>();
    public static Map<Facility, Integer> houseMap = new LinkedHashMap<>();
    public static Map<Facility, Integer> roomMap = new LinkedHashMap<>();
    ReadAndWriteFileCSV readAndWriteFileCSV = new ReadAndWriteFileCSV();
    Villa villa = new Villa();
    String pathFileVilla = "src/ss_case_study_furama_resort/data/Villa.csv";
    String regexNameService = "^[A-Z]{1}[a-z]+$";
    Boolean isNameServiceVilla;
    String nameServiceVilla;

    @Override
    public void displayFacilityMaintenance() {
        villaMap = readAndWriteFileCSV.readFacilityToCSV(ReadAndWriteFileCSV.VILLA_FILE);
        houseMap = readAndWriteFileCSV.readFacilityToCSV(ReadAndWriteFileCSV.HOUSE_FILE);
        roomMap = readAndWriteFileCSV.readFacilityToCSV(ReadAndWriteFileCSV.ROOM_FILE);
        facilityMap.putAll(villaMap);
        facilityMap.putAll(houseMap);
        facilityMap.putAll(roomMap);

        Set<Facility> keySet = facilityMap.keySet();
        for (Facility key : keySet) {
            if (facilityMap.get(key) % 5 == 0 && facilityMap.get(key) != 0) {
                System.out.println("Dịch vụ cần bảo trì là " + key + " - Số lần sử dụng: " + facilityMap.get(key));
            }
        }

        facilityMap.clear();
    }

    @Override
    public void add() {
    }


    @Override
    public void addVilla() {
        do {
            System.out.print("Nhập tên Villa: ");
            nameServiceVilla = scanner.nextLine();
            isNameServiceVilla = nameServiceVilla.matches(regexNameService);
            if (!isNameServiceVilla) {
                System.out.println("Vui lòng nhập lại tên Villa!");
            }
        } while (!isNameServiceVilla);
        System.out.print("Nhập diện tích Villa: ");
        int areaVilla = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập chi phí thuê Villa: ");
        int rentalCostsVilla = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập số người tối đa ở Villa: ");
        int maxPeopleVilla = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập kiểu thuê Villa: ");
        String rentalTypeVilla = scanner.nextLine();
        System.out.print("Nhập tiêu chuẩn phòng của Villa: ");
        String roomStandardVilla = scanner.nextLine();
        System.out.print("Nhập diện tích hồ bơi của Villa: ");
        int poolAreaVilla = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập số tầng của Villa: ");
        int numberOfFloorsVilla = Integer.parseInt(scanner.nextLine());
        villaMap = new HashMap<>();
        Villa villa = new Villa(nameServiceVilla, areaVilla, rentalCostsVilla, maxPeopleVilla, rentalTypeVilla, roomStandardVilla, poolAreaVilla, numberOfFloorsVilla);
        villaMap.put(villa, 0);
        readAndWriteFileCSV.writeFacilityToCSV(villaMap, ReadAndWriteFileCSV.VILLA_FILE, true);
        System.err.println("Thêm mới Villa thành công!");
    }

    @Override
    public void addHouse() {
        System.out.print("Nhập tên House: ");
        String nameServiceHouse = scanner.nextLine();
        System.out.print("Nhập diện tích House: ");
        int areaHouse = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập chi phí thuê House: ");
        int rentalCostsHouse = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập số người tối đa ở House: ");
        int maxPeopleHouse = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập kiểu thuê House: ");
        String rentalTypeHouse = scanner.nextLine();
        System.out.print("Nhập tiêu chuẩn phòng của House: ");
        String roomStandardHouse = scanner.nextLine();
        System.out.print("Nhập số tầng của House: ");
        int numberOfFloorsHouse = Integer.parseInt(scanner.nextLine());
        houseMap = new HashMap<>();
        House house = new House(nameServiceHouse, areaHouse, rentalCostsHouse, maxPeopleHouse, rentalTypeHouse, roomStandardHouse, numberOfFloorsHouse);
        houseMap.put(house, 0);
        readAndWriteFileCSV.writeFacilityToCSV(houseMap, ReadAndWriteFileCSV.HOUSE_FILE, true);
        System.err.println("Thêm mới House thành công!");
    }

    @Override
    public void addRoom() {
        System.out.print("Nhập tên Room: ");
        String nameServiceRoom = scanner.nextLine();
        System.out.print("Nhập diện tích Room: ");
        int areaRoom = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập chi phí thuê Room: ");
        int rentalCostsRoom = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập số người tối đa ở Room: ");
        int maxPeopleRoom = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập kiểu thuê Room: ");
        String rentalTypeRoom = scanner.nextLine();
        System.out.print("Nhập dịch vụ miễn phí đi kèm của Room: ");
        String freeServiceRoom = scanner.nextLine();
        roomMap = new HashMap<>();
        Room room = new Room(nameServiceRoom, areaRoom, rentalCostsRoom, maxPeopleRoom, rentalTypeRoom, freeServiceRoom);
        roomMap.put(room, 0);
        readAndWriteFileCSV.writeFacilityToCSV(roomMap, ReadAndWriteFileCSV.ROOM_FILE, true);
        System.err.println("Thêm mới Room thành công!");
    }

    @Override
    public void display() {
        villaMap = readAndWriteFileCSV.readFacilityToCSV(ReadAndWriteFileCSV.VILLA_FILE);
        houseMap = readAndWriteFileCSV.readFacilityToCSV(ReadAndWriteFileCSV.HOUSE_FILE);
        roomMap = readAndWriteFileCSV.readFacilityToCSV(ReadAndWriteFileCSV.ROOM_FILE);

        if (!villaMap.isEmpty()) {
            Set<Facility> key = villaMap.keySet();

            System.out.println("------------------------------VILLA LIST------------------------------");
            for (Facility facility : key) {
                System.out.println(facility + ", number of hires is: " + villaMap.get(facility));
            }
        }

        if (!houseMap.isEmpty()) {
            Set<Facility> key = houseMap.keySet();

            System.out.println("------------------------------HOUSE LIST------------------------------");
            for (Facility facility : key) {
                System.out.println(facility + ", number of hires is: " + houseMap.get(facility));
            }
        }

        if (!roomMap.isEmpty()) {
            Set<Facility> key = roomMap.keySet();

            System.out.println("------------------------------ROOM LIST------------------------------");
            for (Facility facility : key) {
                System.out.println(facility + ", number of hires is: " + roomMap.get(facility));
            }
        }

    }

    @Override
    public void edit() {

    }

    @Override
    public void returnMainMenu() {

    }
}
