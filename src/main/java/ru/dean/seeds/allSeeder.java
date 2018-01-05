package ru.dean.seeds;

import ru.dean.model.Dean;
import ru.dean.model.Student;
import ru.dean.model.Teacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class allSeeder {

    public List<Student> students = new ArrayList<>();
    public List<Teacher> teachers=new ArrayList<>();
    public List<Dean> deans=new ArrayList<>();

    public allSeeder() {
        Student st1 = new Student("Петя Пяточкин", 20, true, "ФК-071", 4.5);
        Student st2 = new Student("Вася Пупкин", 20, true, "ФК-071", 4.2);
        Student st3 = new Student("Маша Иванова", 20, false, "ПМ-081", 5.0);
        Student st4 = new Student("Катя Ермалаева", 21, false, "ПМ-081", 3.5);
        Student st5 = new Student("Ваня Калюжный", 20, true, "ФК-071", 3.6);
        Student st6 = new Student("Петя Нагорный", 20, true, "ФК-071", 4.5);
        Student st7 = new Student("Дима Бима", 20, true, "ФК-071", 4.5);
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        students.add(st6);
        students.add(st7);
        Teacher t1 = new Teacher("Марья Ивановна", 49, false, "доцент", "економика");
        Teacher t2 = new Teacher("Александр Павлович", 29, true, "аспирант", "електрооборудование");
        Teacher t3 = new Teacher("Светлана Ивановна", 32, false, "професор", "економика");
        Teacher t4 = new Teacher("Аристарх Эдуардович", 69, true, "професор", "филосовия древнего мира");

        teachers.add(t1);
        teachers.add(t2);
        teachers.add(t3);
        teachers.add(t4);

        Dean d1 = new Dean("Марья Ивановна", 49, false, "ФК");
        Dean d2 = new Dean("Дарья Ивановна", 49, false, "ПМ");

        deans.add(d1);
        deans.add(d2);
    }
}
