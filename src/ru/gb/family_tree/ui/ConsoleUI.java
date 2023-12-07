package ru.gb.family_tree.ui;

import ru.gb.family_tree.presenter.Presenter;

import java.util.Scanner;



public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }
    @Override
    public void start() {
        while (true){
            String answer = scan();
      //      presenter.getInfo(answer);
        }

    }

    @Override
    public void answer(String answer) {
        System.out.println(answer);

    }
    private String scan() {
        System.out.println("D");
        return scanner.nextLine();
    }
}
