package ua.edu.university.model;

import java.util.Objects;

public abstract class Human {
    private String firstName, middleName, lastName;
    private Sex sex;

    public Human(String firstName, String middleName, String lastName, Sex sex) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
    }

    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }
    public Sex getSex() { return sex; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(firstName, human.firstName) && Objects.equals(middleName, human.middleName) && Objects.equals(lastName, human.lastName) && sex == human.sex;
    }

    @Override
    public String toString() {
        return "{\"firstName\":\"" + firstName + '\"' +
                ",\"middleName\":\"" + middleName + '\"' +
                ",\"lastName\":\"" + lastName + '\"' +
                ",\"sex\":\"" + sex + "\"}";
    }
}
