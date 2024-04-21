

public class Card {

  private char suit, rank;
  private String card; 
  private int value;
  
  public Card (String card) {
      this.card = card;
      setValue(); 
  }
  
  private void setValue() {
  
      this.value = getValue(); 
      this.card = getCard();
  
  }
  
  public int compareTo( Card c ) {
  
      return this.value - c.value;
  
  }
  
  public String getCard() {
      cardDesc();
      return this.card;
  }
  
  private void cardDesc() {
  
         String desc = "";
         switch(this.rank) {
            case 'a':
               desc += "Two of ";
               break;
            case 'd':
               desc += "Three of ";      
               break;   
            case 'e':
               desc += "Four of ";      
               break;   
            case 'f':
               desc += "Five of ";
               break;
            case 'g':
               desc += "Six of "; 
               break;              
            case 'h':
               desc += "Seven of ";
               break;
            case 'i':
               desc += "Eight of ";
               break;
            case 'j':
               desc += "Nine of ";
               break;
            case 'k':
               desc += "Ten of ";  
               break;                                           
            case 'J':
               desc += "Joker of ";
               break;
            case 'Q':
               desc += "Queen of ";
               break;
            case 'K':
               desc += "King of ";
               break;
            case 'A':
               desc += "Ace of "; 
               break;                                            
         } // end switch
         
         if (this.value >= 10) {
         
            switch(this.card.substring(2)) {
               case "D":
                  desc += "Diamonds";
                  break;
               case "H":
                  desc += "Hearts";
                  break;
               case "S":
                  desc += "Spades";
                  break;
               case "C":
                  desc += "Clovers";
                  break;                                                      
            }
         
         } else {
            switch(this.card.substring(1)) {
               case "D":
                  desc += "Diamonds";
                  break;
               case "H":
                  desc += "Hearts";
                  break;
               case "S":
                  desc += "Spades";
                  break;
               case "C":
                  desc += "Clovers";
                  break;                                                      
            }
         
         }
         
         this.card = desc;
  
  }// end cardDesc
  
  
  public int getValue() {
      calcValue();
      return this.value;
  }
  //private methods cannot be called from outside the class
  private void calcValue() {
     
      int val = 0;
      
      int digitIndex = 0;
      int i = 0;
      while(i < this.card.length()) {
         
         if (Character.isDigit(this.card.charAt(i))) {
            ++digitIndex;
         }
      
         ++i;
      }
      if (digitIndex > 0) {
      
         String digitStr = this.card.substring(0, digitIndex);
         int intDigit = Integer.parseInt(digitStr);
         this.value = intDigit;
         this.rank = (char) (intDigit + 97);
      
      } else {
      
            switch( this.card.charAt(0) ) {
               case 'J':
                  this.value = 11 ;
                  this.rank = 'J';
                  break;
               case 'Q':
                  this.value = 12;
                  this.rank = 'Q';
                  break;
               case 'K':
                  this.value = 13;
                  this.rank = 'K';
                  break;
               case 'A':
                  this.value = 1;
                  this.rank = 'A';
                  break;
            }//end switch

      }
        
      
  }//end calcGPA

   @Override
   public String toString()
   {
       return "Card: " + this.card + "\nValue: " + this.value ; 
   }

}