package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.view.ConsoleUI;

import java.io.IOException;

public class TreeGetInfo extends Command {
    public TreeGetInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить данные";
    }

    @Override
    public void execute() throws IOException {
        consoleUI.TreeGetInfo();
    }
}
