package study_group;

import study_group.model.service.Service;
import study_group.view.ConsoleUI;
import study_group.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
        //Service service = new Service();
       // System.out.println(service);

//        service.addStudent("����", 18);
//        service.addStudent("����", 19);
//        service.addStudent("����", 20);
//        service.addStudent("����", 18);
//        service.addStudent("���", 22);
//
//        System.out.println(service.getStudentListInfo());
//
//        service.sortByName();
//        System.out.println(service.getStudentListInfo());
//
//        service.sortByAge();
//        System.out.println(service.getStudentListInfo());


    }
}
