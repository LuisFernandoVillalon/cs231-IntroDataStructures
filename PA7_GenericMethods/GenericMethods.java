package PA7_GenericMethods.src.main.java;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.lang.Math;

public class GenericMethods
{
   public static void main(String[] args)
   {
//       String str1 = "mufasa";
//       String str2 = "simba";
//       //System.out.println( max(str1, str2) );
//       
//       Car car1 = new Car("honda", "odessey", 1992);
//       Car car2 = new Car("chevy", "corvette", 2009);
//       //System.out.println( max(car1, car2) );
//       
//       String[] strArr = { "jon", "won", "ron", "con", "qon" };
//       int[] intArr = { 1, 5, 8, 2, 4, 9, };
//       // an ArrayList is helpful in filtering the type of data is stored in the array
//       ArrayList<String> list = new ArrayList<>();
//      list.add("a");
//      list.add("b");
//      list.add("c");
//      list.add("d");
//      list.add("e");
//       //System.out.println( max(strArr) );
//       //System.out.println( search(strArr, "cam") );
//       //System.out.println( binarySearch(strArr, "cam") );
//       //System.out.println( removeDuplicates( list ) );
//       //System.out.println( shuffle(list) );
//       strArr = sort( strArr);
//       for( int i = 0 ; i < strArr.length; i += 1 )
//             System.out.println( strArr[i] ); 
      
   }//end main
   public static <E extends Comparable<E>> E max( E obj1, E obj2 )
   {
      if( obj1.compareTo(obj2) > 0 ) {
         return obj1;
      } else {
         return obj2;
      }
   }//end max
   public static <E extends Comparable<E>> E max( E[] list ) 
   {
      E biggest = list[0];
      for( int i = 0; i < list.length; i += 1 ) {
         if( list[i].compareTo(biggest) > 0 ) {
            biggest = list[i];
         } 
      }
      return biggest;
   }//end max for array
   public static <E> int search( E[] list, E key ) 
   {  
      for( int i = 0; i < list.length; i += 1) {
         if( list[i].equals(key)  ) {
            return i;
         }
      }
      return -1;
   }//end search
   public static <E extends Comparable<E>> int binarySearch( E[] list, E key ) 
   {
      int low = 0;
      int high = list.length - 1;
      while( low <= high ) {
         int middle = (low + high) / 2;
         int comparison = key.compareTo(list[middle]);
         if( comparison == 0 ) {
            return middle;
         } else if( comparison < 0 ) {
            low = middle + 1;
         } else if( comparison > 0 ) {
            high = middle - 1;
         }
      }
      return -1;
   }//end binarySearch
   public static <E> ArrayList<E> removeDuplicates( ArrayList<E> list ) 
   {
      //A HashSet is used to store unique materials
      HashSet <E> set = new HashSet<>();
      ArrayList<E> newArr = new ArrayList<>();
      for( E item : list ) {
         // returns false if item already exists in set
         if( set.add(item) ) {
            newArr.add(item);
         }
      }
      return newArr;
   }//end removeDuplicates
   public static <E> ArrayList<E> shuffle( ArrayList<E> list ) 
   { 
      ArrayList<Integer> randArr = new ArrayList<>();
      ArrayList<E> newArr = new ArrayList<>();
      for (int i = 0; i < list.size(); i++) {
           newArr.add(null); 
      }
      
     while( randArr.size() < list.size() ) {
         int randomNumber =  (int) (Math.random() * (list.size()));
         if( !randArr.contains(randomNumber) ) {
            randArr.add(randomNumber);
         } 
      }
       
        for( int i = 0; i < randArr.size(); ++i ) {
           newArr.set(i , list.get(randArr.get(i)));
        }
        
      return newArr;
   }//end shuffle
   public static <E extends Comparable<E>> E[] sort( E[] list ) 
   { 
      
      for( int i = 0; i < list.length; i += 1 ) {
         E temp = list[i]; //makes a copy of element to insert
         int j = i - 1;
         while( j >= 0 && list[ j ].compareTo(temp) > 0 ) {
         
         //shift to the right
            list[ j + 1 ] = list[ j ];
            j -= 1;
         }
         list[ j + 1 ] = temp;
      }
      
      return list;
   }//end sort   
}