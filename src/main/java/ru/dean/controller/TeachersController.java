package ru.dean.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.dean.model.Teacher;
import ru.dean.model.User;
import ru.dean.seeds.allSeeder;

import java.io.IOException;
import java.util.List;


@Controller
public class TeachersController {

    allSeeder allSeeder = new allSeeder();


    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/teachers", method = RequestMethod.GET, produces = "application/json")
    public ModelAndView teachers() throws IOException {


        List<ru.dean.model.Teacher> teachers = allSeeder.teachers;

        //1. Convert object to JSON string
        Gson gson = new Gson();
        String json = gson.toJson(teachers);
        System.out.println(json);
        ObjectMapper mapper = new ObjectMapper();


//        System.out.println("Список студентов группы ФК-071 ");
//        List<teacher> FK = manager.getteachersFromTheSameGroup(teachers, "ФК-071");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("teachers", teachers);
        modelAndView.setViewName("teachers");
        modelAndView.addObject("json",mapper.writeValueAsString(teachers));
        return modelAndView ;
    }



    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/teacher", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Teacher>  teacherGet() throws IOException {


        return allSeeder.teachers;
    }

    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/teacher", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody List<Teacher>  teacherUpdate(@RequestBody final  String teacher) throws IOException {
        String decodedToUTF8 = new String(teacher.getBytes("ISO-8859-1"), "UTF-8");
        String []str =    decodedToUTF8.split("[,{}]");

        int id = Integer.parseInt(str[1].substring(str[1].indexOf(':')+1));
        for(int i=0;i<allSeeder.teachers.size();i++){
            if (allSeeder.teachers.get(i).getId()== id ){
                allSeeder.teachers.get(i).setTitle(str[5].replace('"',' ').substring(str[5].indexOf(':')+1));
                allSeeder.teachers.get(i).setSubject(str[6].replace('"',' ').substring(str[6].indexOf(':')+1));
                allSeeder.teachers.get(i).setAge(Integer.parseInt((str[2].replace('"',' ').substring(str[2].indexOf(':')+1))));
                allSeeder.teachers.get(i).setMale(Boolean.parseBoolean(str[4].replace('"',' ').substring(str[4].indexOf(':')+1)));
                allSeeder.teachers.get(i).setName(str[3].substring(str[3].replace('"',' ').indexOf(':')+1));
            }
        }

        return allSeeder.teachers;
    }

    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/teacher/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody List<Teacher>  teacherDel( @PathVariable("id") String id) throws IOException {
        int size = allSeeder.teachers.size();
        for(int i=0;i<size;i++){
            if (allSeeder.teachers.get(i).getId()== Integer.parseInt(id) ) {
                allSeeder.teachers.remove(i);
                size = allSeeder.teachers.size();
            }
            }

        return allSeeder.teachers;
    }



    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/teacher", method = RequestMethod.POST)
    public @ResponseBody Teacher teacherPost(@RequestBody final  String teacher) throws IOException {
        String decodedToUTF8 = new String(teacher.getBytes("ISO-8859-1"), "UTF-8");
        String []str =    decodedToUTF8.split("[,{}]");
        Teacher st = new Teacher();
                st.setTitle(str[5].replace('"',' ').substring(str[5].indexOf(':')+1));
                st.setSubject(str[6].replace('"',' ').substring(str[6].indexOf(':')+1));
                st.setAge(Integer.parseInt((str[2].replace('"',' ').substring(str[2].indexOf(':')+1))));
                st.setMale(Boolean.parseBoolean(str[4].replace('"',' ').substring(str[4].indexOf(':')+1)));
                st.setName(str[3].substring(str[3].replace('"',' ').indexOf(':')+1).replace('"',' '));
        allSeeder.teachers.add(st);
        return st;
    }


}
