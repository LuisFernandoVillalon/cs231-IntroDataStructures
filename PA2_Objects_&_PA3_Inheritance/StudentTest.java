

public class StudentTest {
    public static void main(String[] args) {
         Student s  = new Student("Lucia Gomez", "female", 20);
         System.out.println( "GPA: " + s.getGPA() );
         char[] grades = {'A', 'b', 'B', 'a', 'C'};
         s.setGrades( grades );
         System.out.println( s );
    }
}
