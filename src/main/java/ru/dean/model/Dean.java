package ru.dean.model;//Source file: D:\\ForOS\\Desktop\\javaclassec\\Dean.java


public class Dean extends Person 
{
   
   /**
    * факультет декана
    */
   private String faculty;
   
   /**
    * @param name
    * @param age
    * @param isMale
    * @param faculty
    * @roseuid 59F78E4F0345
    */
   public Dean(String name, int age, boolean isMale, String faculty) 
   {
        super(name, age, isMale);
        this.faculty = faculty;    
   }

    public Dean()
    {
        super("", 0, false);

    }
   
   /**
    * @return java.lang.String
    * @roseuid 59F78E4F0342
    */
   public String getFaculty() 
   {
        return faculty;    
   }
   
   /**
    * @param faculty
    * @roseuid 59F78E4F0343
    */
   public void setFaculty(String faculty) 
   {
        this.faculty = faculty;    
   }
}
