package study_group.view.commands;

import study_group.view.ConsoleUI;

public class GetStudentListInfo extends Command{

    public GetStudentListInfo(ConsoleUI consoleUI) {
        super("�������� ������ ���������", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getStudentListInfo();
    }
}

