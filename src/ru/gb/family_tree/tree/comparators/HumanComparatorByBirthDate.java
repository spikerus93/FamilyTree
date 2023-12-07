package ru.gb.family_tree.tree.comparators;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.tree.TreeNode;

import java.util.Comparator;

public class HumanComparatorByBirthDate<E extends TreeNode<E>> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {

        return (o1.getBirthDate().compareTo(o2.getBirthDate()));
    }
}
