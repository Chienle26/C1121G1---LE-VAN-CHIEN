package ss_case_study_furama_resort.models.services.impl;

import ss_case_study_furama_resort.models.model.Facility;
import ss_case_study_furama_resort.models.model.House;
import ss_case_study_furama_resort.models.model.Room;
import ss_case_study_furama_resort.models.model.Villa;
import ss_case_study_furama_resort.models.services.IFacilityService;
import ss_case_study_furama_resort.utils.ReadAndWriteFileCSV;
import ss_case_study_furama_resort.utils.RegexData;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    Scanner scanner = new Scanner(System.in);
    public static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
    public static Map<Facility, Integer> villaMap = new LinkedHashMap<>();
    public static Map<Facility, Integer> houseMap = new LinkedHashMap<>();
    public static Map<Facility, Integer> roomMap = new LinkedHashMap<>();
    ReadAndWriteFileCSV readAndWriteFileCSV = new ReadAndWriteFileCSV();

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
        String nameServiceVilla = inputName();
        int areaVilla = Integer.parseInt(inputArea());
        int rentalCostsVilla = Integer.parseInt(inputRentalCost());
        int maxPeopleVilla = Integer.parseInt(inputMountPeople());
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
        String nameServiceHouse = inputName();
        int areaHouse = Integer.parseInt(inputArea());
        int rentalCostsHouse = Integer.parseInt(inputRentalCost());
        int maxPeopleHouse = Integer.parseInt(inputMountPeople());
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
        String nameServiceRoom = inputName();
        int areaRoom = Integer.parseInt(inputArea());
        int rentalCostsRoom = Integer.parseInt(inputRentalCost());
        int maxPeopleRoom = Integer.parseInt(inputMountPeople());
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

    private String inputId(){
        System.out.println("Nhập ID và mã dịch vụ: ");
        return RegexData.regexString(scanner.nextLine(),RegexData.REGEX_ID_VILLA,"Bạn đã nhập sai mã định dạng, mã dịch vụ phải có dạng SVVL-XXXX");
    }

    private String inputName(){
        System.out.println("Nhập tên dịch vụ: ");
        return RegexData.regexString(scanner.nextLine(),RegexData.REGEX_STR,"Bạn đã nhập sai định dạng, tên dịch vụ phải viết hoa chữ cái đầu");
    }

    private String inputArea(){
        System.out.println("Nhập diện tích dịch vụ: ");
        return RegexData.regexString(scanner.nextLine(),RegexData.REGEX_AREA,"Bạn đã nhập sai định dạng, diện tích dịch vụ phải lớn hơn 30m2");
    }

    private String inputRentalCost(){
        System.out.println("Nhập chi phí thuê dịch vụ: ");
        return RegexData.regexString(scanner.nextLine(),RegexData.REGEX_INT,"Bạn đã nhập sai định dạng, chi phí thuê dịch vụ phải là một số dương");
    }

    private String inputMountPeople(){
        System.out.println("Nhập số lượng người tối đa của dịch vụ: ");
        return RegexData.regexString(scanner.nextLine(),RegexData.REGEX_AMOUNT,"Bạn đã nhập sai định dạng, số lượng người tối đa phải >0 và nhỏ hơn <20");
    }

    @Override
    public void edit() {

    }

    @Override
    public void returnMainMenu() {

    }
}
