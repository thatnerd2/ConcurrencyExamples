package solutions;

public class BathroomKeys {
	
	static Semaphore manager = new Semaphore(4);
	
	public static void main (String [] args) {
		final Person[] people = new Person[10];
		for (int i = 0; i < people.length; i++) {
			final Person person = new Person();
			people[i] = person;
			person.start();
		}
	}
	
	static class Person extends Thread{
		boolean gottaGo;
		
		public Person () {
			gottaGo = true;
		}
		
		public void run () {
			try {
				tryBathroom();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void tryBathroom () throws InterruptedException {
			while (gottaGo) {
				boolean relief = BathroomKeys.manager.acquire();
				if (relief) {
					Thread.sleep(40);
					System.out.println("Ahhh");
					gottaGo = false;
					BathroomKeys.manager.release();
				}
				else {
					System.out.println("NOOOO");
					Thread.sleep(10);
				}
			}
		}
	}
	
	static class Semaphore {
		private int keys;
		
		public Semaphore (int n) {
			keys = n;
		}
		
		public synchronized boolean acquire () {
			if (keys > 0) {
				keys -= 1;
				return true;
			}
			return false;
		}
		
		public synchronized void release () {
			keys += 1;
		}
	}
}
