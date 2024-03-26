package ua.edu.university.model;

import java.util.List;
import java.util.Objects;

public class Faculty {
    private String name;
    private Human head;
    private List<Department> departments;

    public Faculty(String name, Human head, List<Department> departments) {
        this.name = name;
        this.head = head;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty that = (Faculty) o;
        if (departments.size() != that.departments.size()) return false;
        return Objects.equals(name, that.name) && Objects.equals(head, that.head) && departments.containsAll(that.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, departments);
    }

    @Override
    public String toString() {
        return "{\"name\":\"" + name + "\", \"head\":" + head + ", \"departments\":" + departments + '}';
    }
}
