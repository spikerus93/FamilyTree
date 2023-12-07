package study_group.student.comparators;

import study_group.group.StudyGroupItem;
import study_group.student.Student;

import java.util.Comparator;

public class StudentComparatorByName<E extends StudyGroupItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
