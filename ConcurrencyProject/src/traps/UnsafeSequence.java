package traps;

public class UnsafeSequence {
	private int integer;
	
	public UnsafeSequence () {
		integer = 5;
	}
	
	public synchronized int getNext () {
		return integer++;
	}
}
