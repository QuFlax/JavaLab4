package ua.edu.university.controller;

import ua.edu.university.model.*;

import java.util.ArrayList;

public class FacultyCreator implements Creator {
    private University university;
    private String name;
    private Human head;

    public FacultyCreator(University university) {
        this.university = university;
    }

    public FacultyCreator setName(String name) {
        this.name = name;
        return this;
    }

    public FacultyCreator setHead(Human head) {
        this.head = head;
        return this;
    }

    @Override
    public Faculty create(Object ... objects) {
        for (Object o : objects) {
            if (o instanceof String) {
                name = (String) o;
            } else if (o instanceof Human) {
                head = (Human) o;
            }
        }
        Faculty faculty = new Faculty(name, head, new ArrayList<>());
        university.getFaculties().add(faculty);
        return faculty;
    }
}