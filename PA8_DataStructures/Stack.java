package PA8_DataStructures.src.main.java;

import java.util.Arrays;

public class Stack<E>
{
   private E[] arr;
   private int size;
   
   public Stack()
   {
      this.arr = (E[]) new Object[2];
      this.size = 0;
   }//end constructor   
   public void push( E elem )
   {
        if( size == arr.length ) { 
               resize();
        }   
      arr[size] = elem; 
      size += 1;
   }//end push
   private void resize() {
        int newSize = arr.length * 2;
        arr = Arrays.copyOf(arr, newSize);
   }//end resize
   public E pop() {
      return arr[size - 1];
   }//end pop
}//end class