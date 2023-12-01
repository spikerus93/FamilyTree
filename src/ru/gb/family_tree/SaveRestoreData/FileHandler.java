package ru.gb.family_tree.SaveRestoreData;

import ru.gb.family_tree.tree.FamilyTree;

import java.io.*;
import java.rmi.RemoteException;

public class FileHandler implements Writer{
    private String filePath;

    @Override
    public boolean write(Serializable serializable, String filePath) {
        boolean flag = false;

        File file = new File(filePath);
        ObjectOutputStream oos = null;
        try (FileOutputStream fos = new FileOutputStream(file)){
            if (fos != null) {
                oos = new ObjectOutputStream(fos);
                oos.writeObject(serializable);
                flag = true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Object restore(String filePath) throws IOException {
        File file = new File(filePath);
        ObjectInputStream ois = null;
        try (FileInputStream fis = new FileInputStream(file)){
            if (fis != null){
                ois = new ObjectInputStream(fis);
                FamilyTree restoreTree = (FamilyTree) ois.readObject();
                return restoreTree;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        throw new InvalidObjectException("Что-то пошло не так!...");
    }
}
