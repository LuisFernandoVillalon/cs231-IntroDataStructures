package PA4_Invaders.src.test.java;

import PA4_Invaders.src.main.java.*;
import java.util.*;

public class TestInvaders
{
   public static void main(String[] args)
   {
     testInvader();
   }
      
   private static void testInvader()
   {
      Invader invader = new Octopus(0, 0);
      invader.hit();
//       invader.hit();
//       boolean[][] body = invader.getBody();
//    
//       for( boolean[] row : body )
//          System.out.println( Arrays.toString( row ) );
//          
//       System.out.println( invader.hit() );
   }
}