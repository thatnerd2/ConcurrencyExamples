package benefits;

import java.util.Scanner;

public class PrimeFinderTest {
	/* Results:
	 * 
	 * Start: 3
	 * End: 10000
	 * Time Single: 6
	 * Time Multi: 8
	 * 
	 * Start: 3
	 * End: 100000
	 * Time Single: 33
	 * Time Multi: 21
	 * 
	 * Start: 3
	 * End: 1000000 (1 million)
	 * Time Single: 321
 	 * Time Multi: 227
	 * 
	 * Start: 3
	 * End: 10000000 (10 million)
	 * Time Single: 7642
	 * Time Multi: 5597
	 * 
	 * Start: 3
	 * End: 100000000
	 * Time Single: 203246
	 * Time Multi: 147968
	 * 
	 */
	
	static int[] range;
	public static void main (String [] args) {
		range = getInput();
		PrimeFinderSingle.execute(range);
	}
	
	public static void continueTesting () {
		PrimeFinderMulti.execute(range);
	}
	
	public static int[] getInput () {
		int[] res = new int[2];
		Scanner scan = new Scanner (System.in);
		System.out.print("Start: ");
		res[0] = scan.nextInt();
		System.out.print("\nEnd: ");
		res[1] = scan.nextInt();
		scan.close();
		return res;
	}
}
