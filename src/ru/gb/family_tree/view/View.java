package ru.gb.family_tree.view;

import java.io.IOException;

public interface View {
    void start() throws IOException;
    void answer(String answer);
}

