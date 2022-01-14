package ss11_java_collection_frameword_map_tree.exercise.PracticeArraylistLinkedlistInJavaCollection.model.service.impl;

import ss11_java_collection_frameword_map_tree.exercise.PracticeArraylistLinkedlistInJavaCollection.model.model.Student;
import ss11_java_collection_frameword_map_tree.exercise.PracticeArraylistLinkedlistInJavaCollection.model.service.IStudentService;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static ArrayList<Student> arrayList = new ArrayList<>();

    static {
        arrayList.add(new Student(1, "Lê Văn Chiến 1", "Đà Nẵng", "26/08/1997", 10, "C1121G1"));
        arrayList.add(new Student(2, "Lê Văn Chiến 2", "Đà Nẵng", "27/08/1997", 9, "C1121G1"));
        arrayList.add(new Student(3, "Lê Văn Chiến 3", "Đà Nẵng", "28/08/1997", 8, "C1121G1"));
    }

    @Override
    public void findAll() {
        for (Student student : arrayList) {
            System.out.println(student);
        }
    }

    @Override
    public void createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mời bạn nhập ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập họ tên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày tháng năm sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Mời bạn nhập điểm: ");
        int point = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập lớp: ");
        String className = scanner.nextLine();
        arrayList.add(new Student(id, name, address, dateOfBirth, point, className));
        System.err.println("Thêm mới thành công!");
    }

    @Override
    public void editStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mời bạn nhập họ tên học sinh cần chỉnh sửa: ");
        String nameSearch = scanner.nextLine();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getName().equals(nameSearch)) {
                System.out.print("Mời bạn nhập ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Mời bạn nhập họ tên: ");
                String name = scanner.nextLine();
                System.out.print("Mời bạn nhập địa chỉ: ");
                String address = scanner.nextLine();
                System.out.print("Mời bạn nhập ngày tháng năm sinh: ");
                String dateOfBirth = scanner.nextLine();
                System.out.print("Mời bạn nhập điểm: ");
                int point = Integer.parseInt(scanner.nextLine());
                System.out.print("Mời bạn nhập lớp: ");
                String className = scanner.nextLine();
                arrayList.get(i).setId(id);
                arrayList.get(i).setName(name);
                arrayList.get(i).setAddress(address);
                arrayList.get(i).setDateOfBirth(dateOfBirth);
                arrayList.get(i).setPoint(point);
                arrayList.get(i).setClassName(className);
                System.err.println("Chỉnh sửa thành công!");
            } else {
                System.out.println("Không có tên bạn vừa nhập trong danh sách, xin vui lòng nhập lại!");
            }
        }
    }

    @Override
    public void removeStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mời bạn nhập họ tên học sinh cần xóa: ");
        String name = scanner.nextLine();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getName().equals(name)) {
                arrayList.remove(i);
                System.err.println("Xóa thành công!");
            } else {
                System.out.println("Không có tên bạn vừa nhập trong danh sách, xin vui lòng nhập lại!");
            }
        }
    }
}
