package traps;

public class SafeSequence {
	public static int integer;
	private static SafeSequence factory = new SafeSequence();
	
	public static void main (String [] args) {
		integer = 5;
		Incrementer i = factory.new Incrementer ("i");
		Incrementer j = factory.new Incrementer ("j");
		i.start();
		j.start();		
	}
	
	public static synchronized int getNext () {
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
