package matched;

import java.util.ArrayList;

public class PrimeFinderMulti {
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	static long timeBefore;
	static Finder lower;
	static Finder higher;
	public static void execute (int[] r) {
		int[] range = r;
		
		int min = range[0];
		int max = range[1];
		int middle = (int)(max*0.8);
		
		timeBefore = System.currentTimeMillis();
		
		lower = new PrimeFinderMulti().new Finder(min, middle);
		higher = new PrimeFinderMulti().new Finder(middle + 1, max);
		lower.start();
		higher.start();
	}
	
	public static synchronized void addToPrimeList (ArrayList<Integer> list) {
		boolean isFinished = (primes.size() == 0) ? false : true;
		primes.addAll(list);
		if (isFinished) {
			System.out.println("Time Multi: "+(System.currentTimeMillis() - timeBefore));
		}
		
	}
	
	class Finder extends Thread {
		int start;
		int end;
		public Finder (int min, int max) {
			start = min;
			end = max;
		}
		
		public void run () {
			
			ArrayList<Integer> primes = new ArrayList<Integer>();
			for (int i = start; i <= end; i++) {
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
			
			PrimeFinderMulti.addToPrimeList(primes);
			this.interrupt();
		}
	}

}
