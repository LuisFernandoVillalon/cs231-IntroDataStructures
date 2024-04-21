package PA5_Invaders.src.main.java;
import PA5_Invaders.src.test.java.Constants;

import javafx.scene.paint.Color;

public class Bullet  {
   public Position position;
   public boolean live; 
   
    public Bullet( double x, double y ) {
       this.position = new Position( x,y );
       this.live = true;
    }
   public Position getPosition() {
      return this.position;
   }
   public boolean live() {
      return this.live;
   }
   public boolean hit() {
        return this.live = false;
   }
   //@Override
   public void move() {
      double bulletY = this.position.getY();
      bulletY -= Constants.BULLET_SPEED; 
      this.position.setY(bulletY);
   }
   

}