package PA9_Stacks.src.main.java;

import java.util.Stack;

public class ArithmeticOperator
{
   private LargeNumber num1;
   private LargeNumber num2; 
   private LargeNumber result;
   
   public ArithmeticOperator(String num1, String num2) {
      this.num1 = new LargeNumber(num1);
      this.num2 = new LargeNumber(num2);
      this.result = new LargeNumber("");
      
   }//end constructor   
   public String addNumbers() {
      int passTheOne = 0;
      Stack<Integer> stackNum1 = this.num1.getNumStack(); 
      Stack<Integer> stackNum2 = this.num2.getNumStack(); 
      Stack<Integer> stackResult = this.result.getNumStack(); 
      
     while( !stackNum1.isEmpty() || !stackNum2.isEmpty() ) {
         if( stackNum1.isEmpty() ) {
            stackResult.add( stackNum2.peek() + passTheOne );
            return convertToString( stackResult );
         } else if( stackNum2.isEmpty() ) {
            stackResult.add( stackNum1.peek() + passTheOne );
            return convertToString( stackResult );
         } else {
            int sum = stackNum1.peek() + stackNum2.peek() + passTheOne;
            if( sum >= 10 ) {
               String doubleDigit = "" + sum;
               if( stackNum1.size() == 1 && stackNum2.size() == 1 ) {
                  stackResult.add( sum );
                  passTheOne = 0;
               } else {
                  stackResult.add( Character.getNumericValue( doubleDigit.charAt(1) ) );
                  passTheOne = 1;
               }
            } else {
               stackResult.add( sum );
               passTheOne = 0;
            }
            stackNum1.pop();
            stackNum2.pop();
         }
     }//end while-loop 
     return convertToString( stackResult );
   }//end stackNumber   
   private String convertToString( Stack<Integer> stack ) {
        StringBuilder ans = new StringBuilder();
       while(!stack.isEmpty()) {
            ans.append(stack.peek());
            stack.pop();
        }
        return ans.toString();
   }//end convertToString
   public String substractNumbers() {
        boolean isNegative = num1.getNumber().compareTo(num2.getNumber()) < 0;
        if (isNegative) {
            LargeNumber temp = num1;
            num1 = num2;
            num2 = temp;
        }
        String result = subtractionHelper();
        result = removeLeadingZeroes(result);
        if(isNegative) {
            result = "-" + result;
        }
        return result;
   }//end substractNumbers
    private String subtractionHelper() {
        StringBuilder resultStr = new StringBuilder();
        int carryOne = 0;
        Stack<Integer> stackNum1 = this.num1.getNumStack();
        Stack<Integer> stackNum2 = this.num2.getNumStack();
        while( !stackNum1.isEmpty() || !stackNum2.isEmpty() ) {
            int digit1 = stackNum1.isEmpty() ? 0 : stackNum1.pop();
            int digit2 = stackNum2.isEmpty() ? 0 : stackNum2.pop();
            int diff = digit1 - digit2 - carryOne;
            if (diff < 0) {
                diff += 10;
                carryOne = 1;
            } else {
                carryOne = 0;
            }
            resultStr.insert(0, diff);
        }//end while-loop
       return resultStr.toString();
    }//end substractionHelper
    private String removeLeadingZeroes( String result ) {
       while(result.charAt(0) == '0') {
           result = result.replace(String.valueOf('0'), "");
       }
       return result;
    }
}//end class