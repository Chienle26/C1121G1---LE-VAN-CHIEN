package ss_case_study_furama_resort.models.services.impl;

import ss_case_study_furama_resort.models.model.Facility;
import ss_case_study_furama_resort.models.model.House;
import ss_case_study_furama_resort.models.model.Room;
import ss_case_study_furama_resort.models.model.Villa;
import ss_case_study_furama_resort.models.services.IFacilityService;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    Scanner scanner = new Scanner(System.in);
    static Map<Facility,Integer> facilityList = new LinkedHashMap<>();
    static {
        facilityList.put(new House("WhiteHouse",100,1000,20,"day","4*",2),5);
        facilityList.put(new Room("DeluxRoom",30,100,5,"day","wifi,park,pool..."),16);
        facilityList.put(new Villa("HillVilla",300,2500,50,"month","5*",50,2),3);
    }
    @Override
    public void displayFacilityMaintenance() {

    }

    @Override
    public void add() {

    }

    @Override
    public void display() {
        Set<Facility> facilityList = new TreeSet<>();
        for (Facility entry : facilityList){
            System.out.println(entry.getkey);
        }
    }

    @Override
    public void edit() {

    }

    @Override
    public void returnMainMenu() {

    }
}
