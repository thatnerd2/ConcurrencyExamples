package examples;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeFinderSingle {
	public static void main (String [] args) {
		int[] range = getInput();
		int min = range[0];
		int max = range[1];
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = min; i <= max; i++) {
			if (i % 2 == 0) {
				continue;
			}
			boolean isPrime = true;
			int limit = (int)(Math.sqrt(i) + 1);
			for (int j = 3; j < limit; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(i);
			}
		}
		System.out.println(primes);
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
