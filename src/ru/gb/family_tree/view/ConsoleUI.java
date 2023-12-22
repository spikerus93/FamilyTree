package ru.gb.family_tree.view;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.writer.FileHandler;
import ru.gb.family_tree.presenter.Presenter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;


public class ConsoleUI implements View{
    private final Presenter presenter;
    private final Scanner scanner;
    private  boolean work;
    private final MainMenu menu;

    public ConsoleUI(){
        this.scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() throws IOException {
        hello();
        while (work){
            setMenu();
            choice();
        }
    }

    private void choice() throws IOException {
        String value = scanner.nextLine();
        if (checkMenu(value)) {
            int num = Integer.parseInt(value);
            menu.execute(num);
        }
    }

    private boolean checkMenu(String text) {
        try {
            if (Integer.parseInt(text) > 0 && Integer.parseInt(text) <= menu.getSize()) {
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("������! �������� �����������!");
        return false;
    }

    public void finish() {
        System.out.println("�� ��������!");
        scanner.close();
        work = false;
    }

    private void setMenu() {
        System.out.println("�������� �����: ");
        System.out.println(menu.menu());
    }

    public void addHuman() {
        System.out.println("������� ���: ");
        String name = scanner.nextLine();
        System.out.println("������� ��� (Male or Female: ");
        Gender gender = checkGender();
        System.out.println("������� ���� ��������: ");
        LocalDate birthDate = setBirthDate();
        try {
            presenter.addPerson(name, gender, birthDate);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private Gender checkGender() {
        String answer = null;
        boolean i = true;
        while (i) {
            answer = scanner.nextLine();
            if (answer.equals("Male") || answer.equals("Female")) {
                i = false;
            } else {
                System.out.println("�������� ��������!" +
                        " ������� ������ ��������");
            }
        }
        return Gender.valueOf(answer);
    }

    public void getById() {
        System.out.println("������� ID: ");
        int id = checkId();
        presenter.checkId(id);
    }

    private int checkId() {
        boolean i = true;
        long id = 0;
        while (i) {
            id = checkIn();
            if (presenter.checkId((int) id)) {
                i = false;
                return (int) id;
            }
        }
        return (int) id;
    }

    private int checkIn() {
        int value = 0;
        boolean i = true;
        while (i) {
            String text = scanner.nextLine();
            if (text.matches("[0-9]+")) {
                value = Integer.parseInt(text);
                i = false;
            } else {
                System.out.println("�� ����� �������� ��������!");
            }
        }
        return value;
    }

    public LocalDate setBirthDate() {
        System.out.println("������� ��� ��������: ");
        int year = checkIn();
        System.out.println("������� ����� ��������: ");
        int month = checkIn();
        System.out.println("������� ���� ��������: ");
        int day = checkIn();
        if (!presenter.setBirthday(year, month, day)) {
            System.out.println("���� ������� �� �����!");
            error();
        } else {
            success();
        }
        return LocalDate.of(year, month, day);
    }

    public void addChild() {
        System.out.println("������� ID ��������: ");
        int parentId = checkId();
        System.out.println("������� ID �������: ");
        int childId = checkId();
        if (parentId == childId) {
            System.out.println("ID ����������. ������ �� ���������");
        } else {
            presenter.addChild(parentId, childId);
        }
    }

    public void addSpouse() {
        System.out.println("������� ID 1-��� �������: ");
        int one = checkId();
        System.out.println("������� ID 2-��� �������: ");
        int two = checkId();
        if (one == two) {
            System.out.println("ID ����������. ������ �� ���������.");
        } else {
            presenter.addSpouse(one, two);
        }
    }

    public void addToParents() {
        System.out.println("������� ID ������� ��������: ");
        int parent1 = checkId();
        System.out.println("������� ID ������� ��������: ");
        int parent2 = checkId();
        if (parent1 == parent2) {
            System.out.println("ID ����������. ������� ������ ID: ");
        } else {
            presenter.addToParents(parent1, parent2);
        }
    }

    public void TreeGetInfo() {
     presenter.getTree();
    }

    public void getInfoById() {
        System.out.println("������� ID: ");
        int memberId = checkId();
        presenter.getInfoById(memberId);
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public  void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    private void error() {
        System.out.println("������ �� ��������...");
    }

    private void success() {
        System.out.println("������ ������� ���������!");
    }
    private void download() {
        System.out.println("������ ������� ���������.");
    }

    @Override
    public void answer(String answer) {
        System.out.println(answer);
    }

    private void hello() {
        System.out.println("����� ����������!");
    }

    public void save() {
        if (presenter.save()) {
            success();
        } else {
            error();
        }
    }

//    public void load() {
//        presenter.load();
//        download();
//    }
public void load() {
    try {
        presenter.load();
    } catch (RuntimeException e) {
        System.out.println(e.getMessage());
    }
}
    public void setWriter(FileHandler writer) {
        presenter.setWriter(writer);
    }
}
