package PA9_Stacks.src.main.java;

import java.util.Stack;

public class LargeNumber
{
   private String number;
   private Stack<Integer> numStack = new Stack<>(); 
   
   public LargeNumber(String number)
   {
      this.number = number;
      this.numStack = new Stack<>();
      stackNumber();
   }//end constructor   
   public Stack<Integer> getNumStack() 
   {
      stackNumber();
      return this.numStack;
   }//end getNumStack
   public String getNumber() 
   {
      return this.number;
   }//end getNumber
   private void stackNumber() 
   {
      this.numStack.clear();
      for( int i = 0; i < this.number.length(); i += 1 ) 
      {
         int digit = Character.getNumericValue( this.number.charAt(i) );  
         this.numStack.push(digit);         
      }//end for-loop

   }//end stackNumber   

}//end class