package ru.dean.model;//Source file: D:\\ForOS\\Desktop\\javaclassec\\Student.java


import com.fasterxml.jackson.annotation.JsonProperty;

public class Student extends Person
{
   
   /**
    * группа
    */
   @JsonProperty("group")

   private String group;
   
   /**
    * средний бал
    */
   @JsonProperty("rating")
   private double rating;
   
   /**
    * @param name
    * @param age
    * @param isMale
    * @param group
    * @param rating
    * @roseuid 59F78DE203E7
    */
   public Student(String name, int age, boolean isMale, String group, double rating)
   {
        super(name, age, isMale);
        this.group = group;
        this.rating = rating;    
   }

    public Student() {
        super("",0,false);
    }


    /**
    * @return double
    * @roseuid 59F78DDC03B1
    */
   public double getRating() 
   {
        return rating;    
   }
   
   /**
    * @param rating
    * @roseuid 59F78DDC03BE
    */
   public void setRating(double rating) 
   {
        this.rating = rating;    
   }
   
   /**
    * @return java.lang.String
    * @roseuid 59F78DE203C8
    */
   public String getGroup() 
   {
        return group;    
   }
   
   /**
    * @param group
    * @roseuid 59F78DE203C9
    */
   public void setGroup(String group) 
   {
        this.group = group;    
   }


}
