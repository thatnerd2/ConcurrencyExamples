package traps;

public class UnsafeSequence {
	private int integer;
	
	public UnsafeSequence () {
		integer = 5;
	}
	
	//Read modify write race condition!
	public int getNext () {
		return integer++;
	}
}
