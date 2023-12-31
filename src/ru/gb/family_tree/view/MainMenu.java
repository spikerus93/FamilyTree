package ru.gb.family_tree.view;

import ru.gb.family_tree.view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private final List<Command> commandList;

    public MainMenu (ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new AddChild(consoleUI));
        commandList.add(new AddSpouse(consoleUI));
        commandList.add(new AddToParents(consoleUI));
        commandList.add(new GetByIDHuman(consoleUI));
        commandList.add(new SortByBirthDate(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new TreeGetInfo(consoleUI));
        commandList.add(new SaveTree(consoleUI));
        commandList.add(new LoadTree(consoleUI));
        commandList.add(new Finish(consoleUI));





    }
    public String menu(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i+1).append(". ").append(commandList.get(i).getDescription()).append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice) throws IOException {
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}

