package ss5_access_modifier_static_method_static_property.exercise.set_class_only;

public class Student {
    private String name = "john";
    private static String classes = "C02";

    public Student (){

    }

    public void setName(String name){
        this.name = name;
    }

    public void setClasses(String classes) {
        Student.classes = classes;
    }

//    public String getName() {
//        return name;
//    }
//
//    public String getClasses() {
//        return classes;
//    }
}
