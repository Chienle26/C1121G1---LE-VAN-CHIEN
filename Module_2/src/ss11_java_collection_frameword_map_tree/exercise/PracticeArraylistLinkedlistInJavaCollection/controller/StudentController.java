package ss11_java_collection_frameword_map_tree.exercise.PracticeArraylistLinkedlistInJavaCollection.controller;

import ss11_java_collection_frameword_map_tree.exercise.PracticeArraylistLinkedlistInJavaCollection.model.service.IStudentService;
import ss11_java_collection_frameword_map_tree.exercise.PracticeArraylistLinkedlistInJavaCollection.model.service.impl.StudentService;

import java.util.Scanner;

public class StudentController {
    public static void main(String[] args) {
        while (true) {
            IStudentService iStudentService = new StudentService();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Menu ứng dụng quản lý học sinh: ");
            System.out.println("1. Hiển thị danh sách.");
            System.out.println("2. Thêm mới học sinh.");
            System.out.println("3. Chỉnh sửa học sinh.");
            System.out.println("4. Xóa học sinh.");
            System.out.println("5. Tìm kiếm học sinh.");
            System.out.println("6. Sắp xếp danh sách theo tên từ A->Z");
//            System.out.println("7. Sắp xếp danh sách theo tên từ Z->A");

            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    iStudentService.findAll();
                    break;
                case 2:
                    iStudentService.createStudent();
                    break;
                case 3:
                    iStudentService.editStudent();
                    break;
                case 4:
                    iStudentService.removeStudent();
                    break;
                case 5:
                    iStudentService.searchStudent();
                    break;
                case 6:
                    iStudentService.sortByIdFromAToZ();
                    break;
//                case 7:
//                    iStudentService.sortByIdFromZToA();
                default:
                    System.err.println("Bạn chọn chưa đúng menu, xin vui lòng chọn lại!");
            }
        }
    }
}
