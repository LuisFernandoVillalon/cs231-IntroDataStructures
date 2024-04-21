import java.util.*;

public class NumberFormat {

   public static int hex2dec(String hex) {
      int total = 0;
      
         for (int i = 0; i < hex.length(); ++i) {
         
            int digit = (int) hex.charAt(i);
            if ( ((48 <= digit) && (digit <= 57)) || ((97 <= digit) && (digit <= 102)) || ((65 <= digit) && (digit <= 70)) ) {
               
                  int baseST = (int) Math.pow(16, hex.length() - (i+1));
                  int ans = 0;
                  int val = 0;
                  
             if( !Character.isDigit(hex.charAt(i)) ) {
             
                char letterChar = hex.charAt(i);
                
                switch( letterChar ) 
                {
                      case 'A':
                      case 'a':
                         val = 10;
                         break;
                      case 'B':
                      case 'b':
                         val = 11;
                         break;
                      case 'C':
                      case 'c':
                         val = 12;
                         break;
                      case 'D':
                      case 'd':
                         val = 13;
                         break;
                      case 'E':
                      case 'e':
                         val = 14;
                         break;
                      case 'F':
                      case 'f':
                         val = 15;
                         break;
                }
             } else {
                val = Character.getNumericValue(hex.charAt(i));
             }
             
             ans = baseST * val;
             total += ans;
            } else {
               throw new NumberFormatException();
            }
        }//ends loop
 
      
      return total;
   }
   
   public static void main (String[] args) {
      boolean loopState = true;
      while (loopState) {
         try {
            System.out.println("Enter hex value to convert: ");
            Scanner scan = new Scanner (System.in);
            String hex = scan.nextLine();       
            int tmp = 0;
            tmp = hex2dec(hex);
            System.out.println("Decimal equivalent: " + tmp);
            break;
         
         }catch(NumberFormatException e) {
            System.out.println("Invalid hex value. Expected 0-9, a-f, A-F");
         }
      
      }//end LoopState

   }//end main   
   

   
}//end NumberFormat


