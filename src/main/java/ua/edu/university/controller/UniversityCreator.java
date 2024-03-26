package ua.edu.university.controller;

import ua.edu.university.model.*;

import java.util.ArrayList;
import java.util.List;

public class UniversityCreator implements Creator {
    private String name;
    private Human head;

    public UniversityCreator() {
        name = "EDU";
        head = null;
    }

    public UniversityCreator(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    public UniversityCreator setName(String name) {
        this.name = name;
        return this;
    }

    public UniversityCreator setHead(Human head) {
        this.head = head;
        return this;
    }

    @Override
    public University create(Object ... objects) {
        for (Object o : objects) {
            if (o instanceof String) {
                name = (String) o;
            } else if (o instanceof Human) {
                head = (Human) o;
            }
        }
        return new University(name, head, new ArrayList<>());
    }
}