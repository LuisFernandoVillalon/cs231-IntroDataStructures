package PA5_Invaders.src.main.java;
import PA5_Invaders.src.test.java.Constants;


public class Position {
   public double x;
   public double y;
   public double width = Constants.ALIEN_WIDTH;
   public double height = Constants.ALIEN_HEIGHT;
   public Position(double x, double y) {
      this.x = x;
      this.y = y;
   }//end Position constructor
   
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
   
   public double getX() {  
      return this.x;     
   }
    
   public double getY() {
      return this.y;
   }
   
   public double getDomain() {
      return this.width;
   }
   public double getRange() {
      return this.height;
   }
   public boolean collision( Position pos ) {
      boolean lowerX = pos.getX() >= this.x;
      boolean upperX = pos.getX() <= this.x + this.width;
      boolean lowerY = pos.getY() >= this.y;
      boolean upperY = pos.getY() <= this.y + this.height;
      if ( ( upperX && lowerX ) && ( upperY && lowerY ) ) {
         return true;
      } else {
         return false;
      }
   }
  
   
}//end Position class