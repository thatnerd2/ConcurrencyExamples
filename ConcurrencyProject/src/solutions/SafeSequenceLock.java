package solutions;

public class SafeSequenceLock {
	private int integer;
	
	public SafeSequenceLock () {
		integer = 5;
	}
	
	public synchronized int getNext () {
		return integer++;
	}
}
