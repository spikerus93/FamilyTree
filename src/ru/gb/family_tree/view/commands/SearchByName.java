package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

import java.io.IOException;

public class SearchByName extends Command{
    public SearchByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "����� �� �����";
    }
    @Override
    public void execute() throws IOException {
        consoleUI.getById();
    }
}
