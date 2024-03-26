package ua.edu.university;

import junit.framework.TestCase;
import ua.edu.university.controller.*;
import ua.edu.university.model.*;

public class JsonManagerTest extends TestCase {

    public void testJson() {
        HumanCreator humanCreator = new HumanCreator();
        University oldUniversity = new UniversityCreator().create("EDU", humanCreator.create("1", "2", "3", Sex.MALE));

        FacultyCreator facultyCreator = new FacultyCreator(oldUniversity);
        Faculty faculty = facultyCreator.create("12-", humanCreator.create("1", "2", "3", Sex.FEMALE));
        DepartmentCreator departmentCreator = new DepartmentCreator(faculty);

        Department department1 = departmentCreator.create("121", humanCreator.create("1", "2", "3", Sex.MALE));
        GroupCreator groupCreator1 = new GroupCreator(department1);

        Group group1 = groupCreator1.create("121-20-1");
        StudentCreator studentCreator1 = new StudentCreator(group1);
        Student student1 = studentCreator1.create("1", "2", "3", Sex.FEMALE);
        Student student2 = studentCreator1.create("1", "2", "3", Sex.MALE);

        Group group2 = groupCreator1.create("121-20-2");
        StudentCreator studentCreator2 = new StudentCreator(group2);
        Student student3 = studentCreator2.create("1", "2", "3", Sex.FEMALE);
        Student student4 = studentCreator2.create("1", "2", "3", Sex.MALE);

        Department department2 = departmentCreator.create("122", humanCreator.create("1", "2", "3", Sex.FEMALE));
        GroupCreator groupCreator2 = new GroupCreator(department2);

        Group group3 = groupCreator2.create("122-20-1");
        StudentCreator studentCreator3 = new StudentCreator(group3);
        Student student5 = studentCreator3.create("1", "2", "3", Sex.MALE);
        Student student6 = studentCreator3.create("1", "2", "3", Sex.FEMALE);

        Group group4 = groupCreator2.create("122-20-2");
        StudentCreator studentCreator4 = new StudentCreator(group4);
        Student student7 = studentCreator4.create("1", "2", "3", Sex.MALE);
        Student student8 = studentCreator4.create("1", "2", "3", Sex.FEMALE);

        // create
        JsonManager manager = new JsonManager("university.json");
        // to json
        manager.toJson(oldUniversity);
        // get from json
        University newUniversity = manager.fromJson();
        boolean b = newUniversity.equals(oldUniversity);
        System.out.println("newUniversity.equals(oldUniversity) = " + b);
    }
}