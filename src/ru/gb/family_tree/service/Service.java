package ru.gb.family_tree.service;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.tree.FamilyTree;

public class Service {
    private FamilyTree tree;

    public Service(){
        tree = new FamilyTree();
    }
}
