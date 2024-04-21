

public class CardTest {
    public static void main(String[] args) {
         Card card1 = new Card("10D");
         Card card2 = new Card("AH");
         System.out.println( card1 );
         System.out.println( card2 );
         int ans = card2.compareTo( card1 );
         System.out.println( "Answer: " + ans );
    }
}
