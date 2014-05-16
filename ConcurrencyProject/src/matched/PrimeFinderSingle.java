package matched;

import java.util.ArrayList;

public class PrimeFinderSingle {
	public static void execute (int[] r) {
		int[] range = r;
		int min = range[0];
		int max = range[1];
		
		long timeBefore = System.currentTimeMillis();
		
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
		
		System.out.println("Time Single: "+(System.currentTimeMillis() - timeBefore));
		PrimeFinderTest.continueTesting();
	}
}
