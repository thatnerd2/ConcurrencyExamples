package traps;

public class LazyInitialization {
	private ExpensiveObject instance = null;
	
	public ExpensiveObject getInstance () {
		if (instance == null) {
			instance = new ExpensiveObject();
		}
		return instance;
	}
	
	static class ExpensiveObject {
		public ExpensiveObject  () {
			System.out.println("I AM EXPENSIVE.");
		}
	}
}
