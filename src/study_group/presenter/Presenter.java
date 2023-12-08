package study_group.presenter;

import study_group.model.service.Service;
import study_group.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addStudent(String name, int age) {
        service.addStudent(name, age);
        getStudentListInfo();
    }

    public void getStudentListInfo() {
       String answer = service.getStudentListInfo();
       view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByName();
        getStudentListInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getStudentListInfo();
    }
}
