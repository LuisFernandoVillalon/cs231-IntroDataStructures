package PA9_Stacks.src.main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class BalanceChecker
{
   private String filename;
   private String text;
   private File file;
   private Scanner scan;
   private Stack<Character> lastPushed; 
   
   public BalanceChecker(String filename)
   {
         this.filename = filename;
         this.text= "";
         this.file = new File(filename);
         this.lastPushed = new Stack<>();
   }//end constructor   
   
   public boolean parse() 
   {
        try {
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                text += scan.nextLine();
            }
            scan.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return false;
        }
   }//end parse
   
   public boolean balance() 
   {
      for( int i = 0; i < this.text.length(); i += 1 )
      {
          char currChar = this.text.charAt(i);
         if( currChar == '{' || currChar == '(' || currChar == '[')
         {
            this.lastPushed.push(this.text.charAt(i));
         } else if(currChar == '}' || currChar == ')'  || currChar == ']')
         {
             if (this.lastPushed.isEmpty()) {
                 System.out.println("Unbalanced! " + currChar + " has no initial notation.");
                 return false;
             } else {
                 char stackTop = this.lastPushed.pop();
                 if ((currChar == ')' && stackTop != '(') || (currChar == '}' && stackTop != '{') || (currChar == ']' && stackTop != '[')) {
                     System.out.println("Unbalanced! Mismatched symbols: " + stackTop + " and " + currChar);
                     return false;
                 }
             }

         }
      }
       if (!this.lastPushed.isEmpty()) {
           System.out.println("Unbalanced! " + this.lastPushed.peek() + " was left opened.");
           return false;
       }
       System.out.println("Balanced!");
      return true;
   }//end balance

}//end class