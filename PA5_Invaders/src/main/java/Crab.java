package PA5_Invaders.src.main.java;
import PA5_Invaders.src.test.java.Constants;
import javafx.scene.paint.Color;

public class Crab extends Invader  {
   public String[] crabFiles = {"/CrabMatrix.txt", "/HurtCrabMatrix.txt"};
   public Color HURT_COLOR; 
   
   public Crab( double first, double second) {
      super(first, second);
      super.health = crabFiles.length;
      super.color = Color.BLUE;
      super.speedX = Constants.CRAB_SPEED;
      super.speedY = Constants.ALIEN_SPEED;
      super.matrixDirectory = super.userDirectory + crabFiles[0];
      super.setBody();
   }//end constructor
   
   @Override
   public boolean hit() {
       super.hit();
       if (super.isAlive) {
            super.matrixDirectory = this.userDirectory + crabFiles[1];
            super.color = Color.YELLOW;
       }
        super.setBody();
        return super.isAlive;
   }//end hit
   
   @Override 
   public void move() {
      Position currPos = super.getPosition();
      double crabX = currPos.getX() + super.speedX;
      double crabY = currPos.getY() + super.speedY;      
      if( crabX > Constants.WIDTH ) {
          position.setX(0);
      } else {
         position.setX(crabX);
      }
      position.setY(crabY);
   }
      
 }//end class
