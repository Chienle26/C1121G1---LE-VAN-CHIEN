package ss11_java_collection_frameword_map_tree.exercise.PracticeArraylistLinkedlistInJavaCollection.model.model;

import java.util.Comparator;

public class ComparatorWithID implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getId()- o2.getId();
    }
}
