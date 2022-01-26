package ss_case_study_furama_resort.models.services.impl;

import ss11_java_collection_frameword_map_tree.exercise.PracticeArraylistLinkedlistInJavaCollection.model.model.Person;
import ss_case_study_furama_resort.models.model.Employee;
import ss_case_study_furama_resort.models.services.IEmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    static List<Employee> employeeList = new ArrayList<>();
    static {
        employeeList.add(new Employee(11111,"Lê Văn Chiến","1/1/2011","Nam",123456789,708313527,"chienle@gmail.com","Đại học","Web Dev",1000));
        employeeList.add(new Employee(22222,"Lê Văn Chiến2","1/1/2011","Nam",123456789,708313527,"chienle@gmail.com","Đại học","Web Dev",1000));
    }
    @Override
    public void add() {
        for (Employee employee:employeeList ){
            System.out.println(employee.toString());
        }
    }

    @Override
    public void display() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void returnMainMenu() {

    }
}
