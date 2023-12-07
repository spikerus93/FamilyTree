package study_group.group;

import study_group.student.comparators.StudentComparatorByAge;
import study_group.student.comparators.StudentComparatorByName;
import study_group.student.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class StudyGroup<E extends StudyGroupItem> implements Iterable<E> {
    private List<E> studentList;

    public StudyGroup() {
        studentList = new ArrayList<>();
    }

    public void addStudent(E student) {
        studentList.add(student);
    }

    public void sortByName(){
        studentList.sort(new StudentComparatorByName<>());
    }

    public void sortByAge(){
        studentList.sort(new StudentComparatorByAge<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new StudentIterator<>(studentList);
        //return studentList.iterator(); можно использовать напр€мую, но не ¬сегда!!!
    }
}
