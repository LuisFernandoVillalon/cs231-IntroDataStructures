package PA4_Shapes.src.main.java;

import javafx.scene.paint.Color;


public abstract class Shape implements Relatable {
    
   protected double dim1;
   protected double area;
   protected Position position; 
   protected Color color; 
      
      public Color getColor() {
         return this.color;
      }

      public Position getPosition() {
         return this.position;
      } 
      
      public double getArea() {
         return this.area;
      }
      
      public void setColor( Color color ) {
         this.color = color;
      }
      
      public void setDim1( double dim1 ) {
         this.dim1 = dim1;
      }
      
      @Override
      public double compareTo( Shape s ) {
         return this.area - s.getArea();
      }
      
      public abstract Position getTopLeftCorner();
      public abstract boolean selected( double x, double y );
      public abstract void calcArea();
      
}