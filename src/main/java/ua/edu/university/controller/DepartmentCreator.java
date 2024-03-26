package ua.edu.university.controller;

import ua.edu.university.model.*;

import java.util.ArrayList;

public class DepartmentCreator implements Creator {
    private Faculty faculty;
    private String name;
    private Human head;

    public DepartmentCreator(Faculty faculty) {
        this.faculty = faculty;
    }

    public DepartmentCreator setName(String name) {
        this.name = name;
        return this;
    }

    public DepartmentCreator setHead(Human head) {
        this.head = head;
        return this;
    }

    @Override
    public Department create(Object ... objects) {
        for (Object o : objects) {
            if (o instanceof String) {
                name = (String) o;
            } else if (o instanceof Human) {
                head = (Human) o;
            }
        }
        Department department = new Department(name, head, new ArrayList<>());
        faculty.getDepartments().add(department);
        return department;
    }
}
