package traps;

public class UnsafeSequence {
	private int integer;
	
	public UnsafeSequence () {
		integer = 5;
	}
	
	//Read modify write race condition!
	public synchronized int getNext () {
		return integer++;
	}
}
