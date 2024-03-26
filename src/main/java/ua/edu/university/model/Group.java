package ua.edu.university.model;

import java.util.List;
import java.util.Objects;

public class Group {
    private String name;
    private List<Student> students;

    public Group(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) && Objects.equals(students, group.students);
    }

    @Override
    public String toString() {
        return "{\"name\":\"" + name + '\"' +
                ", \"students\":" + students +
                '}';
    }
}