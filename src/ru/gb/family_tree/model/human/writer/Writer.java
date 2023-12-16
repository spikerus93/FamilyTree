package ru.gb.family_tree.model.human.writer;

import java.io.Serializable;

public interface Writer {
    boolean write (Serializable serializable, String filePath);
    Object restore (String filePath);
}