package ua.edu.university.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University {
    private String name;
    private Human head;
    private List<Faculty> faculties;

    public University() {
        name = "EDU";
        head = null;
        faculties = new ArrayList<>();
    }
    public University(String name, Human head, List<Faculty> faculties) {
        this.name = name;
        this.head = head;
        this.faculties = faculties;
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        if (faculties.size() != that.faculties.size()) return false;
        return name.equals(that.name) && head.equals(that.head) && faculties.containsAll(that.faculties);
    }

    @Override
    public String toString() {
        return "{\"name\"=\"" + name + "\", \"head\"=\"" + head + "\", \"faculties\"=\"" + faculties + "\"}";
    }
}