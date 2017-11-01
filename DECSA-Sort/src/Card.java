/**
 * 
 * This class I made last year in one of our labs and I modified it to work for this assignment
 * 
 * @author WinstanleyA
 * @Date 10/4/17
 */
public class Card implements Comparable<Card> {
	
	private String suit;
	private int rank;
	/**
	 * 
	 * just the plain old default constructor
	 * 
	 * @param none
	 */
    public Card() {
    	suit = "spades";
    	rank = 1;
    }
	/**
	 * Simple constructor for when the user already has the right data types
	 * 
	 * @param cardRank the rank in an int
	 * @param cardSuit the suit in a String
	 */
	public Card(String cardSuit, int cardRank) {
		if(cardRank<= 0)
			return;
		rank = cardRank;
		suit = cardSuit;
	}
	/**
	 * 
	 * constructor for inputing the suit as an int
	 * 
	 * @param cardRank the rank in an int
	 * @param cardSuit the suit in an int
	 */
    public Card(int cardSuit, int cardRank) {
    	   String s ="";
    	switch(cardSuit){
    		case 0: s = "clubs";
    				break;
    		case 1: s = "diamonds";
					break;
    		case 2: s = "hearts";
					break;
    		case 3: s = "spades";
					break;
			default: s ="invalid suit pick a number between 0 and 3";
					break;
    	}	
	    	suit = s;
	    	rank = cardRank;
	}
	/**
	 * 
	 * For user inputing the rank as a String
	 * 
	 * @param cardRank the rank in a String
	 * @param cardSuit the suit in a String
	 */
    public Card(String cardSuit, String cardRank) {
	    	suit = cardSuit;
	    	rank = Integer.valueOf(cardRank);
	    	
	}
	/**
	 * For the people who want to input the data in the opposite type
	 * 
	 * @param cardRank the rank in a String
	 * @param cardSuit the suit in an int
	 */
	public Card(int cardSuit, String cardRank) {
	 	   String s ="";
	    	switch(cardSuit){
	    		case 0: s = "clubs";
	    				break;
	    		case 1: s = "diamonds";
						break;
	    		case 2: s = "hearts";
						break;
	    		case 3: s = "spades";
						break;
				default: s ="invalid suit pick a number between 0 and 3";
						break;
	    	}	
		    	suit = s;
		    	rank = Integer.valueOf(cardRank);
	}
	/**
	 *  returns the value of the field suit as a String
	 *  
	 * @return suit is the suit field
	 */
	public String getSuit() {
		return suit;
	}
	/**
	 *  returns the value of the field rank as an int
	 *  
	 * @return rank is the rank field
	 */
	public int getRank() {
		return rank;
	}
	/**
	 *  returns the value of the field rank as a String
	 *  
	 * @return output is the rank in a String
	 */
	public String getRankStr() {
		String output = "";
		switch(rank){
		case 1: output = "Ace";
				break;
		case 2: output = "Two";
				break;
		case 3: output = "Three";
				break;
		case 4: output = "Four";
				break;
		case 5: output = "Five";
				break;
		case 6: output = "Six";
				break;
		case 7: output = "Seven";
				break;
		case 8: output = "Eight";
				break;
		case 9: output = "Nine";
				break;
		case 10: output = "Ten";
				break;
		case 11: output = "Jack";
				break;
		case 12: output = "Queen";
				break;
		case 13: output = "King";
				break;
		default: output = "Invalid Card number";
				break;
		}
		return output;
	}
	/**
	 *  returns the value of the field suit as an int
	 *  
	 * @return s is the suit as an int
	 */
	public int getSuitInt() {
		int s = 0;
		switch(suit){
		case "clubs": s = 0;
				break;
		case "diamonds": s = 1;
				break;
		case "hearts": s = 2;
				break;
		case "spades": s = 3;
				break;
	}	
		return s;
	}
	/**
	 *  returns whether or not the cards match
	 *  
     * @param otherCard is the other Card you want to compare
	 * @return boolean true if the cards match false otherwise
	 */
	public boolean equals(Card otherCard) {
		return otherCard.getSuit().equals(this.getSuit())
			&& otherCard.getRank()==(this.getRank());
	}
	/**
	 *  returns the object in its string representation
	 *
	 * @return output a String to replace the default String representation of an object
	 */
	@Override 
	public String toString() {
		String output = "";
	 	switch(rank){
		case 1: output = "Ace";
				break;
		case 2: output = "Two";
				break;
		case 3: output = "Three";
				break;
		case 4: output = "Four";
				break;
		case 5: output = "Five";
				break;
		case 6: output = "Six";
				break;
		case 7: output = "Seven";
				break;
		case 8: output = "Eight";
				break;
		case 9: output = "Nine";
				break;
		case 10: output = "Ten";
				break;
		case 11: output = "Jack";
				break;
		case 12: output = "Queen";
				break;
		case 13: output = "King";
				break;
		default: output = "Invalid Card Number";
				break;
	}	
		return output + " of " + suit;
	}
	/**
	 *  returns an integer representation of the difference between this object and another of the
	 *  same class
	 * 
     * @param other is the Card you want to compare to this one
	 * @return int 1 if this is greater than other 0 if they are equal -1 if this is less than other
	 */
	@Override
	public int compareTo(Card other) {
		  if (getSuitInt()>other.getSuitInt())
		         return 1;
		  if(getSuitInt()==other.getSuitInt()) {
				  if (rank>other.getRank())
				         return 1;
				      if(this.equals(other))
				         return 0;
				      return -1;
		      }
		      return -1;
		}

}