package PA4_Shapes.src.main.java;


import javafx.scene.paint.Color;


public class Circle extends Shape {

   public Circle(double radius, Color color, Position pos) {
   
      super.dim1 = radius;
      this.color = color;
      super.position = pos;
      calcArea();
   
   }
   public void setRadius( double radius ) {
      
      super.dim1 = radius;
      calcArea();
   
   }
   public double getRadius() {
       return super.dim1;
   }
   
   @Override
   public void calcArea() {
      super.area = Math.PI * Math.pow(super.dim1, 2);
   }
   @Override 
   public boolean selected(double x, double y) {
      //used the distance formula / pythagoream theorum
      //distance = ( (x1-x)^2 + (y1-y)^2 ) ^ (1/2)
      double x1 = Math.pow(x - super.position.getX(), 2);
      double y1 = Math.pow(y - super.position.getY(), 2);
      
      double r = Math.pow(super.dim1, 2); 
      
      return ( r >= x1 + y1 );   
   }
   @Override
   public Position getTopLeftCorner() {
      double topX = super.position.getX() - super.dim1;
      double topY = super.position.getY() - super.dim1;

      return new Position(topX, topY);   
   }
}
