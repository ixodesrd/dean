package ru.dean.model;//Source file: D:\\ForOS\\Desktop\\javaclassec\\Teacher.java


public class Teacher extends Person 
{
   
   /**
    * звание
    */
   private String title;
   
   /**
    * предмет который он читает
    */
   private String subject;
   
   /**
    * @param name
    * @param age
    * @param isMale
    * @param title
    * @param subject
    * @roseuid 59F78E4F0322
    */
   public Teacher(String name, int age, boolean isMale, String title, String subject) 
   {
        super(name, age, isMale);
        this.title = title;
        this.subject = subject;    
   }
    public Teacher()
    {
        super("", 0, false);
    }
   
   /**
    * @return java.lang.String
    * @roseuid 59F78E4F0310
    */
   public String getTitle() 
   {
        return title;    
   }
   
   /**
    * @param title
    * @roseuid 59F78E4F0311
    */
   public void setTitle(String title) 
   {
        this.title = title;    
   }
   
   /**
    * @return java.lang.String
    * @roseuid 59F78E4F0313
    */
   public String getSubject() 
   {
        return subject;    
   }
   
   /**
    * @param subject
    * @roseuid 59F78E4F0320
    */
   public void setSubject(String subject) 
   {
        this.subject = subject;    
   }
}
