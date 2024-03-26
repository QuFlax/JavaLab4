package ua.edu.university;

import org.jetbrains.annotations.NotNull;
import ua.edu.university.controller.*;
import ua.edu.university.model.*;
import org.json.simple.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonManager {
    private String file;

    public JsonManager(String file) {
        this.file = file;
    }
    public University fromJson() {
        try {
            //byte[] jsonData = Files.readAllBytes(Paths.get(file));
            //String read = Files.readAllLines(Paths.get(file));
            //String json = new String(jsonData);
            FileReader reader = new FileReader(file);
            JSONObject main = (JSONObject) JSONValue.parse(reader);

            University university = new UniversityCreator().create(main.get("name"),
                    getHuman((JSONObject) main.get("head")));
            FacultyCreator facultyCreator = new FacultyCreator(university);
            ((ArrayList<JSONObject>) main.get("faculties")).forEach(o -> getFaculty(o, facultyCreator));
            reader.close();
            return university;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    private Human getHuman(JSONObject obj) {
        HumanCreator humanCreator = new HumanCreator();
        return humanCreator.create(
                Sex.valueOf((String) obj.get("sex")),
                obj.get("firstName"),
                obj.get("middleName"),
                obj.get("lastName")
        );
    }

    public void toJson(University university) {
        try {
            FileWriter writer = new FileWriter(file);
            JSONObject obj = new JSONObject();

            obj.put("name", university.getName());
            obj.put("head", university.getHead());
            obj.put("faculties", university.getFaculties());

            obj.writeJSONString(writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    private void getFaculty(JSONObject obj, FacultyCreator creator) {
        Faculty faculty = creator.create(obj.get("name"), getHuman((JSONObject) obj.get("head")));
        ((ArrayList<JSONObject>) obj.get("departments")).forEach(o -> getDepartment(o, faculty));
    }

    private Department getDepartment(JSONObject obj, Faculty faculty) {
        Department department = new DepartmentCreator(faculty).create(obj.get("name"), getHuman((JSONObject) obj.get("head")));
        for (JSONObject o : (ArrayList<JSONObject>) obj.get("groups"))
            getGroup(o, department);
        return department;
    }

    private Group getGroup(JSONObject obj, Department department) {
        Group group = new GroupCreator(department).create(obj.get("name"));
        for (JSONObject o : (ArrayList<JSONObject>) obj.get("students"))
            getStudent(o, group);
        return group;
    }

    private Student getStudent(JSONObject obj, Group group) {
        return new StudentCreator(group).create(getHuman(obj));
    }
}
