package study_group.view.commands;

import study_group.view.ConsoleUI;

public class AddStudent extends Command{

    public AddStudent(ConsoleUI consoleUI) {
        super("�������� ��������", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addStudent();
    }
}
