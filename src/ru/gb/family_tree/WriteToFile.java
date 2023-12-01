package ru.gb.family_tree;

import java.io.*;
import java.io.Serializable;

class SaveRestoreFile implements Serializable {
    public void save(String path, Serializable object){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))){
            objectOutputStream.writeObject(object);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }

    }

    public Serializable restore(String path){
        Serializable restoreData = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))){
            restoreData = (Serializable) objectInputStream.readObject();
        } catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
        return restoreData;
    }
}



