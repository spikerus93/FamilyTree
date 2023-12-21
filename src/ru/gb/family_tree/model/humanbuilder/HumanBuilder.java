package ru.gb.family_tree.model.humanbuilder;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;

public class HumanBuilder {
    public Human build (String name, Gender gender) {
        return new Human();
    }
}
