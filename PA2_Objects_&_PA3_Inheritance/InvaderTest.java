import java.util.*;

public class InvaderTest {

     public static void main(String[] arg) {
         Invader invader = new Invader("octopus", 50.0, 20.0);
         boolean[][] body = invader.getBody();
         double x = invader.getPosition().getX();
         double y = invader.getPosition().getY();
         System.out.println( "Position - x: " + x + " y: " + y );     
         for( boolean[] row : body )
         System.out.println( Arrays.toString( row ) );
     }
     
}     

