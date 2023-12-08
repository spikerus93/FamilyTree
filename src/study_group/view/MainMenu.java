package study_group.view;

import study_group.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddStudent(consoleUI));
        commands.add(new GetStudentListInfo(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new Finish(consoleUI));
    }
    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void execute(int choice) {
        Command command = commands.get(choice-1);
        command.execute();
    }
    public int size() {
        return commands.size();
    }
}
