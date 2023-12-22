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
        System.out.println("Ошибка! Значение отсутствует!");
        return false;
    }

    public void finish() {
        System.out.println("До свидания!");
        scanner.close();
        work = false;
    }

    private void setMenu() {
        System.out.println("Выберите пункт: ");
        System.out.println(menu.menu());
    }

    public void addHuman() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол (Male or Female: ");
        Gender gender = checkGender();
        System.out.println("Введите дату рождения: ");
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
                System.out.println("Неверное значение!" +
                        " Введите данные повторно");
            }
        }
        return Gender.valueOf(answer);
    }

    public void getById() {
        System.out.println("Введите ID: ");
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
                System.out.println("Вы ввели неверное значение!");
            }
        }
        return value;
    }

    public LocalDate setBirthDate() {
        System.out.println("Введите год рождения: ");
        int year = checkIn();
        System.out.println("Введите месяц рождения: ");
        int month = checkIn();
        System.out.println("Введите день рождения: ");
        int day = checkIn();
        if (!presenter.setBirthday(year, month, day)) {
            System.out.println("Дата указана не верно!");
            error();
        } else {
            success();
        }
        return LocalDate.of(year, month, day);
    }

    public void addChild() {
        System.out.println("Введите ID родителя: ");
        int parentId = checkId();
        System.out.println("Введите ID ребенка: ");
        int childId = checkId();
        if (parentId == childId) {
            System.out.println("ID одинаковые. Данные не обновлены");
        } else {
            presenter.addChild(parentId, childId);
        }
    }

    public void addSpouse() {
        System.out.println("Введите ID 1-ого супруга: ");
        int one = checkId();
        System.out.println("Введите ID 2-ого супруга: ");
        int two = checkId();
        if (one == two) {
            System.out.println("ID одинаковые. Данные не обновлены.");
        } else {
            presenter.addSpouse(one, two);
        }
    }

    public void addToParents() {
        System.out.println("Введите ID первого родителя: ");
        int parent1 = checkId();
        System.out.println("Введите ID второго родителя: ");
        int parent2 = checkId();
        if (parent1 == parent2) {
            System.out.println("ID одинаковые. Введите другой ID: ");
        } else {
            presenter.addToParents(parent1, parent2);
        }
    }

    public void TreeGetInfo() {
     presenter.getTree();
    }

    public void getInfoById() {
        System.out.println("Введите ID: ");
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
        System.out.println("Данные не записаны...");
    }

    private void success() {
        System.out.println("Данные успешно сохранены!");
    }
    private void download() {
        System.out.println("Данные успешно загружены.");
    }

    @Override
    public void answer(String answer) {
        System.out.println(answer);
    }

    private void hello() {
        System.out.println("Добро пожаловать!");
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
