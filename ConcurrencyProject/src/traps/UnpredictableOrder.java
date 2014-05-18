package traps;

public class UnpredictableOrder {
	public static int integer;
	private static UnpredictableOrder factory = new UnpredictableOrder();
	
	public static void main (String [] args) {
		integer = 5;
		Incrementer i = factory.new Incrementer ("i");
		Incrementer j = factory.new Incrementer ("j");
		i.start();
		j.start();		
	}
	
	//Multiple problems: race condition, unreliability of who gets there first.
	public static int getNext () {
		return integer++;
	}
	
	class Incrementer extends Thread {
		private String name;
		public Incrementer (String n) {
			name = n;
		}
		
		public void run () {
			System.out.println(name + ": " + UnpredictableOrder.getNext());
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
