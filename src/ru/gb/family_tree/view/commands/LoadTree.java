package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

import java.io.IOException;

public class LoadTree extends Command{
    public LoadTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить Дерево";
    }

    @Override
    public void execute() throws IOException {
        consoleUI.load();
    }
}
