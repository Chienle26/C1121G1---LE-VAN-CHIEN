package ss9_dsa_array_list_linked_list.exercise.my_array_list;

public class MyArrayListTest {
    public static class Student {
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "Le Van Chien1");
        Student student2 = new Student(2, "Le Van Chien2");
        Student student3 = new Student(3, "Le Van Chien3");
        Student student4 = new Student(4, "Le Van Chien4");
        Student student5 = new Student(5, "Le Van Chien5");
        Student student6 = new Student(6, "Le Van Chien6");

        MyArrayList<Student> studentMyArrayList = new MyArrayList<>();
        studentMyArrayList.add(student1);
        studentMyArrayList.add(student2);
        studentMyArrayList.add(student3);
        studentMyArrayList.add(student4);
        studentMyArrayList.add(student5);

        studentMyArrayList.add(student6,2);

        System.out.println(studentMyArrayList.size());

        System.out.println(studentMyArrayList.get(2));



        for (int i = 0; i < studentMyArrayList.size(); i++) {
            Student student = (Student) studentMyArrayList.elements[i];
            System.out.println(student.getId());
            System.out.println(student.getName());
            System.out.println();
        }

    }
}
