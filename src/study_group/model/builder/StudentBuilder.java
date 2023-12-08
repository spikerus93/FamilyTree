package study_group.model.builder;

import study_group.model.student.Student;

public class StudentBuilder {
    private int id;
    public Student build(String name, int age){
        return new Student(id++, name, age);
    }
}
