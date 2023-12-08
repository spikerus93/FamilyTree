package study_group.model.service;

import study_group.model.student.Student;
import study_group.model.builder.StudentBuilder;
import study_group.model.group.StudyGroup;

public class Service {
    private StudyGroup<Student> group;
    private StudentBuilder builder;

    public Service() {
        group = new StudyGroup<>();
        builder = new StudentBuilder();
    }

    public void addStudent(String name, int age){
        Student student = builder.build(name, age);
        group.addStudent(student);
    }

    public String getStudentListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список группы: \n");
        for (Student student: group){
            stringBuilder.append(student);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        group.sortByName();
    }

    public void sortByAge(){ group.sortByAge(); }
}
