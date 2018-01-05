package ru.dean.util;

        import com.fasterxml.jackson.databind.ObjectMapper;
        import ru.dean.model.Student;

        import java.io.File;
        import java.io.IOException;

public class Converter {

    private final static String baseFile = "student.json";

    public static void toJSON(Student student) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), student);
        System.out.println("json created!");
    }

    public static Student toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), Student.class);
    }

}
