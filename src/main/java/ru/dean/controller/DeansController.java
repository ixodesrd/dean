package ru.dean.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.dean.model.Dean;
import ru.dean.seeds.allSeeder;

import java.io.IOException;
import java.util.List;


@Controller
public class DeansController {

    allSeeder allSeeder = new allSeeder();


    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/deans", method = RequestMethod.GET, produces = "application/json")
    public ModelAndView deans() throws IOException {


        List<Dean> deans = allSeeder.deans;

        //1. Convert object to JSON string
        Gson gson = new Gson();
        String json = gson.toJson(deans);
        System.out.println(json);
        ObjectMapper mapper = new ObjectMapper();


//        System.out.println("Список студентов группы ФК-071 ");
//        List<dean> FK = manager.getdeansFromTheSameGroup(deans, "ФК-071");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("deans", deans);
        modelAndView.setViewName("deans");
        modelAndView.addObject("json",mapper.writeValueAsString(deans));
        return modelAndView ;
    }



    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/dean", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Dean>  deanGet() throws IOException {


        return allSeeder.deans;
    }

    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/dean", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody List<Dean>  deanUpdate(@RequestBody final  String dean) throws IOException {
        String decodedToUTF8 = new String(dean.getBytes("ISO-8859-1"), "UTF-8");
        String []str =    decodedToUTF8.split("[,{}]");

        int id = Integer.parseInt(str[1].substring(str[1].indexOf(':')+1));
        for(int i=0;i<allSeeder.deans.size();i++){
            if (allSeeder.deans.get(i).getId()== id ){
                allSeeder.deans.get(i).setFaculty(str[5].replace('"',' ').substring(str[5].indexOf(':')+1));
                allSeeder.deans.get(i).setAge(Integer.parseInt((str[2].replace('"',' ').substring(str[2].indexOf(':')+1))));
                allSeeder.deans.get(i).setMale(Boolean.parseBoolean(str[4].replace('"',' ').substring(str[4].indexOf(':')+1)));
                allSeeder.deans.get(i).setName(str[3].substring(str[3].replace('"',' ').indexOf(':')+1));
            }
        }

        return allSeeder.deans;
    }

    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/dean/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody List<Dean>  deanDel( @PathVariable("id") String id) throws IOException {
        int size = allSeeder.deans.size();
        for(int i=0;i<size;i++){
            if (allSeeder.deans.get(i).getId()== Integer.parseInt(id) ) {
                allSeeder.deans.remove(i);
                size = allSeeder.deans.size();
            }
            }

        return allSeeder.deans;
    }



    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/dean", method = RequestMethod.POST)
    public @ResponseBody Dean deanPost(@RequestBody final  String dean) throws IOException {
        String decodedToUTF8 = new String(dean.getBytes("ISO-8859-1"), "UTF-8");
        String []str =    decodedToUTF8.split("[,{}]");
        Dean st = new Dean();
                st.setFaculty(str[5].replace('"',' ').substring(str[5].indexOf(':')+1));
                st.setAge(Integer.parseInt((str[2].replace('"',' ').substring(str[2].indexOf(':')+1))));
                st.setMale(Boolean.parseBoolean(str[4].replace('"',' ').substring(str[4].indexOf(':')+1)));
                st.setName(str[3].substring(str[3].replace('"',' ').indexOf(':')+1).replace('"',' '));
        allSeeder.deans.add(st);
        return st;
    }


}
