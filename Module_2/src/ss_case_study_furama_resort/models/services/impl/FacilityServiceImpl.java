package ss_case_study_furama_resort.models.services.impl;

import ss_case_study_furama_resort.models.model.Facility;
import ss_case_study_furama_resort.models.model.House;
import ss_case_study_furama_resort.models.model.Room;
import ss_case_study_furama_resort.models.model.Villa;
import ss_case_study_furama_resort.models.services.IFacilityService;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    Scanner scanner = new Scanner(System.in);
    static Map<Facility, Integer> facilityList = new LinkedHashMap<>();
    String regexNameService = "^[A-Z]{1}[a-z]+$";
    Boolean isNameServiceVilla;
    String nameServiceVilla;

    static {
        facilityList.put(new House("WhiteHouse", 100, 1000, 20, "day", "4*", 2), 10);
        facilityList.put(new Room("DeluxRoom", 30, 100, 5, "day", "wifi,park,pool..."), 15);
        facilityList.put(new Villa("HillVilla", 300, 2500, 50, "month", "5*", 50, 2), 6);
    }

    @Override
    public void displayFacilityMaintenance() {
        Set<Facility> keySet = facilityList.keySet();
        for (Facility key : keySet) {
            if (facilityList.get(key) % 5 == 0) {
                System.out.println("Dịch vụ cần bảo trì là " + key + " - Số lần sử dụng: " + facilityList.get(key));
            }
        }
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
            if (!isNameServiceVilla){
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
        facilityList.put(new Villa(nameServiceVilla, areaVilla, rentalCostsVilla, maxPeopleVilla, rentalTypeVilla, roomStandardVilla, poolAreaVilla, numberOfFloorsVilla), 0);
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
        facilityList.put(new House(nameServiceHouse, areaHouse, rentalCostsHouse, maxPeopleHouse, rentalTypeHouse, roomStandardHouse, numberOfFloorsHouse), 0);
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
        facilityList.put(new Room(nameServiceRoom, areaRoom, rentalCostsRoom, maxPeopleRoom, rentalTypeRoom, freeServiceRoom), 0);
        System.err.println("Thêm mới Room thành công!");
    }

    @Override
    public void display() {
        Set<Facility> keySet = facilityList.keySet();
        for (Facility key : keySet) {
            System.out.println(key.toString() + " - Số lần sử dụng: " + facilityList.get(key));
        }
    }

    @Override
    public void edit() {

    }

    @Override
    public void returnMainMenu() {

    }
}
