package solutions;

import java.util.concurrent.atomic.AtomicInteger;

public class SafeSequenceAtomic {
	private AtomicInteger integer;
	
	public SafeSequenceAtomic () {
		integer.set(5);
	}
	
	public synchronized int getNext () {
		return integer.getAndIncrement(); //Inner lock
	}
}
