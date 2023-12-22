package ru.gb.family_tree.model.tree;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.tree.comparators.HumanComparatorByBirthDate;
import ru.gb.family_tree.model.tree.comparators.HumanComparatorByName;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {

    private long memberId;
    private final List<E> humanList;
    public FamilyTree(){
        this(new ArrayList<>());
    }
    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }
    public boolean add(E human){
        if (human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(memberId++);

            addToParents((Human) human);
            addToChildren((Human) human);

            return true;
        }
        return false;
    }
    private void addToParents(Human human){
        for (Human parent: human.getParents()){
            parent.addChild(human);
        }
    }
    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }

// TODO Написать метод создания родственной связи
    public boolean setWedding(Human human1, Human human2){
        if (human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }
    public boolean setDivorce(Human human1, Human human2){
        if (human1.getSpouse() != null && human2.getSpouse() != null){
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public List<E> getSiblings(int id){
        E human = getById(id);
        if (human == null){
            return null;
        }
        List<E> res = new ArrayList<>();
        for (E parent: human.getParents()){
            for (E child: parent.getChildren()){
                if (!child.equals(human)){
                    res.add(child);
            }
        }
    }
    return res;
    }
    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for (E human: humanList){
            if (human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }
    public boolean remove(long humanId){
        if (checkId(humanId)){
            E element = getById(humanId);
            return humanList.remove(element);
        }
        return false;
    }

    private boolean checkId(long id){
        return id < memberId && id >= 0;
    }
    public E getById(long id){
        if (checkId(id)){
            for (E human: humanList){
                if (human.getId() == id){
                    return human;
                }

            }
        }
        return null;
    }
    public void sortByName(){
        humanList.sort(new HumanComparatorByName());
    }
    public void sortByBirthDate(){
        humanList.sort(new HumanComparatorByBirthDate());
    }

    @Override
    public String toString(){
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов \n");
        for (E human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getInfoById (int memberId) {
        StringBuilder sb = new StringBuilder("Id - ");
        sb.append(memberId).append("\n").append("\n");
        E human = getById(memberId);
        if (human != null) {
            sb.append("Имя: ").append(human.getName() + "\n");
            sb.append("Пол: ").append(human.getGender() + "\n");
            if (human.getBirthDate() != null) {
                sb.append("Дата рождения: ").append(human.getBirthDate() + "\n");
                sb.append("Возраст: ").append(human.getAge() + "\n");
            }
            if (human.getSpouse() != null) {
                sb.append(human.getSpouse() + "\n");
            }
            if (human.getParents() != null) {
                sb.append(human.getParents() + "\n");
            }
            if (human.getChildren() != null) {
                sb.append(human.getChildren() + "\n");
            }
            return sb.toString();
        }
        return "Данных нет.";
    }


    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<E>(humanList);
    }
}
