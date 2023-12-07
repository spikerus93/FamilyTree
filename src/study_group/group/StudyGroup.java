package study_group.group;

import study_group.student.comparators.StudentComparatorByAge;
import study_group.student.comparators.StudentComparatorByName;
import study_group.student.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class StudyGroup implements Iterable<Student> {
    private List<Student> studentList;

    public StudyGroup() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void sortByName(){
        studentList.sort(new StudentComparatorByName());
    }

    public void sortByAge(){
        Collections.sort(studentList, new StudentComparatorByAge());
//        studentList.sort(new StudentComparatorByAge()); ћожно использовать такую запись.
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentIterator(studentList);
        //return studentList.iterator(); можно использовать напр€мую, но не ¬сегда!!!
    }
}
