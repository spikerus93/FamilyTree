package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator extends FamilyTree implements Iterator<Human>{

    private int index = 0;
    private List<Human> humanList;
    public HumanIterator(List<Human> humanList) {
        super(humanList);
    }

//    @Override
//    public String getInfo() {
//        return super.getInfo();
//    }


    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}
