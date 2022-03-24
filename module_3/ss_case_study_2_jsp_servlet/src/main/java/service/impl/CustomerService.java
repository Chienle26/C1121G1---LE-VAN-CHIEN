package service.impl;

import model.Customer;
import model.CustomerDTO;
import repository.ICustomerRepo;
import repository.impl.CustomerRepo;
import service.ICustomerService;
import service.Regex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    ICustomerRepo iCustomerRepo = new CustomerRepo();
    Regex regex = new Regex();
    @Override
    public List<Customer> findAll() {
        return this.iCustomerRepo.findAll();
    }

    @Override
    public List<CustomerDTO> findAllDTO() {
        return iCustomerRepo.findAllDTO();
    }

    @Override
    public void createCustomer(Customer customer) {
        this.iCustomerRepo.createCustomer(customer);
    }

    public Map<String,String> createCustomerRegex(Customer customer){
        Map<String,String> map = new HashMap<>();
        boolean check = true;
        if (!customer.getEmail().matches(regex.EMAIL)){
            map.put("email","Sai định dạng email (VD: ab_A.c123@gmail.com)");
            check = false ;
        }
        if(iCustomerRepo.checkCustomerCodeExist(customer.getCustomerCode())){
            map.put("customerCodeExit","Đã tồn tại mã khách hàng này");
            check = false ;
        }
        if(!customer.getCustomerCode().matches(Regex.MA_KHACH_HANG)){
            map.put("customerCode","Sai định dạng  (vd : KH-0001)");
            check = false ;
        }
        if(!customer.getName().matches(Regex.NAME_VIETNAM)){
            map.put("name","Sai định dạng họ tên (vd : Lê Văn Chiến)");
            check = false ;
        }
        if(!customer.getDateOfBirth().matches(Regex.YYYY_MM_DD)){
            map.put("dateOfBirth","Sai định dạng ngày sinh (vd : 2000-02-28");
            check = false ;
        } else {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate ngaySinh = LocalDate.parse(customer.getDateOfBirth(),fmt);
            LocalDate now = LocalDate.now();
            if(now.compareTo(ngaySinh) < 18){
                map.put("dateOfBirth","Khách hàng phải lớn hơn 18 tuổi");
                check = false ;
            }
        }
        if(!(customer.getIDNumber().matches(Regex.SO_CMND))){
            map.put("IDNumber","Sai định dạng CMND (VD : 025871516 ");
            check = false ;
        }
        if(!customer.getPhoneNumber().matches(Regex.SO_DIEN_THOAI)){
            map.put("phoneNumber","Sai định dạng ( vd : 090 XXXXXXX , 091 XXXXXXX , (84)+90 XXXXXXX , (84)+91 XXXXXXX ) ");
            check = false ;
        }

        if (check){
            this.iCustomerRepo.createCustomer(customer);
        }

        return map;
    }

    @Override
    public Customer findCustomerById(String id) {
        return iCustomerRepo.findCustomerById(id);
    }

    @Override
    public void editCustomer(Customer customer) {
        iCustomerRepo.editCustomer(customer);
    }

    public Map<String,String> editCustomerRegex(Customer customer){
        Map<String,String> map = new HashMap<>();
        boolean check = true;
        if (!customer.getEmail().matches(regex.EMAIL)){
            map.put("email","Sai định dạng email (VD: ab_A.c123@gmail.com)");
        }
//        if(iCustomerRepo.checkCustomerCodeExist(customer.getCustomerCode())){
//            map.put("customerCodeExit","Đã tồn tại mã khách hàng này");
//            check = false ;
//        }
        if(!customer.getCustomerCode().matches(Regex.MA_KHACH_HANG)){
            map.put("customerCode","Sai định dạng  (vd : KH-0001)");
            check = false ;
        }
        if(!customer.getName().matches(Regex.NAME_VIETNAM)){
            map.put("name","Sai định dạng họ tên (vd : Lê Văn Chiến)");
            check = false ;
        }
        if(!customer.getDateOfBirth().matches(Regex.YYYY_MM_DD)){
            map.put("dateOfBirth","Sai định dạng ngày sinh (vd : 2000-02-28");
            check = false ;
        } else {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate ngaySinh = LocalDate.parse(customer.getDateOfBirth(),fmt);
            LocalDate now = LocalDate.now();
            if(now.compareTo(ngaySinh) < 18){
                map.put("dateOfBirth","Khách hàng phải lớn hơn 18 tuổi");
                check = false ;
            }
        }
        if(!(customer.getIDNumber().matches(Regex.SO_CMND))){
            map.put("IDNumber","Sai định dạng CMND (VD : 025871516 ");
            check = false ;
        }
        if(!customer.getPhoneNumber().matches(Regex.SO_DIEN_THOAI)){
            map.put("phoneNumber","Sai định dạng ( vd : 090 XXXXXXX , 091 XXXXXXX , (84)+90 XXXXXXX , (84)+91 XXXXXXX ) ");
            check = false ;
        }

        if (check){
            this.iCustomerRepo.editCustomer(customer);
        }

        return map;
    }

    @Override
    public void deleteCustomer(Integer id) {
        iCustomerRepo.deleteCustomer(id);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return iCustomerRepo.searchByName(name);
    }
}
