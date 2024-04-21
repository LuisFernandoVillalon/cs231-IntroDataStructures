package PA6_Recursion.src.main.java;
import java.lang.Math;

public class RecursiveMethods
{
   
  public static int sumDigits( long number ) { 
       if( number == 0 ) {
         return 0;
       }
       return( (int) number % 10 + sumDigits( number / 10 ) );
  }//end sumDigits
  
  public static int findLargest( int[] arr ) {  
      return findLargest(0 , arr);                        
  }//end findLargest
  
  public static int findLargest( int index, int[] arr ) {
      int max = 0;
      if (index == arr.length - 1) {
         return arr[index];
      } else {    
            max = Math.max( arr[index], findLargest(index + 1, arr) );
            return max;
      }
   }//end findLargest
   
  public static int countUpper( String str ) {
      int sum = 0;
      if( str.length() == 0 ) {
         return 0;
      } else {
         if( Character.isUpperCase(str.charAt(0)) ) {
           sum = 1;  
         }else {
            sum =  0;
         }
         return sum + countUpper(str.substring(1));
      }
  }//end countUpper
  
  public static int binToDec( String bin ) {
         if (bin.length() == 0 ) {
            return 0;
         } 
         int equation = Character.getNumericValue(bin.charAt(0)) * (int)Math.pow(2, bin.length() - 1);
         int sum = equation + binToDec(bin.substring(1));
         return sum;       
  }//end binToDec
  
  public static int hexToDec( String hex ) {
     int digit = 0;
         if (hex.length() == 0 ) {
            return 0;
         } 
         if( Character.isDigit(hex.charAt(0)) ) {
            digit = Character.getNumericValue(hex.charAt(0));
         } else {
               switch( Character.toString(hex.charAt(0)).toLowerCase() ) {
                  case "a": 
                        digit = 10;
                        break;
                  case "b": 
                        digit = 11;
                        break;
                  case "c": 
                        digit = 12;
                        break;
                  case "d": 
                        digit = 13;
                        break;
                  case "e": 
                        digit = 14;
                        break;
                  case "f": 
                        digit = 15;  
                        break;                                                                                        
               }
         }
         int equation = digit * (int)Math.pow(16, hex.length() - 1);
         int sum = equation + hexToDec(hex.substring(1));
         return sum; 
  }//end hexToDec
  
  public static double sumSeries(double num) {
      if( num == 1 ) {
         return num;
      }
      return ( (1/num) + sumSeries(num - 1) );
  }//end sumSeries
  
  public static int factorial( int num ) {
      if( num == 1 ) {
         return num;
      }
      return ( num * factorial(num - 1) );
  }//end factorial
  
  public static int practice( int num ) {
      int a = num / (2*num + 1);
      if( num == 1 ) {
         return a;
      }
      return ( a + practice(num - 1) );
  }//end practice  
  

}