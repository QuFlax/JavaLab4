package ua.edu.university.controller;

import ua.edu.university.model.*;

public class StudentCreator implements Creator {
    private Group group;
    private String firstName, middleName, lastName;
    private Sex sex;

    public StudentCreator(Group group) {
        this.group = group;
    }

    public StudentCreator setName(String firstName, String middleName, String lastName) {
        return setFirstName(firstName).setMiddleName(middleName).setLastName(lastName);
    }
    public StudentCreator setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public StudentCreator setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }
    public StudentCreator setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public StudentCreator setSex(Sex sex) {
        this.sex = sex;
        return this;
    }

    @Override
    public Student create(Object ... objects) {
        for (Object o : objects) {
            if (o instanceof Human) {
                Human human = (Human) o;
                firstName = human.getFirstName();
                middleName = human.getMiddleName();
                lastName = human.getLastName();
                sex = human.getSex();
                break;
            } else if (o instanceof Sex) {
                sex = (Sex) o;
            } else if (o instanceof String) {
                if (firstName == null) {
                    firstName = (String) o;
                } else if (middleName == null) {
                    middleName = (String) o;
                } else {
                    lastName = (String) o;
                }
            }
        }
        Student student = new Student( firstName, middleName, lastName, sex);
        group.getStudents().add(student);
        return student;
    }
}