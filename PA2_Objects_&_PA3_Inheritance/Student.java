

public class Student {

  private String name, gender;
  private int age; 
  private char[] grades;
  private double gpa;
  
  public Student(String name, String gender, int age) {
      this.name = name;
      this.gender = gender;
      this.age = age;  
  }
  
  public void setGrades(char[] grades) {
      this.grades = grades; 
  }
  
  public double getGPA() {
      calcGPA();
      return this.gpa;
  }
  //private methods cannot be called from outside the class
  private void calcGPA() {
      try {
      double sum = 0.0;
      // Primitive classes have a corresponding wrapper class
         for( Character c : this.grades ) {
            switch( c ) {
               case 'A':
               case 'a':
                  sum += 4.0;
                  break;
               case 'B':
               case 'b':
                  sum += 3.0;
                  break;
               case 'C':
               case 'c':
                  sum += 2.0;
                  break;
               case 'D':
               case 'd':
                  sum += 1.0;
                  break;
            }//end switch
            
         }//end for-each
         
         this.gpa = sum/grades.length;
         
      }catch(NullPointerException e) {
         System.out.println("Grades for students are missing.");
      }//end catch
      
  }//end calcGPA

   @Override
   public String toString()
   {
      return "Name: " + this.name + "\nAge: " + this.age + "\nGPA: " + this.getGPA(); 
   }

}