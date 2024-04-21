import java.io.*;
import java.util.*;
// import Position;

public class Invader {

   private boolean[][] body;
   private Position position;
   private String matrixDirectory = "InvaderMatrices";

  public Invader (String type, double x, double y) {
         this.position = new Position( x,y );
         this.body = new boolean[8][12];
         switch( type.toLowerCase() ) {
            case "octopus":
               matrixDirectory += "/OctopusMatrix.txt";
               break;
            case "squid":
               matrixDirectory += "/SquidMatrix.txt";
               break;
            case "crab":
               matrixDirectory += "/CrabMatrix.txt";
               break;                              
         }//end switch
         setBody();
  }//end constructor

      public Position getPosition() {
         position.getX();
         position.getY();
         return this.position;
      } 

   public boolean[][] getBody() {
      setBody();
      return this.body;
   }      
   
   //creates a body for the crab in boolean
   public void setBody() {
      try {
         File f = new File(matrixDirectory);
         Scanner scan = new Scanner(f);
         int indexMatrixOne = 0;
         int indexMatrixTwo = 0;
         while ( scan.hasNextLine() ) {
            
            String currline = scan.nextLine();
            String[] currLineArr = currline.split(",");
            for (String binary : currLineArr) {
               
               
               if (binary.equals("1")) {
                     this.body[indexMatrixOne][indexMatrixTwo] = true;
               } else if (binary.equals("0")) {
                     this.body[indexMatrixOne][indexMatrixTwo] = false;
               }
               ++indexMatrixTwo;
            
            }
            indexMatrixTwo = 0;
         ++indexMatrixOne;
         }//end while

      }catch(FileNotFoundException e) {
         System.out.println("File not found.");
      }
   }
   
}