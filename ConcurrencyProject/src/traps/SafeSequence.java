package traps;

public class SafeSequence {
	private int integer;
	
	public SafeSequence () {
		integer = 5;
	}
	
	public synchronized int getNext () {
		return integer++;
	}
}
