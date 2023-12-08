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
        System.out.println("Приветствие");
        while (work) {
            printMenu();
            choice();
        }
    }

    private void choice() {
        String choiceStr = scanner.nextLine();
        //метод проверки на валидность
        int choice = Integer.parseInt(choiceStr);
        menu.execute(choice);
    }

    private void error() {
        System.out.println("Введено не корректное значение!");
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    public void finish() {
        System.out.println("До новых встреч!");
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
        System.out.println("Укажите Имя Студента: ");
        String name = scanner.nextLine();
        System.out.println("Укажите возраст Студента: ");
        String strAge = scanner.nextLine();
        //метод проверки данных на валидность
        int age = Integer.parseInt(strAge);
        presenter.addStudent(name, age);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);

    }
}
