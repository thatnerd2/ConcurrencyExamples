package traps;


public class UnsafeCombinationSequence {
	public static int integer;
	private static UnsafeCombinationSequence factory = new UnsafeCombinationSequence();
	
	public static void main (String [] args) {
		
		for (int k = 0; k < 5; k++) {
			integer = 5;
			Incrementer i = factory.new Incrementer ("i");
			Incrementer j = factory.new Incrementer ("j");
			i.start();
			j.start();
			System.out.println("----------");
		}
		
		
	}
	
	public static int getNext () {
		return integer++;
	}
	
	class Incrementer extends Thread {
		private String name;
		public Incrementer (String n) {
			name = n;
		}
		
		public void run () {
			System.out.println(name + ": " + UnsafeSequence.getNext());
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
