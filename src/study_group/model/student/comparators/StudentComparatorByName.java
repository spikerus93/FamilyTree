package study_group.model.student.comparators;

import study_group.model.group.StudyGroupItem;

import java.util.Comparator;

public class StudentComparatorByName<E extends StudyGroupItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
