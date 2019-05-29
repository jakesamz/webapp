package basic.gc;

public class ReferenceCountingGC {
	
	public Object i;
	
	private static final int _1mb = 1024*1024;
	private byte[] s = new byte[2*_1mb];
	public static void  main(String args[]) {
		
		ReferenceCountingGC t1 = new ReferenceCountingGC();
		ReferenceCountingGC t2 = new ReferenceCountingGC();
		t1.i = t2;
		t2.i = t1;
		
		t1 = null;
		t2 = null;
		
		System.gc();
	}
	
	
}
