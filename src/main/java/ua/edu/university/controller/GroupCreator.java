package ua.edu.university.controller;

import ua.edu.university.model.*;

import java.util.ArrayList;

public class GroupCreator implements Creator {
    private Department department;
    private String name;

    public GroupCreator(Department department) {
        this.department = department;
    }

    public GroupCreator setName(String name) {
        this.name = name; return this;
    }

    @Override
    public Group create(Object ... objects) {
        for (Object o : objects) {
            if (o instanceof String) {
                name = (String) o;
            }
        }
        Group group = new Group(name, new ArrayList<>());
        department.getGroups().add(group);
        return group;
    }
}
