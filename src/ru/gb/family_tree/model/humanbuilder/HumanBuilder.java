package ru.gb.family_tree.model.humanbuilder;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;

import java.time.LocalDate;

public class HumanBuilder {
    public Human build (String name, Gender gender, LocalDate birthDate) {
        return new Human(name, gender, birthDate);
    }
}
