package solutions;

public class RubberChicken {
	private static Object chicken = new Object();
	
	public static void speak (String name) {
		synchronized (chicken) {
			System.out.println(name+": WOOOO");
			System.out.println(name+": WAOAH");
			System.out.println(name+": WHEEE");
			System.out.println("------------------");
		}
	}
	
	public static synchronized void speakBlock (String name) { //holds "this" as lock.
		System.out.println(name+": WOOOO");
		System.out.println(name+": WAOAH");
		System.out.println(name+": WHEEE");
		System.out.println("------------------");
	}
	
	public static void haphazardSpeak (String name) {
		System.out.println(name+": WOOOO");
		System.out.println(name+": WAOAH");
		System.out.println(name+": WHEEE");
		System.out.println("------------------");
	}
	
	public static void combinationSpeak (String name) { //Sometimes the other will interrupt with whee and ----
		synchronized (chicken) {
			System.out.println("**************");
			System.out.println(name+": WOOOO");
			System.out.println(name+": WAOAH");
			System.out.println("**************");
		}
		System.out.println(name+": WHEEE");
		System.out.println("------------------");
	}
	
	public static void main (String [] args) {
		final Person bob = new Person ("Bob");
		final Person josiah = new Person ("Josiah");
		
		new Thread(new Runnable () {
			public void run () {
				bob.talk();
			}
		}).start();
		
		new Thread(new Runnable () {
			public void run () {
				josiah.talk();
			}
		}).start();
	}
	
	static class Person {
		String name;
		
		public Person (String n) {
			name = n;
		}
		
		public void talk () {
			for (int i = 0; i < 5; i++) {
				RubberChicken.speak(name);
				//RubberChicken.speakBlock(name);
				//RubberChicken.haphazardSpeak(name);
				//RubberChicken.combinationSpeak(name);
			}
		
		}
	}
}
