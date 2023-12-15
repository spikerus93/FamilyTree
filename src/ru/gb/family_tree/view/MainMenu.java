package ru.gb.family_tree.view;

import ru.gb.family_tree.view.commands.AddChild;
import ru.gb.family_tree.view.commands.AddHuman;
import ru.gb.family_tree.view.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu (ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new AddChild(consoleUI));



    }
    public String menu(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i+1).append(". ").append(commandList.get(i).getDescription()).append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}

