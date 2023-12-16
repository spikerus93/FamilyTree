package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

import java.io.IOException;

public class SaveTree extends Command{
    public SaveTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить Дерево";
    }

    @Override
    public void execute() throws IOException {
        consoleUI.save();
    }
}
