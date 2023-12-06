package ru.gb.family_tree.service;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.tree.FamilyTree;

public class Service extends FamilyTree {
    private FamilyTree tree;

    public Service(){
        tree = new FamilyTree();
    }

//    public String getInfo() {
//        return super.getInfo();
//    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByBirthDate(){
        tree.sortByBirthDate();
    }
}
