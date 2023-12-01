package ru.gb.family_tree.SaveRestoreData;

import java.io.IOException;
import java.io.Serializable;

public interface Writer {
    boolean write (Serializable serializable, String filePath);
    Object restore (String filePath) throws IOException;
}
