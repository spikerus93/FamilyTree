package ru.gb.family_tree.service;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.tree.FamilyTree;

public class Service {
    private FamilyTree tree;

    public Service(){
        tree = new FamilyTree();
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByBirthDate() {
        tree.sortByBirthDate();
    }

    public String getInfo() {
        return tree.getInfo();
    }

    public boolean addHuman(Human human) {
        return tree.add(human);
    }

    public boolean setWedding(Human human1 , Human human2 ) {
        return tree.setWedding(human1, human2);
    }
}
