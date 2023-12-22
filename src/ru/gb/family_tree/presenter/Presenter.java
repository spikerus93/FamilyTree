package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.model.writer.Writer;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }


    public void addPerson (String name, Gender gender, LocalDate birthDate) {
        view.answer(service.addToTree(name, gender, birthDate).toString());
    }

    public void addChild(int parentId, int childId) {
        service.addChild(parentId, childId);
        checkId(parentId);
    }

    public void addSpouse (int one, int two) {
        service.addSpouse(one, two);
        checkId(one);
    }

    public void addToParents (int parent1, int parent2) {
        service.addToParents(parent1, parent2);
    }

    public boolean checkId (int id) {
        return  service.checkId(id);
    }
    public boolean setBirthday (int year, int month, int day) {
        if (service.setBirthday(year, month, day)) {
            getTree();
            return true;
        }
        return false;
    }

    public void getTree() {
        view.answer(service.getInfo());
    }

    public void getInfoById (int memberId) {
        view.answer(service.getInfoById(memberId));
    }

    public void sortByName() {
        service.sortByName();
        getTree();
    }
    public void sortByBirthDate() {
        service.sortByBirthDate();
        getTree();
    }

    public boolean save() {
        return service.save();
    }
    public void load() { service.load();
    }
    public void setWriter (Writer writer) {
        service.setWriter(writer);
    }
}
