package study_group.view.commands;

import study_group.view.ConsoleUI;

public class SortByName extends Command{

    public SortByName(ConsoleUI consoleUI) {
        super("������������� �� �����", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByName();
    }
}
