package study_group.view.commands;

import study_group.view.ConsoleUI;

public class SortByAge extends Command{

    public SortByAge(ConsoleUI consoleUI) {
        super("������������� �� ��������", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByAge();

    }
}