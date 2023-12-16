package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

import java.io.IOException;

public class SortByBirthDate extends Command{
    public SortByBirthDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировка по Дате Рождения";
    }

    @Override
    public void execute() throws IOException {
        consoleUI.setBirthDate();
    }
}
