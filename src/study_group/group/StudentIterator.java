package study_group.group;

import study_group.student.Student;

import java.util.Iterator;
import java.util.List;

public class StudentIterator implements Iterator<Student> {
    private int index = 0;
    private List<Student> studentList;
    public StudentIterator(List<Student> studentList) {
        this.studentList = studentList;

    }

    @Override
    public boolean hasNext() {
        return index < studentList.size();
    }

    @Override
    public Student next() {
        return studentList.get(index++);
    }
}
