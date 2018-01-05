package ru.dean.model;

import java.util.ArrayList;
import java.util.List;
 
public class UniversityManager {
 
    public List<Student> getStudentsFromTheSameGroup(List<Student> students, String group) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getGroup().equals(group))
                result.add(student);
        }
        return result;
    }
 
    public List<Teacher> getDocents(List<Teacher> teachers) {
        List<Teacher> result = new ArrayList<>();
        for (Teacher teacher : teachers)
            if (teacher.getTitle().equals("docent") || teacher.getTitle().equals("доцент"))
                result.add(teacher);
        return result;
    }
 
    // rating from and to inclusive
    public List<Student> getStudentsInRange(List<Student> students, double from, double to) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getRating() >= from && student.getRating() <= to)
                result.add(student);
        }
        return result;
    }
}