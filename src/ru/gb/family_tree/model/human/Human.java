package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.tree.TreeNode;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements TreeNode<Human> {
    private long id;
    private String name;
    private Gender gender;
    public LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Human spouse;

    public Human (String name, Gender gender, LocalDate birthDate, LocalDate deathDate,
                  Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father =  father;
        children = new ArrayList<>();
    }
    public Human (String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate,  null,  null, null );
    }
    public Human (String name, Gender gender, LocalDate birthDate,
                  Human father, Human mother) {
        this(name, gender, birthDate, null, father, mother);
    }

    public Human(){};
    public void addChild (Human child) {
        if (!children.contains((child))) {
            children.add(child);
        }
    }

    public void addParent(Human parent){
        if (parent.getGender().equals(Gender.Male)){
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)){
            setMother(parent);
        }
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }
    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }
    public Human getFather() {
        return father;
    }
    public List<Human> getParents() {
        List<Human> listParents = new ArrayList<>(2);
        if (mother != null){
            listParents.add(mother);
        }
        if (father != null){
            listParents.add(father);
        }
        return listParents;
    }
    public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }
    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }
    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }
    public Human getSpouse() {
        return spouse;
    }
    public String getName(){
        return name;
    }
    public void setId(long id){
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public LocalDate getBirthDate(){
        return birthDate;
    }
    public LocalDate getDeathDate(){
        return  deathDate;
    }
    public List<Human> getChildren(){
        return children;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
    public Gender getGender(){
        return gender;
    }

    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append("  ���: ");
        sb.append(name);
        sb.append("  ���: ");
        sb.append(gender);
        sb.append("  �������: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
//        TODO �������� ���������� ��� �� �������
        return sb.toString();
    }
    public String getSpouseInfo() {
        String res = "������(�): ";
        if (spouse == null){
            res += "���";
        } else {
            res += spouse.getName();
        }
        return res;
    }
    public String getMotherInfo(){
        String res = "����: ";
        Human mother = getMother();
        if (mother != null){
            res += mother.getName();
        } else {
            res += "����������";
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "����: ";
        Human father = getFather();
        if (father != null){
            res += father.getName();
        } else {
            res += "����������";
        }
        return res;
    }
    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("����: ");
        if (!children.isEmpty()){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("�����������");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object object){
        if (this == object){
            return true;
        }
        if (!(object instanceof Human)){

            return false;
        }
        Human human = (Human) object;
        return human.getId() == getId();
    }
}


