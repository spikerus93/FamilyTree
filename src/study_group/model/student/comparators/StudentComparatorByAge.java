package study_group.model.student.comparators;

import study_group.model.group.StudyGroupItem;

import java.util.Comparator;

public class StudentComparatorByAge<E extends StudyGroupItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
     //   return o1.getAge() - o2.getAge(); Можно записать так тоже!
    }
}
