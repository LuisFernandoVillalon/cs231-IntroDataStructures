import java.io.*;
import java.util.*;

public class Position {
   public double x, y;
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
  
   
}//end Position class