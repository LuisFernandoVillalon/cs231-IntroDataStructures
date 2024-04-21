import java.util.*;

public class ArrayIndexOutOfBounds {

    public static void main (String[] args) {

        int[] arr = new int[100];

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (int)(Math.random() * 100); 
        }
        boolean loopState = true;
        
        while(loopState){
                   System.out.println("Enter array index: ");
                               
                    Scanner input = new Scanner(System.in);
                    int userInput = input.nextInt();
                  
                   try {
                     int i = 0;
                    while (userInput > 0 || userInput < 99) {
                        if (i == userInput) {
                                System.out.println("Index: " + i + ", Value: " + arr[i]);
                                loopState= false;
                                break;
                            }
                            ++i;
                     }
                 
                 
                 }catch(ArrayIndexOutOfBoundsException e) {
                     System.out.println("Out of Bounds. Index range 0-99 expected.");
                 }
        }
        


    }
}