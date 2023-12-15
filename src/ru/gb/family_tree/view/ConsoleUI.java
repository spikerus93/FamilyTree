package ru.gb.family_tree.view;

import ru.gb.family_tree.presenter.Presenter;

import java.util.Scanner;



public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private  boolean work;
    private MainMenu menu;

    public ConsoleUI(){
        this.scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        while (work){
            String answer = scan();
      //      presenter.getInfo(answer);
        }

    }

    private void hello() {
        System.out.println("Добро пожаловать!");
    }

    private boolean checkValid (String value) {
        try { if (Integer.parseInt(value) > 0 && Integer.parseInt(value) <= menu.getSize());
    }

    private void choice() {
        String choiceStr = scanner.nextLine();
        if ()
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
