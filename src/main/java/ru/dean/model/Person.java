package ru.dean.model;//Source file: D:\\ForOS\\Desktop\\javaclassec\\Person.java


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public abstract class Person implements Serializable {
    @JsonProperty("name")
    private String name;
    @JsonProperty("age")
    private int age;


    @JsonProperty("id")
    private int id;

    protected static int idAuto;

    /**
     * является ли мальчиком
     */
    @JsonProperty("isMale")
    private boolean isMale;

    /**
     * @param name
     * @param age
     * @param isMale
     * @roseuid 59F78DA10068
     */
    public Person(String name, int age, boolean isMale) {
        this.id = idAuto;
        idAuto++;
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return int
     * @roseuid 59F78D8900E6
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age
     * @roseuid 59F78D890105
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return boolean
     * @roseuid 59F78D890179
     */
    public boolean isMale() {
        return isMale;
    }

    /**
     * @param isMale
     * @roseuid 59F78D8901AD
     */
    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }

    /**
     * @return java.lang.String
     * @roseuid 59F78DA002DD
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     * @roseuid 59F78DA0030C
     */
    public void setName(String name) {
        this.name = name;
    }
}
