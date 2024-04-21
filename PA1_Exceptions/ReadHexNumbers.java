import java.io.*;
import java.util.*;

public class ReadHexNumbers {

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
    
        
        try {
            Scanner fileScanner = new Scanner(new File("HexValues.txt"));
            while (fileScanner.hasNext()) {
                String hex = fileScanner.next();
               int dec = 0;
               String msg = "";
               try {
                  dec = hex2dec(hex);      
                  msg = "Hex: " + hex + ", Dec: " + dec;
               }catch(NumberFormatException e){
                  msg = "Invalid hex value. Expected 0-9, a-z, A-Z.";
               }  
               try (PrintWriter writer =  new PrintWriter(new BufferedWriter(new FileWriter("DecValues.txt", true)))) {
                  System.out.println(msg);
                  writer.println(msg); 
               } catch(IOException e) {
                  System.out.println("err printing in file.");
               }
                     
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("HexValues.txt not found.");
            return;
        }

   
   }
   
 }