package study_group.view;

import study_group.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("�����������");
        while (work) {
            printMenu();
            choice();
        }
    }

    private void choice() {
        String choiceStr = scanner.nextLine();
        //����� �������� �� ����������
        int choice = Integer.parseInt(choiceStr);
        menu.execute(choice);
    }

    private void error() {
        System.out.println("������� �� ���������� ��������!");
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    public void finish() {
        System.out.println("�� ����� ������!");
        work = false;

    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getStudentListInfo() {
        presenter.getStudentListInfo();
    }

    public void addStudent() {
        System.out.println("������� ��� ��������: ");
        String name = scanner.nextLine();
        System.out.println("������� ������� ��������: ");
        String strAge = scanner.nextLine();
        //����� �������� ������ �� ����������
        int age = Integer.parseInt(strAge);
        presenter.addStudent(name, age);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);

    }
}
