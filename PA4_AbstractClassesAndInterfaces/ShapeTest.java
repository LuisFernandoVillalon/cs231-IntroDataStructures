package PA4_Shapes.src.main.java;

import javafx.scene.paint.Color;



public class ShapeTest {
    public static void main(String[] args) {
         
         Position pos = new Position( 10, 40 );
         Rectangle rect = new Rectangle( 100, 100, Color.RED, pos );
         Circle circ = new Circle( 29, Color.BLUE, pos );

    }
}
