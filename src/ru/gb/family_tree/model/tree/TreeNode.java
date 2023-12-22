package ru.gb.family_tree.model.tree;

import ru.gb.family_tree.model.human.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T> extends Serializable {
    void setId(long id);
    long getId();
    Gender getGender();
    int getAge();
    T getMother();
    T getFather();
    void addChild(T human);
    void addParent(T human);
    String getName();
    LocalDate getDeathDate();
    LocalDate getBirthDate();
    List<T> getParents();
    List<T> getChildren();
    T getSpouse();
    void setSpouse(T human);
}
