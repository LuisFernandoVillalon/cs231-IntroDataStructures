package PA5_Invaders.src.main.java;
import PA5_Invaders.src.test.java.Constants;

import java.io.*;
import java.util.*;
import javafx.scene.paint.Color;

public class Player {

   protected Position position;
   protected int health;
   protected Color color;
   protected boolean isAlive; 
   protected boolean[][] body;
   protected String matrixDirectory = "PA5_Invaders/src/main/java/InvaderMatrices/Spaceship.txt";

  public Player ( double x, double y) {
         
         this.position = new Position( x,y );
         this.body = new boolean[8][12];
         this.isAlive = true;
         setBody();
  }//end constructor
  
   public boolean[][] getBody() {
      setBody();
      return this.body;
   }//end getBody()  
   
   public Color getColor() {
      return this.color;  
   }//end getColor()    
   
   public Position getPosition() {
         position.getX();
         position.getY();
         return this.position;
   }//end getPosition() 
  
   public boolean alive() {
      return this.isAlive;
   }
   
   //creates a body for the crab, squid, or octopus in boolean
   public void setBody() {
   
      try {
         File f = new File(this.matrixDirectory);
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
         scan.close();
      }catch(FileNotFoundException e) {
         System.out.println(this.matrixDirectory + " not found.");
      }
      
   }// end setBody
   
   
   public void move( double deltaX ) {
        double playerX = this.position.getX() + deltaX;
        if (playerX <= 0) {
            playerX = 0;
        } else if (playerX >= Constants.WIDTH) {
            playerX = Constants.WIDTH - Constants.PLAYER_WIDTH;
        }
       this.position.setX(playerX);
   }
   
}//end class