/**
 * This class is the tester for the assignment Card Sorting
 *  
 * @author WinstanleyA
 * @Date 10/4/17
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSMain {
	/** 
	 *  returns a PrintWriter to write the out to a text file
	 *  
	 * @param fNme the name of the file your writing to
	 * @return input a PrintWriter which will be able to write to the file given in fNme
	 */
	public static PrintWriter readerW(String fNme) {
		File scannable = new File( fNme );
		PrintWriter input = null;
		try {
			input = new PrintWriter(scannable);
		} catch (FileNotFoundException ex) {
			System.out.println("Cant open file: " + fNme);
			return null;
		}
		return input;
	}
	/** 
	 * main method to test my classes 
	 * 
	 * @param args is the names of all the files you want to use in this program
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Deck d1 = new Deck(false);
        PrintWriter out = readerW(args[0]);
        System.out.print(d1);

		File file = new File("out.txt");

		try {	
			out = new PrintWriter(file);	
		} catch (FileNotFoundException ex) {}
		  
		Card tComp1 = new Card(0, 2);
		Card tComp2 = new Card(2, 3);
		
		CardComp compy = new CardComp();
		
		out.println("-------Comparator test-------");
		out.println(tComp1);
		out.println("Should be greater than:");
		out.println(tComp2);
		out.println("The results");
		out.println(compy.compare(tComp1, tComp2));
		out.println();
		out.println("key: 1 = 1st greater than 2nd");
		out.println("     0 = they equal");
		out.println("    -1 = 1st less than 2nd");
		out.println();
		out.println();	
		Deck breakThisCode = new Deck(false);
		out.println("-------Pick Method Test-------");
		out.println("Initial Deck");
		out.println(breakThisCode);
		out.println();
		out.println("This is the card that was dealt from the Deck:");
		out.println(breakThisCode.pick());
		out.println("Now it should be missing from the deck because it was pulled out");
		out.println("Results:");
		out.println(breakThisCode);
		out.println();
		out.println();
		out.println("-------Deal Method Test-------");
		out.println("Initial Deck");
		out.println(breakThisCode);
		out.println();
		out.println("Now We ask it to deal out -2 hands with 3 cards in each");
		out.println("Results:");
		try {
			breakThisCode.deal(-2, 3);
		} catch (NegativeArraySizeException e) {
			out.println("NegativeArraySizeException "+ e.getMessage());
		}
		out.println();
		out.println();
		out.close();
        out.close();
        
	}

}
