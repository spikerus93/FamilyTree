package ru.gb.family_tree;

import ru.gb.family_tree.writer.FileHandler;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.tree.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testFree();
        FileHandler fileHandler = new FileHandler(); //Написание метода записи и восстановления данных.
        fileHandler.write(tree, "FamilyTree.txt");
        System.out.println(tree);
    }

    static FamilyTree testFree() {
        FamilyTree tree = new FamilyTree();

        Human aleksey = new Human("Алексей", Gender.Male, LocalDate.of(1986, 12, 15));
        Human alisa = new Human("Алиса", Gender.Female, LocalDate.of(1990, 5, 23));
        tree.add(aleksey);
        tree.add(alisa);
        tree.setWedding(aleksey, alisa);

        Human petr = new Human("Пётр", Gender.Male, LocalDate.of(2016, 7, 2)
                , aleksey, alisa);
        Human vasilisa = new Human("Василиса", Gender.Female, LocalDate.of(2018, 3, 14)
                , aleksey, alisa);
        tree.add(petr);
        tree.add(vasilisa);

        Human grandMother = new Human("Любовь", Gender.Female, LocalDate.of(1955, 2, 1));
        grandMother.addChild(aleksey);
        tree.add(grandMother);
        Human grandFather = new Human("Павел", Gender.Male, LocalDate.of(1961, 8, 2));
        grandFather.addChild(alisa);
        tree.add(grandFather);

//        tree.remove(2);

        return tree;

    }
}
