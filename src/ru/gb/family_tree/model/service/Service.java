package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.humanbuilder.HumanBuilder;
import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.model.writer.Writer;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> tree;

    private HumanBuilder humanBuilder;

    private Writer writer;

    public Service(){
        tree = new FamilyTree<>();
        humanBuilder = new HumanBuilder();
    }

    public boolean setBirthday (int id,int year, int month, int day) {
        Human human = tree.getById(id);
        if (human != null) {
            human.setBirthDate(checkDate(year, month, day));
        }
        assert human != null;
        return human.getBirthDate() != null;
    }

    private LocalDate checkDate(int year, int month, int day) {
        LocalDate date = null;
        if (dateIsValid(year, month, day)) {
            date = LocalDate.of(year, month, day);
        }
        return date;
    }

    private boolean dateIsValid(int year, int month, int day) {
        try {
            LocalDate date = LocalDate.of(year, month, day);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
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

    public void addToParents (int parent1, int parent2) {
        Human parentId1 = tree.getById(parent1);
        Human parentId2 = tree.getById(parent2);
        parentId1.getParents();
        parentId2.getParents();
    }

    public void addToChildren (int id) {


        
    }

    public void load() {
        tree = (FamilyTree) writer.restore("loadTree.txt");
    }

    public boolean save() {
        return writer.write(tree, "saveTree.txt");
    }

    public void setWriter (Writer writer) {
        this.writer = writer;
    }

    public boolean checkId (int id) {
        Human human = tree.getById(id);
        return human != null;
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
