package traps;

public class HusbandWifeDining {
	/**
	 *  
	 * @author Aaron Chan
	 * @info Livelock Example
	 */
	static class Spoon {
		Diner owner;
		
		public Spoon (Diner first) {
			owner = first;
		}
		
		public void use () {
			System.out.println("The spoon was used");
		}
		public void setOwner (Diner d) {
			owner = d;
		}
	}
	
	static class Diner {
		private boolean isHungry;
		private String name;
		
		public Diner (String n) {
			name = n;
			isHungry = true;
		}
		
		public void eatWith (Spoon spoon, Diner other) {
			System.out.println("hey");
			while (isHungry) {
				if (!spoon.owner.equals(this)) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					continue;
				}
				
				if (other.isHungry()) {
					System.out.println("No no, you have it, "+name);
					spoon.setOwner(other);
					continue;
				}
				
				spoon.use();
				isHungry = false;
				System.out.println("I, "+name+", have eaten.");
				spoon.setOwner(other);
			}
		}
		
		public boolean isHungry () {
			return isHungry;
		}
	}
	
	public static void main (String [] args) {
		final Diner husband = new Diner ("Joe"); //final so that if main ends, thread doesn't try to access gone values.
		final Diner wife = new Diner ("Catherine");
		final Spoon spoon = new Spoon (husband);
		
		new Thread(new Runnable () {
			public void run () {
				husband.eatWith(spoon, wife);
			}
		}).start();
		
		new Thread(new Runnable () {
			public void run () {
				wife.eatWith(spoon, husband);
			}
		}).start();
	}
}
