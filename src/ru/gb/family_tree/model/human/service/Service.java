package ru.gb.family_tree.model.human.service;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.human.humanbuilder.HumanBuilder;
import ru.gb.family_tree.model.human.tree.FamilyTree;
import ru.gb.family_tree.model.human.writer.Writer;

import java.io.IOException;

public class Service {
    private FamilyTree<Human> tree;

    private HumanBuilder humanBuilder;

    private Writer writer;

    public Service(){
        tree = new FamilyTree<>();
        humanBuilder = new HumanBuilder();
    }

    public Human addToTree (String name, Gender gender) {
        Human human = humanBuilder.build(name, gender);
        tree.add(human);
        return human;
    }

    public void addSpouse (int one, int two) {
        Human human1 = tree.getById(one);
        Human human2 = tree.getById(two);
        human1.setSpouse(human2);
        human2.setSpouse(human1);
    }

    public void addChild (int parentId, int childId) {
        Human parent = tree.getById(parentId);
        Human child = tree.getById(childId);
        parent.addChild(child);
        child.addParent(parent);
    }

    public void load() throws IOException {
        tree = (FamilyTree) writer.restore("loadTree.txt");
    }

    public boolean save() {
        return writer.write(tree, "saveTree.txt");
    }

    public boolean checkId (long id) {
        Human human = tree.getById(id);
        return human != null;
    }

    public void setWriter (Writer writer) {
        this.writer = writer;
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
