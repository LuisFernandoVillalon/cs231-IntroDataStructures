package PA9_Stacks.src.main.java;

import java.util.Stack;

public class Postfix
{
   private String expression;
   private Stack<Double> stack = new Stack<>(); 
   private String newNumber;
   private Double ans;
   
   public Postfix( String str )
   {
      this.expression = str;
      this.newNumber= "";
   }//end constructor   
   
   public double evaluate() { 
      for( int i = 0; i < this.expression.length(); i += 1 ) 
      {
         if( this.expression.charAt(i) == '+' ) {
            add(this.stack);
         }else if( this.expression.charAt(i) == '*' ) {
            multiply(this.stack);      
         } else if( this.expression.charAt(i) == '-' ) {
            substract(this.stack);   
         } else if( this.expression.charAt(i) == '/' ) {
            divide(this.stack);
         } else if( this.expression.charAt(i) == ' ' ) {
            if( this.newNumber == "" ) {
                  continue;
            }      
           this.stack.push( Double.parseDouble( this.newNumber ) );
           this.newNumber = "";
         } else {
            this.newNumber += this.expression.charAt(i);
         }
      }//end for-loop
      return ans;
   }//end runExpression
    public void add(Stack<Double> stack) 
    {
       Double total = 0.0;
       for( Double num : stack ) {
           total += num;
       }
       stack.clear();  
       stack.push(total);    
       ans = total; 
    }//end add
    public void multiply(Stack<Double> stack) 
    {
       Double total = 1.0;
       for( Double num : stack ) {
           total *= num;
       }
       stack.clear();  
       stack.push(total);    
       ans = total; 
    }//end multiply
    public void divide(Stack<Double> stack) 
    {
       Double total = 1.0;
       for( Double num : stack ) {
           total = num / total;
       }
       stack.clear();  
       stack.push(total);    
       ans = total; 
    }//end divide
       public void substract(Stack<Double> stack) 
    {
       Double total = 0.0;
       for( Double num : stack ) {
           total = num - total;
       }
       stack.clear();  
       stack.push(total);    
       ans = total; 
    }//end substract
}//end class