package ua.edu.university.controller;

import ua.edu.university.model.Human;
import ua.edu.university.model.Sex;

public class HumanCreator implements Creator {
    private String firstName;
    private String middleName;
    private String lastName;
    private Sex sex;

    public HumanCreator setName(String firstName, String middleName, String lastName) {
        return setFirstName(firstName).setMiddleName(middleName).setLastName(lastName);
    }
    public HumanCreator setFirstName(String firstName) {
        this.firstName = firstName; return this;
    }

    public HumanCreator setMiddleName(String middleName) {
        this.middleName = middleName; return this;
    }

    public HumanCreator setLastName(String lastName) {
        this.lastName = lastName; return this;
    }

    public HumanCreator setSex(Sex sex) {
        this.sex = sex; return this;
    }

    @Override
    public Human create(Object ... objects) {
        for (Object o : objects) {
            if (o instanceof Sex) {
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
        return new Human(firstName, middleName, lastName, sex) {};
    }
}
