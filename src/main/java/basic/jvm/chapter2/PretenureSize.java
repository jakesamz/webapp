package basic.jvm.chapter2;

/**
 * 大对象直接进入老年代
 * 1. 适合serial和ParNew收集器
 * 2. 不适用Parallel Scavenge收集器
 * 
 * XX:PretenureSizeThreshold=3145728 -XX:+UseSerialGC
 * or
 * XX:PretenureSizeThreshold=3145728 -XX:+UseParNewGC
 * @author Administrator
 *
 */
public class PretenureSize {
	
	private static final int _1MB = 1024*1024;
	
	public static void main(String[] args) {
		
		byte[] allocation1 = new byte[4 * _1MB];
		
	}

}
