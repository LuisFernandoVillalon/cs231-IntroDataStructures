import java.io.*;
import java.util.*;

public class ReadUserAndPassword {

   public static void main (String[] args) {   
   
        String expectedUsername = "";
        String expectedPassword = "";
        
        try {
            Scanner fileScanner = new Scanner(new File("UserAndPass.txt"));
            expectedUsername = fileScanner.nextLine();
            expectedPassword = fileScanner.nextLine();
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("UserAndPass.txt not found.");
            return;
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        if (username.equals(expectedUsername)) {
            System.out.println("Correct username entered.");
        } else {
            System.out.println("Incorrect credentials entered.");
            return;
        }
        
        if (password.equals(expectedPassword)) {
            System.out.println("Correct password entered.");
        } else {
            System.out.println("Incorrect credentials entered.");
        }
   
   }
   
 }