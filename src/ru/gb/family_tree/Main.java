package ru.gb.family_tree;

import ru.gb.family_tree.model.human.service.Service;
import ru.gb.family_tree.model.human.writer.FileHandler;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.human.tree.FamilyTree;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //ConsoleUI consoleUI = new ConsoleUI();
        //consoleUI.start();
        Service service = new Service();
        Human aleksey = new Human("Алексей", Gender.Male, LocalDate.of(1986, 12, 15));
        Human alisa = new Human("Алиса", Gender.Female, LocalDate.of(1990, 5, 23));
        service.addHuman(aleksey);
        service.addHuman(alisa);
        service.setWedding(aleksey, alisa);

        Human petr = new Human("Пётр", Gender.Male, LocalDate.of(2016, 7, 2)
                , aleksey, alisa);
        Human vasilisa = new Human("Василиса", Gender.Female, LocalDate.of(2018, 3, 14)
                , aleksey, alisa);
        service.addHuman(petr);
        service.addHuman(vasilisa);

        Human grandMother = new Human("Любовь", Gender.Female, LocalDate.of(1955, 2, 1));
        grandMother.addChild(aleksey);
        service.addHuman(grandMother);
        Human grandFather = new Human("Павел", Gender.Male, LocalDate.of(1961, 8, 2));
        grandFather.addChild(alisa);
        service.addHuman(grandFather);

//        tree.remove(2);
        System.out.println(service.getInfo());
        service.sortByBirthDate();
        System.out.println(service.getInfo());
        service.sortByName();
        System.out.println(service.getInfo());
    }

    private static void write(FamilyTree tree){
        String filePath = "src/ru/gb/family_tree/SaveRestoreData/FamilyTree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.write(tree, filePath);
    }
    private static FamilyTree restore() throws IOException {
        String filePath = "src/ru/gb/family_tree/SaveRestoreData/FamilyTree.txt";
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.restore(filePath);
    }
}
