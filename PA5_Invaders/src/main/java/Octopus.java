package PA5_Invaders.src.main.java;
import PA5_Invaders.src.test.java.Constants;


import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;
import java.util.Timer;


public class Octopus extends Invader  {
   public String[] octopusFiles = {"/OctopusMatrix.txt", "/HurtOctopusMatrix.txt", "/DamagedOctopusMatrix.txt"};
   public Timer timer = new Timer(); 
   public int counter;
   public int xUlim;
   public int xLlim;
   public double speedXCoeff = 1;
   
   public Octopus( double first, double second) {
      super(first, second);
      super.health = octopusFiles.length;
      super.color = Color.RED;
      super.speedX = Constants.OCTOPUS_SPEED;
      super.speedY = Constants.ALIEN_SPEED;
      super.matrixDirectory = this.userDirectory + octopusFiles[0];
      super.setBody();
   }//end constructor
   
   @Override
   public boolean hit() {
       timer.start();
       super.hit();
       if (super.isAlive) {
         if (super.health == 1) {
             super.matrixDirectory = this.userDirectory + octopusFiles[2];
             super.color = Color.PINK;
         } else {
             super.matrixDirectory = this.userDirectory + octopusFiles[1];
             super.color = Color.ORANGE;
         }
       }
        super.setBody();
        return super.isAlive;
   }//end hit
   
   public void setXUlim( int x ) {
      this.xUlim = x;
   }
   public void setXLlim( int x ) {
      this.xLlim = x;
   }   
   
   @Override 
   public void move() {
      Position currPos = super.getPosition();
      double octoX = currPos.getX() + super.speedX * this.speedXCoeff;
      double octoY = currPos.getY() + super.speedY;    
      if (octoX  >= this.xUlim || octoX <= this.xLlim) {
         this.speedXCoeff *= -1;
      }
      currPos.setX(octoX);
      currPos.setY(octoY);
   }
   
   public void reset() {
      super.health = octopusFiles.length;
      super.color = Color.RED;
      super.matrixDirectory = this.userDirectory + octopusFiles[0];
      setBody();
      timer.resetHit();
   }
   
   public void blink() {
      if (this.counter > 1000) {
         this.counter = 0;
      }
      if (this.counter % 2 == 0) {
         super.color = Color.WHITE;
      } else {
         super.color = Color.PURPLE;
      }
      ++this.counter;
   }
   
   public class Timer extends AnimationTimer {
      public long last;
      public long hitTime;
      public boolean hit = true;
      @Override
      public void handle( long now ) {
         if( this.hit ) {
            this.hitTime = now;
            this.hit = false;
         }
         if( now - this.last > Constants.TIME_INTERVAL ) {
            blink();
            this.last = now;
         }
         if( now - this.hitTime > 500 * Constants.TIME_INTERVAL) {
            reset();
            timer.stop();
         }
      }//end handle
      
      public void resetHit() {
         this.hit = true;
      }
      
   }//end Timer
   
 }//end class
