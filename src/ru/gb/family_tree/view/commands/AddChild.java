package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddChild extends Command{
    public AddChild(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "�������� �������";
    }

    @Override
    public void execute() {
        consoleUI.addChild();
    }
}
