package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

import java.io.IOException;

public class SortByName extends Command{
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировка по имени";
    }

    @Override
    public void execute() throws IOException {
        consoleUI.sortByName();
    }
}
