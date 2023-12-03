package study_group.builder;

import study_group.student.Student;

public class StudentBuilder {
    private int id;
    public Student build(String name, int age){
        return new Student(id++, name, age);
    }
}
