package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddSpouse extends Command{
    public AddSpouse(ConsoleUI consoleUI){
        super(consoleUI);
        description = "�������� �������";
    }
    @Override
    public void execute() {
        consoleUI.addSpouse();
    }
}
