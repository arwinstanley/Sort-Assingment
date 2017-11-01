/**
 * This class is for comparing things even though I mostly used the compareTo in Card
 * 
 * @author WinstanleyA
 * @Date 10/4/17
 */
import java.util.Comparator;
public class CardComp implements Comparator<Card>{
	/** 
	 *  returns an integer representation of the difference between this object and another of the
	 *  same class
	 *  
	 * @param c1 is the first card you want to compare
	 * @param c2 is the second card you want to compare
	 * @return 1 for greater than 0 for equal -1 for less than
	 */
   public int  compare(Card c1, Card c2){
      if (c1.getRank()<c2.getRank())
         return -1;
      if(equals(c1, c2))
         return 0;
      return 1;
   }
	/** 
	 *  returns whether or not this object matches another one of the same class
	 *  
	 * @param obj1 is the first card you want to compare
	 * @param obj2 is the second card you want to compare
	 * @return true if they are equal false if not
	 */
   public boolean equals(Object obj1, Object obj2) {
	   if (((Card)obj1).getRank()==((Card)obj2).getRank()&&((Card)obj1).getSuit().equals(((Card)obj2).getSuit())) {
		   return true;
	   }
	   return false;
   }
}