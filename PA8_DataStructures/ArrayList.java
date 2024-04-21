package PA8_DataStructures.src.main.java;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements Iterable<E> 
{
   private E[] arr;
   private int size = 0;
   
   //You can have more than one constructor, a contructor may or may not have parameters depending on your application.
   public ArrayList()
   {
      this.arr = (E[]) new Object[2];
      this.size = 0;
   }//end constructor 
   
   //constructors must be distinct when it comes to the amount of parameters they have, you cannot have more than one zero
   //parameter constructor, only one constructor would execute
   public ArrayList( int size ) 
   {
      this.arr = (E[]) new Object[size];
   }  
   
   public void add( E elem )
   {
  
        if( size == arr.length ) { 
               resize();
        }   
        if( size == -1 ) {
            size = 0;
        }
      arr[size] = elem; 
      size += 1;
  }//end add
  
  public void add( int index, E elem ) 
  {
        if( size == arr.length ) { 
               resize();
        } 
        for( int i = size; i >= index; i -= 1 ) 
            arr[ i + 1 ] = arr[ i ];
            
        arr[index] = elem;
        size += 1;
  }//end add with index
  
  public E remove( int index ) 
  {   
      E temp = arr[index];
      size -= 1;
      if( index == size) {
         arr[index] = null;
         return temp;
      }
      for( int i = index; i < size; i += 1 ) 
            arr[i] = arr[ i + 1 ];
//      arr[ size ] = null;
      return temp;
  }//end remove
  public int size() 
  {
    return size;
  }//end size
  public E get( int index ) 
  {
      return this.arr[index];
  }//end get
  
   private void resize() {
        int newSize = size * 2;
        arr = Arrays.copyOf(arr, newSize);
   }//end resize
  
   @Override
   public Iterator<E> iterator() {
       return new ListIterator();
   }//end iterator
 
   private class ListIterator implements Iterator<E> {
       private int index = 0;
 
       @Override
       public boolean hasNext() {
           return index < size;
       }//end hasNest
 
       @Override
       public E next() {
           if (hasNext()) {
               E temp = arr[index];
               index += 1;
               return temp;
           } else {
               return null;
           }
       }//end next
       
   }//end ListIterator 
   
   @Override
   public String toString()
   {
      String listAsString = "[";
      
      for( int i = 0; i < size-1; i += 1 ) {
         listAsString += arr[i] + ", ";
      }
      listAsString += arr[size-1] + "]";
      return listAsString;
   }//end toString
   
}//end class