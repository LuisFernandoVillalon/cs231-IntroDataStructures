import java.util.*;

public class InputMismatch {

   public static void main (String[] args) {   
      boolean loopState = true;
      int sum = 0;
      while (loopState) {    
         try {
      
               System.out.println("Enter the first integer: ");
               Scanner firstInput = new Scanner(System.in);
               int firstInt = firstInput.nextInt();
               System.out.println("Enter the second integer: ");
               Scanner secondInput = new Scanner(System.in);
               int secondInt = secondInput.nextInt();
               sum = firstInt + secondInt;
               System.out.println(sum);
               break;
         
         }catch(InputMismatchException e) {
            System.out.println("Values must be integers.");
         }
      }
   
   
   }
   
 }