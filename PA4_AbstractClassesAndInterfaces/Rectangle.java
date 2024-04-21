package PA4_Shapes.src.main.java;

import javafx.scene.paint.Color;

public class Rectangle extends Shape {
   
   public double dim2; 
   
   public Rectangle( double dim1, double dim2, Color color, Position pos ) {
      super.dim1 = dim1; 
      this.dim2 = dim2;
      super.color = color;
      super.position = pos;
      
      calcArea();
      
   }
   
   public double getWidth() {
      return super.dim1;
   }
   
   public double getHeight() {
      return this.dim2;
   }
   
   public void setWidth( double width ) {
      super.dim1 = width;
      calcArea();
   }
   
   public void setHeight( double height ) {
      this.dim2 = height;
      calcArea();
   }
   @Override 
   public void calcArea(){
      super.area = super.dim1 * this.dim2;
   }
   @Override 
   public boolean selected( double x, double y ) {
      double x1 = super.position.getX();
      double y1 = super.position.getY();
      
      boolean xRange = (x >= x1 && x <= x1 + super.dim1);
      boolean yRange = (y >= y1 && y <=  y1 + this.dim2);
      
      return ( xRange && yRange );
   }
   @Override
   public Position getTopLeftCorner() {
      return super.position;   
   }
      
}