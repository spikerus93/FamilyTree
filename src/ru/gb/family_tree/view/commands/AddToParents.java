package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddToParents extends Command{
    public AddToParents(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "�������� ���������";
    }

    @Override
    public void execute() {
        consoleUI.addToParents();
    }
}
