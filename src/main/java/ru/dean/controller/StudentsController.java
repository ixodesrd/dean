package ru.dean.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.dean.model.Student;
import ru.dean.model.Teacher;
import ru.dean.model.UniversityManager;
import ru.dean.model.User;
import ru.dean.seeds.allSeeder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@Controller
public class StudentsController {

    allSeeder allSeeder = new allSeeder();
    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("template");
        return modelAndView;
    }

    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json")
    public ModelAndView students() throws IOException {

        List<Student> students = allSeeder.students;
        List<Teacher> teachers = allSeeder.teachers;

        //1. Convert object to JSON string
        Gson gson = new Gson();
        String json = gson.toJson(students);
        System.out.println(json);
        ObjectMapper mapper = new ObjectMapper();


//        System.out.println("Список студентов группы ФК-071 ");
//        List<Student> FK = manager.getStudentsFromTheSameGroup(students, "ФК-071");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("students");
        modelAndView.addObject("json",mapper.writeValueAsString(students));
        return modelAndView ;
    }



    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/Student", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Student>  studentGet() throws IOException {


        return allSeeder.students;
    }

    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/Student", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody List<Student>  studentUpdate(@RequestBody final  String student) throws IOException {
        String decodedToUTF8 = new String(student.getBytes("ISO-8859-1"), "UTF-8");
        String []str =    decodedToUTF8.split("[,{}]");

        int id = Integer.parseInt(str[1].substring(str[1].indexOf(':')+1));
        for(int i=0;i<allSeeder.students.size();i++){
            if (allSeeder.students.get(i).getId()== id ){
                allSeeder.students.get(i).setGroup(str[5].replace('"',' ').substring(str[5].indexOf(':')+1));
                allSeeder.students.get(i).setRating(Double.parseDouble(str[6].replace('"',' ').substring(str[6].indexOf(':')+1)));
                allSeeder.students.get(i).setAge(Integer.parseInt((str[2].replace('"',' ').substring(str[2].indexOf(':')+1))));
                allSeeder.students.get(i).setMale(Boolean.parseBoolean(str[4].replace('"',' ').substring(str[4].indexOf(':')+1)));
                allSeeder.students.get(i).setName(str[3].substring(str[3].replace('"',' ').indexOf(':')+1));
            }
        }

        return allSeeder.students;
    }

    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/Student/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody List<Student>  studentDel( @PathVariable("id") String id) throws IOException {
        int size = allSeeder.students.size();
        for(int i=0;i<size;i++){
            if (allSeeder.students.get(i).getId()== Integer.parseInt(id) ) {
                allSeeder.students.remove(i);
                size = allSeeder.students.size();
            }
            }

        return allSeeder.students;
    }



    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/Student", method = RequestMethod.POST)
    public @ResponseBody Student studentPost(@RequestBody final  String student) throws IOException {
        String decodedToUTF8 = new String(student.getBytes("ISO-8859-1"), "UTF-8");
        String []str =    decodedToUTF8.split("[,{}]");
        Student st = new Student();
                st.setGroup(str[5].replace('"',' ').substring(str[5].indexOf(':')+1));
                st.setRating(Double.parseDouble(str[6].replace('"',' ').substring(str[6].indexOf(':')+1)));
                st.setAge(Integer.parseInt((str[2].replace('"',' ').substring(str[2].indexOf(':')+1))));
                st.setMale(Boolean.parseBoolean(str[4].replace('"',' ').substring(str[4].indexOf(':')+1)));
                st.setName(str[3].substring(str[3].replace('"',' ').indexOf(':')+1));
        allSeeder.students.add(st);
        return st;
    }


}
