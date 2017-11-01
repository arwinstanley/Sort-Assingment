import java.util.*;
/**
 * Class to hold values and perform functions like a real deck of cards
 * 
 * @author WinstanleyA
 * @Date 10/4/17
 */
public class Deck {
   private int numSuits = 4;
   private int numCardsPerSuit = 13;
   private Card [] cards = new Card[numSuits*numCardsPerSuit];
   private int topCard = (cards.length)-1 ;
   private boolean hand = false;
   private CardComp compy = new CardComp();

	/**
	 * Default constructor to make a full sorted deck
	 * 
	 * @param none
	 */
  public Deck() {
	  for (int i = 0; i<numSuits; i++) {
		  for(int j = 0; j < numCardsPerSuit;j++) {
			  cards[(j+(i*numCardsPerSuit))] = new Card(i,j+1);
		  }
	  }
  }
	/**
	 * creates a deck with either sorted or unsorted contents
	 * @param sort is a boolean true if you want a sorted deck false otherwise
	 */
  public Deck(boolean sort) {
       fill(sort);
	   }
	/**
	 * returns a "deck" that represents a hand of cards with limited functionality 
	 * 
	 * @param cph is the cards per hand
	 */
  public Deck(int cph) {
	  if (cph <= 0)
		  return;
	  cards = new Card[cph];
	  hand = true;
	  }
	/**
	 * this method is based of the substring method from string and creates a sub deck from the main deck
	 *
	 * @param l is the left index
	 * @param r is the right index
	 * @param arr is the original array of cards
	 */
  public Deck(int l, int r, Card[] arr) {
	  hand = true;
	  Card[] newOne = new Card[r+1];
	  for(int i = 0; i< newOne.length; i++) {
		  newOne[i] = arr[i+l];
	  }
	  cards = newOne;
  }
	/**
	 * this method fills an otherwise empty deck either sorted or unsorted based on the parameter
	 *
	 * @param sort is a boolean true if you want a sorted deck false otherwise
	 */
  public void fill(boolean sort) {
	  if (hand)
		  return;
	  if(sort) {
		  for (int i = 0; i<numSuits; i++) {
			  for(int j = 0; j < numCardsPerSuit;j++) {
				  cards[(j+(i*numCardsPerSuit))] = new Card(i,j+1);
			  }
		  }
	  }
	  else {
		  for (int i = 0; i<numSuits; i++) {
			  for(int j = 0; j < numCardsPerSuit;j++) {
				  int x = 0;
					 do {
							x = (int)(Math.random()*(numSuits*numCardsPerSuit));
						 } while(cards[x]== null);
				  cards[x] = new Card(i,j+1);
			  }
		  }
	  }
  }
	/**
	 * Shuffles all the Cards in cards
	 */
  public void shuffle() {
	  if(cards[0] == null)
		  return;
	  if (hand)
		  return;
	    for ( int i = topCard; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = cards[i];
            cards[i] = cards[rand];
            cards[rand] = temp;
        }
  }
	/**
	 * returns the field numSuits
	 * 
	 * @return numSuits is the number of Suits field
	 */
  public int getNumSuits() {
	  return numSuits;
  }
	/**
	 * returns the field numCardsPerSuit
	 * 
	 * @return numCardsPerSuit is the number of cards in every suit
	 */
  public int getNumCardsPerSuit() {
	  return numCardsPerSuit;
  }
	/**
	 * returns the field array cards
	 * 
	 * @return cards is the main part of the class and holds all the Cards
	 */
  public Card[] getCards() {
	  return cards;
  }
	/**
	 * returns the field topCard
	 * 
	 * @return topCard is the index of the top card
	 */
  public int getTopCard() {
	  return topCard;
  }
	/**
	 * returns a string representation on the object
	 * 
	 * @return output a String to replace the default String representation of an object
	 */
  public String toString() {
	  if(cards[0] == null)
		  return null;
	  String out = "";
	  if (hand) {
		  for(int i = 0 ; i < topCard; i++ ) {
			  out += "" + cards[i] + "\n";
		  }
		return out;
	  }
	  for (int i = 0; i < numCardsPerSuit; i++) {
		  for(int j =0; j < numSuits; j++) {
			  out += "" + cards[(j*numCardsPerSuit)+i] + "\t";
		  }
		  out += "\n" ;
	  }
	  return out;
  }
	/**
	 * returns a boolean to show whether or not decks match
	 * 
     * @param other is the other Deck you want to compare
	 * @return boolean true if the decks match false otherwise
	 */
  public boolean equals(Deck other) {
	  if(cards[0] == null)
		  return false;
	  if(topCard != other.getTopCard())
		  return false;
	  for (int i = 0; i<= topCard;i++) {
		  if(!(cards[i].equals(other.getCards()[i]))){
			  return false;
		  }
	  }
	  return true;
  }
	/**
	 * Deals cards out to hands with the right number of cards in each hand
	 * 
     * @param hands is the number of hands to deal
     * @param cph is the cards per hand
	 * @return out an array of decks all containing the same number of Cards
	 */
  public Deck[] deal(int hands, int cph) {
	  if(cards[0] == null)
		  return null;
	  if (hand)
		  return null;
	  if(hands <= 0 || cph <= 0)
		  return null;
	  Deck[] out = new Deck[hands];
	  if(hands*cph>topCard+1)
		  return null;
	  for(int i = 0; i < hands; i ++)
		  out[i] = new Deck(cph);
		  
	  for(int i= 0; i < cph; i++) {
		  for( int j = 0; j < hands; j++) {
			  out[j].getCards()[i] = cards[topCard];
			  cards[topCard] = null;
			  topCard--;
			  if(topCard<0);
			  return null;		  
		  }
	  }
	  return out;
  }
	/**
	 * returns a card randomly picked from the deck
	 * 
	 * @return out a Card that was randomly chosen and removed from the Deck
	 */
  public Card pick() {
	  if(cards[0] == null)
		  return null;
	  int x = 0;
	  Card out = null;
	  x = (int)(Math.random()*(topCard));
	  cards[x]= null;
	  for(int i = x; i<topCard-1; i++) {
		  cards[i] = cards[i+1];
		  cards[i+1]= null;
	  }
	  return out;
  }
	/**
	 * Sorts the deck based on the selection sort algorithm
	 */
  public void selectSort(){
	  if(cards[0] == null)
		  return;
	  if (hand)
		  return;
      
      for (int i = 0; i < topCard ; i++) {
          int index = i;
          for (int j = i + 1; j < topCard; j++) {
              if (cards[j].compareTo(cards[index]) == -1) 
                  index = j;
          }
          Card lowCard = cards[index];  
          cards[index] = cards[i];
          cards[i] = lowCard;
      }
  }

  /**
   *  this method merges the two sub decks back into cards
   *  
   *  @param d1 is the first sub deck
   *  @param d2 is the second sub deck
   *  
   * 
   */

  public Card[] merge (Deck d1, Deck d2) {
	    // create the new deck
	    Card[] result = new Card[d1.cards.length + d2.cards.length];
			
	    int choice;    // records the winner (1 means d1, 2 means d2)
	    int i = 0;     // traverses the first input deck
	    int j = 0;     // traverses the second input deck
			
	    // k traverses the new (merged) deck
	    for (int k = 0; k<result.length; k++) {
	      choice = 1;
				
	      // if d1 is empty, d2 wins; if d2 is empty, d1 wins; otherwise,
	      // compare the two cards
	      if (i == d1.cards.length)
		choice = 2;
	      else if (j == d2.cards.length)
		choice = 1;
	      else if (compy.compare(d1.cards[i], d2.cards[j]) == 1)
		choice = 2;
				
	      // make the new deck refer to the winner card
	      if (choice == 1) {
		result[k] = d1.cards[i];  i++;
	      } else {
		result[k] = d2.cards[j];  j++;
	      }			
	    }
	    return result;
	  }
     /**
      *  the part of the algorithm that is essentially insertion sort inside merge
      */
	  public void mergeSort () {
		  if(cards[0] == null)
			  return;
		  if (hand)
			  return;
	    int mid = (cards.length-1) / 2;
			
	    // divide the deck roughly in half
	    Deck d1 = new Deck (0, mid, cards);
	    Deck d2 = new Deck (mid+1, cards.length-1, cards);

	    // sort the halves (the old sort is a modifier method,
	    // so it has no return value)
	    d1.sort ();
	    d2.sort ();
			
	    // merge the two halves and return the result
	    // (d1 and d2 get garbage collected)
	    cards = merge (d1, d2);
	  }
	     /**
	      *  sorts the small amount of cards
	      */
	  public void sort () {
	    for (int i=0; i<cards.length; i++) {
	    	 int index = i;
	         for (i = i+1; i<cards.length; i++)
	            if (compy.compare (cards[i], cards[index]) == -1)
	  	            index = i;
	         		int j = index;
	          swapCards (i, j);
	    }
	  }
	     /**
	      *  Swaps the place of two cards
	      *  
	      *  @param i is the first of the two cards
	      *  @param j is the second of the two cards
	      */
	  public void swapCards (int i, int j) {
		    Card temp = cards[i];
		    cards[i] = cards[j];
		    cards[j] = temp;
		  }

}