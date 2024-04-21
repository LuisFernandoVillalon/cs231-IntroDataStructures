package PA5_Invaders.src.main.java;

import PA5_Invaders.src.test.java.Constants;
import javafx.scene.paint.Color;

public class Squid extends Invader  {
   public String[] squidFiles = {"/SquidMatrix.txt"};
   public double speedXCoeff = 1;
   
   public Squid( double first, double second) {
      super(first, second);
      super.health = squidFiles.length;
      super.color = Color.GREEN;
      super.matrixDirectory = super.userDirectory + squidFiles[0];
      super.speedX = Constants.SQUID_SPEED;
      super.speedY = Constants.ALIEN_SPEED;
      super.setBody();
   }
   
   @Override
   public void move() {
      Position currPos = super.getPosition();
      double squidX = super.speedX * this.speedXCoeff + currPos.getX();
      double squidY = super.speedY + currPos.getY(); 
      this.speedXCoeff *= -1;
      currPos.setX(squidX);
      currPos.setY(squidY);
   }
   

}