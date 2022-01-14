package ss11_java_collection_frameword_map_tree.exercise.PracticeArraylistLinkedlistInJavaCollection.model.model;

import java.util.Comparator;

public class Student extends Person implements Comparable<Student>, Comparator<Student> {
    private int point;
    private String className;

    public Student() {
    }

    public Student(int point, String className) {
        this.point = point;
        this.className = className;
    }

    public Student(int id, String name, String address, String dateOfBirth, int point, String className) {
        super(id, name, address, dateOfBirth);
        this.point = point;
        this.className = className;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", point=" + point +
                ", className='" + className + '\'';
    }

    @Override
    public int compareTo(Student o) {
        if (this.getId() == o.getId()) {
            return this.getName().compareTo(o.getName());
        } else {
            return this.getId() - o.getId();
        }
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getId() == o2.getId()) {
            return o1.getName().compareTo(o2.getName());
        } else {
            return o1.getId() - o2.getId();
        }
    }
}
