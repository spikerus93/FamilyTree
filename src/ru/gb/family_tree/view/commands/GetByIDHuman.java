package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

import java.io.IOException;

public class GetByIDHuman extends Command{
    public GetByIDHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить данные по ID";
    }

    @Override
    public void execute() throws IOException {
        consoleUI.getById();
    }
}
