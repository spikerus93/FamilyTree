package ru.gb.family_tree.view;

import ru.gb.family_tree.view.commands.AddHuman;
import ru.gb.family_tree.view.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu (ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));

    }
}
