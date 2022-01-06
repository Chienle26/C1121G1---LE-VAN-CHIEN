package ss5_access_modifier_static_method_static_property.exercise.set_class_only;

public class TestStudent {
    public static void main(String[] args) {
        Student student = new Student();
        Student student2 = new Student();
        student.setName("Chien");
        student.setClasses("C11");
        student2.setName("Dao");
        student2.setClasses("C12");
//        System.out.println(student.getName());
//        System.out.println(student.getClasses());
//        System.out.println(student2.getName());
//        System.out.println(student2.getClasses());
    }
}
