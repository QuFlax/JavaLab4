package ua.edu.university;

import ua.edu.university.controller.*;
import ua.edu.university.model.*;

public class Run {
    public static void main(String[] args) {
        University university = createTypycalUniversity();

    }

    public static void jUnitTest() {

    }

    public static University createTypycalUniversity() {
        HumanCreator humanCreator = new HumanCreator();
        University university = new UniversityCreator().create("EDU", humanCreator.create("1", "2", "3", Sex.MALE));
        FacultyCreator facultyCreator = new FacultyCreator(university);

        Faculty faculty = facultyCreator.create("12-", humanCreator.create("1", "2", "3", Sex.FEMALE));
        DepartmentCreator departmentCreator = new DepartmentCreator(faculty);

        Department department = departmentCreator.create("121", humanCreator.create("1", "2", "3", Sex.MALE));
        GroupCreator groupCreator = new GroupCreator(department);

        Group group = groupCreator.create("121-20-2");
        StudentCreator studentCreator = new StudentCreator(group);

        Student student = studentCreator.create("1","2","3", Sex.FEMALE);

        return university;
    }
}