package ss11_java_collection_frameword_map_tree.exercise.PracticeArraylistLinkedlistInJavaCollection.util;

import ss11_java_collection_frameword_map_tree.exercise.PracticeArraylistLinkedlistInJavaCollection.model.model.Student;

import java.util.Comparator;

public class ComparatorByIdFromZToA implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getId() == o2.getId()) {
            return o1.getName().compareTo(o2.getName());
        } else {
            return o1.getId() - o2.getId();
        }
    }
}
