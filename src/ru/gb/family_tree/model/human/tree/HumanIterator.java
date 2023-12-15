package ru.gb.family_tree.model.human.tree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E>{

    private int index = 0;
    private List<E> humanList;
    public HumanIterator(List<E> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public E next() {
        return humanList.get(index++);
    }
}
